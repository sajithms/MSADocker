#!/bin/sh
echo "***********************************************************************"
echo "Starting the oauth process"
echo "***********************************************************************"

while ! curl  10.0.75.1:4000/oauth-server/default; do
    echo "Waiting for the Config Server"
    sleep 3
done

java -jar /opt/lib/eureka-server.jar --spring.config.location=file:/var/lib/eureka-server/bootstrap.properties

