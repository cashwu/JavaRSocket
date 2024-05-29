package com.cashwu.javarsocket;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Controller
public class StockQuoteController {

    @MessageMapping("stock/{symbol}")
    public Flux<StockQuote> greet(@DestinationVariable String symbol) {

        return Flux.interval(Duration.ofSeconds(1)).map(a -> {
            var price = BigDecimal.valueOf(Math.random() * 10);

            return new StockQuote(symbol, price, Instant.now());
        });
    }
}
