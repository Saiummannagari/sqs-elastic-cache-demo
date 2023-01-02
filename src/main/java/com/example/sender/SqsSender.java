package com.example.sender;

import com.example.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsSender {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void send(Store store) {
        System.out.println("sending store details to queue");
        //use the fully qualified name, only if appln is running in local. Or else use only queue name
        queueMessagingTemplate.convertAndSend("https://sqs.{{region}}.amazonaws.com/{{accountId}}/{{queue-name}}", store);
    }

}
