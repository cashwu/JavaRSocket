package com.cashwu.javarsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Controller
@Slf4j
public class GratuityController {

    @MessageMapping("gratuity")
    public Flux<GratuityOut> calculate(Flux<GratuityIn> gratuityInFlux) {

        return gratuityInFlux.doOnNext(a -> log.info("Gratuity input received: {}", a)).map(a -> {
            var percentAsDecimal = a.getPercent() / 100.0;
            BigDecimal gratuity = a.getBillTotal().multiply(BigDecimal.valueOf(percentAsDecimal));
            return new GratuityOut(a.getBillTotal(), a.getPercent(), gratuity);
        });

    }
}
