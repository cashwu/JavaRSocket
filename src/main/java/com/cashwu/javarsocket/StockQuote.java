package com.cashwu.javarsocket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Data
@AllArgsConstructor
public class StockQuote {

    private String symbol;
    private BigDecimal price;
    private Instant timestamp;
}
