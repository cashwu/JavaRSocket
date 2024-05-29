package com.cashwu.javarsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

/**
 * @author cash.wu
 * @since 2024/05/29
 */
@Configuration
@Slf4j
public class RSocketClientConfiguration {

    @Bean
    public ApplicationRunner sender(RSocketRequester.Builder requesterBuilder) {

        return args -> {
            RSocketRequester request = requesterBuilder.tcp("localhost", 7001);

//            request.route("greeting").data("Hello RSocket!").retrieveMono(String.class)
//                   .subscribe(resp -> log.info("Got a response : {}", resp));

            var who = "cash";
            request.route("greeting2/{name}", who).data("Hello RSocket!").retrieveMono(String.class)
                   .subscribe(resp -> log.info("Got a response : {}", resp));
        };

    }
}
