package com.sagar.kafka.kafkaproducer.services;


import com.sagar.kafka.kafkaproducer.model.IncomingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageController {

    @Autowired
    KafkaProducerService kafkaProducerService;
    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage msg){
        kafkaProducerService.sendMessage(msg.getTopic(),msg.getKey(),msg.getValue());
        return String.format("message received for the Topic %s with Key %s and value %s ", msg.getTopic(),msg.getKey(),msg.getValue());
    }
}
