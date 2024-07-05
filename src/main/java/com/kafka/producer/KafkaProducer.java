package com.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
  private final  KafkaTemplate<String, String> kafkaTemplate;

  public void SendMessage(String message){
    log.info("Message sent to kafka-topic: {}", message);
    kafkaTemplate.send("kafka-topic", message);
  }
}
