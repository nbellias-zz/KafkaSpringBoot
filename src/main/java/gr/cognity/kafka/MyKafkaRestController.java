/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.cognity.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nmpellias
 */
@RestController
@RequestMapping("/kafka")
public class MyKafkaRestController {
    
    
    @Autowired
    private Producer producer;
    // @Autowired
    // private Consumer consumer;
    @Autowired
    MyKafkaRestController(Producer producer) {
        this.producer = producer;
        //this.consumer = consumer;
    }
    
    @GetMapping(value = "/publish/{msg}")
    public void sendMessageToKafkaTopic(@PathVariable String msg) {
        this.producer.sendMessage(msg);
    }
    
    @GetMapping("/subscribe")
    public List<String> nikos() {
        // CONNECTION TO KAFKA
        // FETCH MESSAGES
        List<String> messages = new ArrayList();
        String [] str = {"Nikos", "Tasos", "Maria", "Dimitra"};
        messages = Arrays.asList(str);
        return messages;
    }
    
//    @GetMapping("/{id}")
//    public Object get(@PathVariable String id) {
//        return null;
//    }
        
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }
    
}











