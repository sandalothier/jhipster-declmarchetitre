package com.fisc.declmarchetitre.web.rest;

import com.fisc.declmarchetitre.service.DeclmarchetitreKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declmarchetitre-kafka")
public class DeclmarchetitreKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclmarchetitreKafkaResource.class);

    private DeclmarchetitreKafkaProducer kafkaProducer;

    public DeclmarchetitreKafkaResource(DeclmarchetitreKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
