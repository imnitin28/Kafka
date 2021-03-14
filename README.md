# Kafka
**Kafka version** : kafka_2.13-2.7.0
Move to your kafka directory and open two terminals the run the following commands, 

**Terminal -1**
1. Starting the zoo-keeper
$ bin/zookeeper-server-start.sh config/zookeeper.properties

**Terminal -2**
2. Starting the Kafka Server
$ bin/kafka-server-start.sh config/server.properties

After this, open the project and run Producer.java and after that run Consumer.java
Producer.java will send the records and Consumer.java will recieve the data and will sink it to a file named Records.txt
