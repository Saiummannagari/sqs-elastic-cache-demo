package com.example;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Store implements Serializable {

    int id;

    String storeName;

    public Store() {
    }

    public Store(int id, String store) {
        this.id = id;
        this.storeName = store;
    }

    public String toString() {
        return "id :: "+this.id+"storename :: "+this.storeName;
    }
}
