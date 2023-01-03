package com.example.sender;

import com.example.Store;
import com.example.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    SqsSender sqsSender;

    @Autowired
    StoreRepository storeRepository;

    @PostMapping()
    public void send(@RequestBody Store store) {
        sqsSender.send(store);
    }

    @GetMapping("/{id}")
    public Store get(@PathVariable("id") int id) {
        System.out.println("fetching store details for id :: "+id);
        return storeRepository.findById(id);
    }

    @GetMapping
    public Map<Integer, Store> getAll() {
        System.out.println("fetching all store details");
        return storeRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        System.out.println("deleting store details for id :: "+id);
        storeRepository.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Store store) {
        System.out.println("updating store details for id :: "+store.getId());
        storeRepository.update(store);
    }

}
