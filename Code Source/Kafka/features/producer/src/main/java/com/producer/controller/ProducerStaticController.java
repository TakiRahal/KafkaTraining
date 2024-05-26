package com.producer.controller;

import com.common.SharedData;
import com.common.statically.Post;
import com.producer.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/producer/")
@AllArgsConstructor
public class ProducerStaticController {

    private final KafkaTemplate kafkaTemplate;
    private final ProducerService<Post> producerService;

    @GetMapping("sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        kafkaTemplate.send(SharedData.topicName, message);
        return "Test "+message+SharedData.topicName;
    }

    @GetMapping("sendMessagePost")
    public String sendMessagePost(@RequestParam("title") String title,
                                  @RequestParam("description") String description){
        Post post = Post.builder()
                .id(1L).title(title).description(description).build();
        producerService.sendGenericMessage(post);
        return "Sent successfully";
    }
}
