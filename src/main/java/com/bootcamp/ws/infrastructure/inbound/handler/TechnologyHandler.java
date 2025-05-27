package com.bootcamp.ws.infrastructure.inbound.handler;

import com.bootcamp.ws.domain.spi.FindAllServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
@Tag(name = "Technology", description = "Technology API")
public class TechnologyHandler {

    private final FindAllServicePort findAllServicePort;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return Mono.fromFuture(findAllServicePort.findAll())
                .flatMap(list -> ServerResponse.ok().bodyValue(list));
    }
}
