package com.knoldus.producer;

import com.knoldus.model.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class Producer {
    public static void main(String[] args){
        // For example 192.168.1.1:9092,192.168.1.2:9092
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.knoldus.serializer.UserSerializer");
        KafkaProducer<String, User> producer = new KafkaProducer<>(properties);
        //generate and send records for 4001 users along with hardcoded name i.e Nitin Mishra, random user age and hard coded course.
        try {
            Random rand = new Random();
            for (int i = 1000; i <= 5000; i++) {

                User user = new User(i, "Nitin Mishra", rand.nextInt(10)+2, "MCA");
                producer.send(new ProducerRecord<String, User>("UserTopic", String.valueOf(i), user));
                System.out.println("Message " + user.toString() + " sent...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.close(); //producer must be closed to not leak resources,i.e., connections, thread pools, buffers
        }
    }
}
