package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Random;

@Component
public class IdGeneratorImpl implements IdGenerator {

    public IdGeneratorImpl() {

    }

    @Override
    public BigInteger nextId() {

        BigInteger maxLimit = new BigInteger("18446744073709551615");
        Random randNum = new Random();
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum).abs();
        return res;
    }
}
