package com.kafka.controller;

import com.kafka.payload.Student;
import com.kafka.producer.KafkaJsonProducer;
import com.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaProducer kafkaProducer;
  private final KafkaJsonProducer jsonProducer;

  @PostMapping
  public ResponseEntity<String> sendMessage(@RequestBody String message) {
    kafkaProducer.SendMessage(message);
    log.info("Message sent to kafka-topic: {}", message);
    return ResponseEntity.ok("Message sent successfully");
  }

  @PostMapping("/json")
  public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
    jsonProducer.sendMessage(student);
    log.info("Message sent to kafka-topic: {}", student);
    return ResponseEntity.ok("Message sent successfully");
  }
}
