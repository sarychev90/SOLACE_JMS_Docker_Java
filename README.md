# SOLACE JMS DOCKER JAVA SPRING BOOT

This is a simple dockerized project to implement a Java Spring Boot message producer and consumer (publisher and subscriber) through a Solace PubSub+ Standard Edition. 
For more details please use link: https://solace.com/products/event-broker/software/getting-started/

## What you need to run the application
1. Run modules in docker containers
2. Configure and set-up destination for JMS

## How to run modules
1. Clone project from GitHub
2. Starting Docker on your machine
3. Run the command line from the parent folder of the project
4. Run the following command:

	docker-compose up

Note: if you have some problem with Solace port 55555 access permissions on Windows machine please use link for fix: https://solace.community/discussion/929/docker-port-55555-not-available-on-windows

## Set-up destination through Solace PubSub+ Broker Manager
1. Open a browser and enter this URL (Solace PubSub+ Broker Manager): http://localhost:8080
2. Log in as user admin with password admin
3. Choose the Message VPN (Settings)
4. Navigate to Queues and click "+Queue"
5. Set name "notification.queue" for new queue and click "Apply"
