package com.bootcamp.ws.domain.api;

import com.bootcamp.ws.domain.model.Technology;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TechnologyAdapterPort {
    CompletableFuture<List<Technology>> findAll();
}
