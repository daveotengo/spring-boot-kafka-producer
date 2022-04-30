# spring-boot-kafka-producer
Kafka producer sending messages after successfully receiving a rest call

Instructions

1. Have your Zookeeper runing with the below commands

bin/zookeeper-server-start.sh config/zookeeper.properties

2.Have your Kafka Server runnning  with the below commands.
bin/kafka-server-start.sh config/server.properties

3.Start your springboot kafka producer application.

4.Start your kafka consumer with the following commands.
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_Example --from-beginning

5. Make a rest call with the following request

{
    "name":"David",
    "dept":"Technology"
}

to the following endpoint

192.168.100.6:8080/kafka/publish

