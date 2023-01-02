package com.example.sender;

import com.example.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    SqsSender sqsSender;

    @PostMapping()
    public void send(@RequestBody Store store) {
         sqsSender.send(store);
    }
}
