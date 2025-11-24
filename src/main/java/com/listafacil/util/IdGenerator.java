package com.listafacil.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    public static int nextId() {
        return COUNTER.getAndIncrement();
    }
}
