#!/bin/sh

# Script to build and run all services

# to run this script: chmod +x run.sh && bash ./run.sh

# You need to have installed: maven, java 21
# if you are a windows user, you will need to install all of this in your wsl

await() {
    number=$1

    i=0
    echo ""
    while [ "$i" -lt "$number" ]; do
        echo -n "."
        i=$((i + 1))
        sleep 1
    done
    echo ""
}

clear
echo "Building and starting all services"
echo "This may take a while..."

(docker compose up > /dev/null 2>&1) &
await 20

dependencies=(
    common
)

for dependency in "${dependencies[@]}"; do
        echo ""
        echo "Building and installing $dependency"
        (cd "./$dependency" && mvn package) > /dev/null 2>&1
        (cd "./$dependency" && mvn install) > /dev/null 2>&1
done

services=(
    registry-server 
    config-server
)

for service in "${services[@]}"; do
    echo ""
    echo "Starting $service"
    (cd "./$service" && mvn spring-boot:run > /dev/null 2>&1) &
    await 20
done

services=(
    auth-server
    forum-server
    report-server
    gateway
)

for service in "${services[@]}"; do
    echo ""
    echo "Starting $service"
    (cd "./$service" && mvn spring-boot:run > /dev/null 2>&1) &
    await 5
done

await 20

clear

echo "If everything went well, the services should be running... Do not close this terminal."
echo "To stop all services, press Ctrl + C"
echo ""
echo "Developed by: 2piradrian"

wait
