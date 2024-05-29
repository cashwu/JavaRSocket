package com.cashwu.javarsocket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Data
@AllArgsConstructor
public class Alert {

    private EnumLevel level;
    private String message;
    private String orderedBy;
    private Instant orderedAt;


    public enum EnumLevel {
        YELLOW,
        RED,
        BLACK
    }
}
