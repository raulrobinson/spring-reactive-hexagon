package com.bootcamp.ws.infrastructure.inbound;

import com.bootcamp.ws.domain.model.Technology;
import com.bootcamp.ws.infrastructure.inbound.handler.TechnologyHandler;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TechnologyRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/technologies",
                    produces = "application/json",
                    method = RequestMethod.GET,
                    beanClass = TechnologyHandler.class,
                    beanMethod = "getAll",
                    operation = @io.swagger.v3.oas.annotations.Operation(
                            operationId = "getAll",
                            summary = "Find all technologies",
                            description = "Find all technologies from the database",
                            responses = {
                                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                                            responseCode = "200",
                                            description = "OK",
                                            content = @io.swagger.v3.oas.annotations.media.Content(
                                                    mediaType = "application/json",
                                                    array = @io.swagger.v3.oas.annotations.media.ArraySchema(
                                                            schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Technology.class)
                                                    )
                                            )
                                    ),
//                                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
//                                            responseCode = "404", description = "Not Found",
//                                            content = @io.swagger.v3.oas.annotations.media.Content(
//                                                    mediaType = "application/json",
//                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorDto.class)
//                                            )
//                                    ),
//                                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
//                                            responseCode = "400", description = "Bad Request",
//                                            content = @io.swagger.v3.oas.annotations.media.Content(
//                                                    mediaType = "application/json",
//                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorDto.class)
//                                            )
//                                    ),
//                                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
//                                            responseCode = "500", description = "Internal Server Error",
//                                            content = @io.swagger.v3.oas.annotations.media.Content(
//                                                    mediaType = "application/json",
//                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorDto.class)
//                                            )
//                                    )
                            }
                    )
            ),
    })
    public RouterFunction<ServerResponse> route(TechnologyHandler handler) {
        return RouterFunctions.route()
                .GET("/api/v1/technologies", handler::getAll)
                .build();
    }
}
