package com.google.inject.internal;

import java.util.logging.Logger;

public class Stopwatch {
    private static final Logger logger = Logger.getLogger(Stopwatch.class.getName());
    private long start = System.currentTimeMillis();

    public long reset() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return currentTimeMillis - this.start;
        } finally {
            this.start = currentTimeMillis;
        }
    }

    public void resetAndLog(String str) {
        Logger logger2 = logger;
        logger2.fine(str + ": " + reset() + "ms");
    }
}
