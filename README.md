This is just a basic POC for KAFKA and Sharing of data between different microservices using Spring Boot.
***********************************************************************************************************

Customer microservice sends the the JSON to be saved in the product microservice. After success/failed transaction
it gets a notification from Products Microservice. It also gets all the list of products saved in the product microservice
using RestTemplate. Find the Product microservice here https://github.com/jyotimoydas/kafkaPocProducts


Products microservice, fetching data from the customer(bestBuy) microservice using @kafkaListener and saving the data into the DB.
On successfull save operation, it sends a notification to the customer microservice using KafkaTemplate.
Find the customer microservice here https://github.com/jyotimoydas/kafkaPocCustomer

kafka cmd commands:

For Zookeeper:

zookeeper-server-start.bat ..\..\config\zookeeper.properties

For kafka Server:

kafka-server-start.bat ..\..\config\server.properties
