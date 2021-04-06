package com.shariful.mb.reportservice.utilities.util;

public enum DirectionOfTransaction {
    IN, OUT;

    public static boolean contains(String incomingDirectionOfTransaction) {
        for (DirectionOfTransaction directionOfTransaction : DirectionOfTransaction.values()) {
            if (directionOfTransaction.name().equals(incomingDirectionOfTransaction)) {
                return true;
            }
        }
        return false;
    }
}
