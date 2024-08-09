#!/bin/bash

# Compile the correct version
gcc -o tcas_correct tcas_Correct.c

# Compile the incorrect version
gcc -o tcas_incorrect tcas_Incorrect.c

# Files to store passing and failing test cases
passing_file="Passing_test_cases.txt"
failing_file="Failing_test_cases.txt"

# Clear the content of the files if they exist
> $passing_file
> $failing_file

# Function to run a test case
run_test_case() {
    local test_case=$1

    # Run the correct version
    ./tcas_correct $test_case > correct_output.txt

    # Run the incorrect version
    ./tcas_incorrect $test_case > incorrect_output.txt

    # Compare outputs
    if diff correct_output.txt incorrect_output.txt > /dev/null; then
        echo $test_case >> $passing_file
    else
        echo $test_case >> $failing_file
    fi
}

# Read and run each test case from the cas-tests.txt file
while IFS= read -r test_case; do
    run_test_case "$test_case"
done < cas-tests.txt

echo "Test case categorization completed."
