#!/bin/sh

# Script to build and run all services in the correct order
## You need to have: maven, java 21, docker and docker compose

dependencies=(
    common
)

for dependency in "${dependencies[@]}"; do
        echo "Building and installing $dependency"
        (cd "./$dependency" && mvn package)
        (cd "./$dependency" && mvn install)
done

services=(
    registry-server 
    config-server
    )

for service in "${services[@]}"; do
    echo "Starting $service"
    (cd "./$service" && mvn spring-boot:run) &
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
    (cd "./$service" && mvn spring-boot:run) &
    sleep 5
done

wait