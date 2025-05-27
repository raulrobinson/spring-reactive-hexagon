package com.bootcamp.ws.application.config;

import com.bootcamp.ws.domain.api.TechnologyAdapterPort;
import com.bootcamp.ws.domain.usecase.queries.FindAllUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class UseCaseConfig {

    @Bean
    public FindAllUseCase findAllUseCase(TechnologyAdapterPort technologyAdapterPort) {
        return new FindAllUseCase(technologyAdapterPort);
    }
}
