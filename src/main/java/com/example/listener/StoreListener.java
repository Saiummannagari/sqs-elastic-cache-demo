package com.example.listener;

import com.example.Store;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class StoreListener {

    //use the fully qualified name, only if appln is running in local. Or else use only queue name
    @SqsListener("https://sqs.{{region}}.amazonaws.com/{{accountId}}/{{queue-name}}")
    public void listen(Store store) {
        System.out.println("received store details :: "+ store.toString());
    }

}
