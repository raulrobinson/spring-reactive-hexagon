package com.bootcamp.ws.infrastructure.adapters.persistence;

import com.bootcamp.ws.domain.api.TechnologyAdapterPort;
import com.bootcamp.ws.domain.model.Technology;
import com.bootcamp.ws.infrastructure.adapters.persistence.mapper.TechnologyMapper;
import com.bootcamp.ws.infrastructure.adapters.persistence.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class R2dbcTechnologyAdapter implements TechnologyAdapterPort {

    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper mapper;

    @Override
    public CompletableFuture<List<Technology>> findAll() {
        return technologyRepository.findAll()   // Flux<Technology>
                .map(mapper::toDomain)          // Map each Entity to Domain
                .collectList()                  // Mono<List<Technology>>
                .toFuture();                    // CompletableFuture<List<Technology>>
    }
}
