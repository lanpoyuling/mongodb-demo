package com.example.mongodbdemo.entity;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class AbstractDocument {

    @Id
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))){
            return false;
        }
        AbstractDocument that = (AbstractDocument) obj;
        return this.id.equals(that.getId());
    }
}
