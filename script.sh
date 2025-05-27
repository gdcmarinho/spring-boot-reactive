#!/bin/bash

TARGET_URL="http://localhost:8080/join"
NUM_REQUESTS=1600
MAX_PARALLEL_JOBS=100
CURL_TIMEOUT=5

echo "----------------------------------------------------"
echo "HTTP Load Generation Script"
echo "----------------------------------------------------"
echo "Target URL:         $TARGET_URL"
echo "Number of Requests: $NUM_REQUESTS"
echo "Parallel Jobs:      $MAX_PARALLEL_JOBS"
echo "Curl Timeout:       ${CURL_TIMEOUT}s per request"
echo "----------------------------------------------------"
echo ""
echo "Starting requests. This may take a moment..."

start_time_sec=$(date +%s)

yes "$TARGET_URL" | head -n "$NUM_REQUESTS" | xargs -P "$MAX_PARALLEL_JOBS" -I {} \
    curl --max-time "$CURL_TIMEOUT" -s -o /dev/null {}

end_time_sec=$(date +%s)
duration_sec=$((end_time_sec - start_time_sec))

echo ""
echo "----------------------------------------------------"
echo "Results"
echo "----------------------------------------------------"
echo "Finished sending $NUM_REQUESTS requests."
echo "Total time taken: $duration_sec seconds."

if [ "$duration_sec" -le 0 ]; then
    if [ "$NUM_REQUESTS" -gt 0 ]; then
        echo "All $NUM_REQUESTS requests completed in less than 1 second or within the same second."
    fi
else
    if command -v bc > /dev/null; then
        rps=$(echo "scale=2; $NUM_REQUESTS / $duration_sec" | bc)
        echo "Approximate Requests Per Second (RPS): $rps"
    else
        rps_int=$((NUM_REQUESTS / duration_sec))
        echo "Approximate Requests Per Second (RPS): $rps_int (integer division)"
    fi
fi

if [ "$duration_sec" -le 60 ]; then
    echo ""
    echo "SUCCESS: At least $NUM_REQUESTS requests were made within 60 seconds (actual time: ${duration_sec}s)."
else
    echo ""
    echo "NOTICE: $NUM_REQUESTS requests were made, but it took ${duration_sec}s, which is more than the 60-second target."
    echo "To meet the target, consider:"
    echo "  1. Increasing MAX_PARALLEL_JOBS in the script."
    echo "  2. Checking the performance/capacity of the server at $TARGET_URL."
    echo "  3. Ensuring your machine has enough resources (CPU/network)."
fi
echo "----------------------------------------------------"