package com.cashwu.javarsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.net.URI;
import java.time.Duration;

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
            //            RSocketRequester request = requesterBuilder.tcp("localhost", 7001);

            //            request.route("greeting").data("Hello RSocket!").retrieveMono(String.class)
            //                   .subscribe(resp -> log.info("Got a response : {}", resp));

            //            var who = "cash";
            //            request.route("greeting2/{name}", who).data("Hello RSocket!").retrieveMono(String.class)
            //                   .subscribe(resp -> log.info("Got a response : {}", resp));

            //            var symbol = "1234";
            //            request.route("stock/{symbol}", symbol)
            //                    .retrieveFlux(StockQuote.class)
            //                   .subscribe(a -> log.info(
            //                           "price of {} : {} (at {})",
            //                           a.getSymbol(),
            //                           a.getPrice(),
            //                           a.getTimestamp()));

            //                        request.route("alert")
            //                               .data(new Alert(Alert.EnumLevel.YELLOW, "aaa", "Cash", Instant.now()))
            //                                .send()
            //                               .subscribe();

            //            var gratuityInFlux = Flux.fromArray(
            //                    new GratuityIn[] {new GratuityIn(BigDecimal.valueOf(10.00), 15),
            //                                      new GratuityIn(BigDecimal.valueOf(5.00), 20),
            //                                      new GratuityIn(BigDecimal.valueOf(3.00), 10),})
            //                    .delayElements(Duration.ofSeconds(1));
            //
            //
            //            request.route("gratuity")
            //                    .data(gratuityInFlux)
            //                    .retrieveFlux(GratuityOut.class)
            //                    .subscribe(a -> {
            //                        log.info("{} % gratuity on {} is {}", a.getPercent(), a.getBillTotal(),
            //                                 a.getGratuity());
            //                    });

            RSocketRequester request = requesterBuilder.websocket(
                    URI.create("ws://localhost:8080/rsocket"));

            request.route("greeting")
                    .data("hello rsocket")
                    .retrieveMono(String.class)
                    .subscribe(r -> log.info("Got a resp : {}", r));

        };

    }
}
