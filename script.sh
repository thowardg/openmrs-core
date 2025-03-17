#!/bin/bash

# Number of iterations
ITERATIONS=100

for ((i=1; i<=ITERATIONS; i++))
do
    echo "Starting iteration $i..."

    # Start powerstat in the background with a 0.5 second interval and redirect output to a unique file
    powerstat -R -H -n  0.5 > "powerstat_output_$i.txt" 2>&1 &
    POWERSTAT_PID=$!  # Save the PID of the powerstat process

    # Run the Docker container in detached mode
    CONTAINER_ID=$(docker run -d open-o)

    # Sleep for 30 seconds while powerstat is running
    echo "Powerstat will run for 30 seconds..."
    sleep 30

    # Stop the powerstat process
    echo "Stopping powerstat..."
    kill $POWERSTAT_PID

    # Stop the Docker container
    echo "Stopping the Docker container..."
    docker stop $CONTAINER_ID

    # Ensure the container is removed to avoid conflicts in the next iteration
    docker rm $CONTAINER_ID

    # Add a small delay before the next iteration to ensure everything is cleaned up
    sleep 5

    echo "Iteration $i completed."
done

echo "All iterations completed."
