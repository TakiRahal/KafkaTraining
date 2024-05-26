package com.kafka.training.producer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class TrainingProducer {

    @Value( "${topic-name}" )
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(){

    }
}
