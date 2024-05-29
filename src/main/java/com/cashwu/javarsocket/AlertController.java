package com.cashwu.javarsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Controller
@Slf4j
public class AlertController {

    @MessageMapping("alert")
    public Mono<Void> setAlert(Mono<Alert> alert) {

        return alert.doOnNext(a -> {
            log.info("{} ({}) alert ordered by {} at {}", a.getLevel(), a.getMessage(),
                     a.getOrderedBy(), a.getOrderedAt());
        }).thenEmpty(Mono.empty());
    }
}
