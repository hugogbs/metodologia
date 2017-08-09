#!/bin/sh

#The name of the jar file thaat contains the algorithm
algorithm=$1
#The input for executing that algorithm
input=$2
output=$3

## Permform some validation on input arguments, one example below
if [ -z "$1" ] || [ -z "$2" ]; then
        echo "Missing arguments, exiting.."
        echo "Usage : $0 arg1 arg2"
        exit 1
fi

java -jar $algorithm $input $output
