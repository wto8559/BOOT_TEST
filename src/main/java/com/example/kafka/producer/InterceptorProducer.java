package com.example.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Properties;

/**
 * kafka 带拦截器的生产者
 */
public class InterceptorProducer {
    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.46.10:9092");
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        properties.put(ProducerConfig.RETRIES_CONFIG,5);
        //批次大小
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);
        //缓冲区大小
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        //key ,value 的序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");


        //添加拦截器
        ArrayList<String> interceptorList=new ArrayList<>();
        interceptorList.add("com.example.kafka.interceptor.TimeInterceptor");
        //interceptorList.add("");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,interceptorList);


        KafkaProducer<String,String> producer=new KafkaProducer(properties);

        String topic="test1";
        String key="key2";

        for (int i=0;i<10;i++){
            producer.send(new ProducerRecord<String, String>(topic,key,topic + i+" new"), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if(exception==null){
                        System.out.println(metadata.partition()+" --- "+metadata.offset());
                    }else{
                        exception.printStackTrace();
                    }
                }
            });
        }

        Thread.sleep(3000);
        System.out.println("******************producer End**************************");


        //关闭资源
        producer.close();


    }
}
