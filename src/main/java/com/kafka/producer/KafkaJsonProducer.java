package com.kafka.producer;

import com.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaJsonProducer {

  private final KafkaTemplate<String, Student> kafkaTemplate;

  public void sendMessage(Student student){
    Message<Student> message = MessageBuilder
            .withPayload(student)
            .setHeader(KafkaHeaders.TOPIC,"kafka-topic")
            .build();

    kafkaTemplate.send(message);
  }
}
