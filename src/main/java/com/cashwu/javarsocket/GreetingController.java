package com.cashwu.javarsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Controller
@Slf4j
public class GreetingController {

    @MessageMapping("greeting")
    public Mono<String> greet(Mono<String> mono) {

        return mono.doOnNext(a -> log.info("receive greeting: {}", a))
                   .map(a -> "Hello back to you ," + a + " !");
    }

    @MessageMapping("greeting2/{name}")
    public Mono<String> greet2(
            @DestinationVariable String name,
            Mono<String> mono) {

        return mono.doOnNext(a -> log.info("receive greeting from {} : {}", name, a))
                   .map(a -> "Hello " + name + " !");
    }
}
