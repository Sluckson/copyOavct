package com.medallia.digital.mobilesdk;

public enum MDLogLevel {
    OFF(0),
    FATAL(1),
    ERROR(2),
    WARN(3),
    INFO(4),
    DEBUG(5);
    
    private int level;

    private MDLogLevel(int i) {
        this.level = i;
    }

    public int getLevel() {
        return this.level;
    }
}
