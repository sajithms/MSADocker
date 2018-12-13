#!/bin/sh
echo "***********************************************************************"
echo "Starting the customer service"
echo "***********************************************************************"

while ! curl  10.0.75.1:4000/oauth-server/default; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! curl  10.0.75.1:5000/; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
while ! curl  10.0.75.1:7000/; do
    echo "Waiting for the Oauth Server"
    sleep 3
done
java -jar /opt/lib/customer-service.jar --spring.config.location=file:/var/lib/customer-service/bootstrap.properties
