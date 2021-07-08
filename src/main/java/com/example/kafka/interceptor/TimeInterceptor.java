package com.example.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Map;

/**
 * kafka 生产者拦截器测试
 */
public class TimeInterceptor implements ProducerInterceptor<String,String> {

    int success;
    int errors;


    /**
     * 发送前值前加时间戳
     * @param record
     * @return
     */
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        String value= System.currentTimeMillis()+","+record.value();
        return new ProducerRecord<String, String>(record.topic(),record.partition(),record.key(),value);
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

        if(metadata!=null){
            //说明消息发送成功
            success++;
        }else{
            errors++;

        }

    }

    @Override
    public void close() {
        System.out.println("------success--------"+success);
        System.out.println("------errors--------"+errors);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
