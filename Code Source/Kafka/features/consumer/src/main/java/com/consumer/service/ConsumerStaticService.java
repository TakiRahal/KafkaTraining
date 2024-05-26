package com.consumer.service;

import com.common.SharedData;
import com.common.statically.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerStaticService {


    @KafkaListener(
            topics = SharedData.topicName,
            groupId = SharedData.groupId
    )
    public void readMessage(String message){
        log.error("readMessage {} ", message);
    }

    @KafkaListener(
            topics = SharedData.topicName,
            groupId = SharedData.groupId
    )
    public void readMessagePost(String message) throws JsonProcessingException {
        log.error("readMessage {} ", message);
        ObjectMapper objectMapper = new ObjectMapper();
        Post post = objectMapper.readValue(message, Post.class);
        log.error("post readMessage {} ", post.getTitle());
    }
}
