package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * 消费者测试
 */
public class MyConsumer {
    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        String topic="test1";

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.46.10:9092");
        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //间隔多长时间自动提交
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        //反序列化配置
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group11");

        //配置每次启动时从哪里消费(两个场景下会生效：1 当前消费者组第一次消费；2 offset过期不存在了 )
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");  //只能放两个值  1 earliest ; 2 latest



        //创建消费者
        KafkaConsumer<String,String> consumer=new KafkaConsumer(properties);
        
        //订阅多个主题
        consumer.subscribe(Arrays.asList("test1","test2"));




        while(true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("消费者：topic：" + consumerRecord.topic() + "------key:" + consumerRecord.key() + "------value:" + consumerRecord.value());
            }

            Thread.sleep(3000);

        }


    }
}
