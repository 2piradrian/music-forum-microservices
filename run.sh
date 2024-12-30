#!/bin/sh

# Script to build and run all services

# to run this script: chmod +x run.sh && sh ./run.sh
# (remember run before: docker compose up)

# You need to have installed: maven, java 21
# if you are a windows user, you will need to install all of this in your wsl

clear
echo "Building and starting all services"
echo "This may take a while..."
echo

dependencies=(
    common
)

for dependency in "${dependencies[@]}"; do
        echo "Building and installing $dependency"
        (cd "./$dependency" && mvn package) > /dev/null 2>&1
        (cd "./$dependency" && mvn install) > /dev/null 2>&1
done

services=(
    registry-server 
    config-server
)

for service in "${services[@]}"; do
    echo "Starting $service"
    (cd "./$service" && mvn spring-boot:run > /dev/null 2>&1) &
    sleep 20
done

services=(
    auth-server
    forum-server
    report-listener
    report-server
    gateway
)

for service in "${services[@]}"; do
    echo "Starting $service"
    (cd "./$service" && mvn spring-boot:run > /dev/null 2>&1) &
    sleep 5
done

echo

for i in {1..20}; do
    sleep 1
    echo -n "."
done

clear

echo "If everything went well, the services should be running... Do not close this terminal."
echo "To stop all services, press Ctrl + C"
echo
echo "Developed by: 2piradrian"

wait
