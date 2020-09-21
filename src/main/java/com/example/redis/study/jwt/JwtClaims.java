package com.example.redis.study.jwt;

import java.util.HashMap;
import java.util.Objects;

public class JwtClaims extends HashMap {

    String ID = "id";
    String NAME = "name";
    String PHONE = "phone";
    String FAILURETIME = "failureTime";

    public JwtClaims() {
        this.put(ID, null);
        this.put(NAME, null);
        this.put(PHONE, null);
        this.put(FAILURETIME, null);
    }

    public JwtClaims put(String key, Object value) {

        super.put(key, value);
        return this;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this);
    }
}
