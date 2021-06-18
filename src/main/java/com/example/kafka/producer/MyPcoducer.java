package com.example.kafka.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * kafak 生产者测试
 */
public class MyPcoducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String topic="test";
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.46.10:9092");
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        properties.put(ProducerConfig.RETRIES_CONFIG,5);
        //批次大小
        //properties.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);
        //缓冲区大小
        //properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        //key ,value 的序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> producer=new KafkaProducer(properties);

        for (int i=10;i<100;i=i+10){
            producer.send(new ProducerRecord<String, String>(topic,"testtopic"+i));
        }

        //关闭资源
        producer.close();


    }
}