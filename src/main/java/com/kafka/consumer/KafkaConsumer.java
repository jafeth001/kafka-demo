package com.kafka.consumer;

import com.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

//  @KafkaListener(topics = "kafka-topic", groupId = "myGroup")
  public void consume(String message) {
    log.info("Message received: {}", message);
  }

  @KafkaListener(topics = "kafka-topic",groupId = "myGroup")
  public void consume(Student student){
    log.info("Message received: {}", student);
  }
}
