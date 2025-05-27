package com.bootcamp.ws.infrastructure.adapters.persistence.mapper;

import com.bootcamp.ws.domain.model.Technology;
import com.bootcamp.ws.infrastructure.adapters.persistence.entity.TechnologyEntity;
import org.springframework.stereotype.Component;

@Component
public class TechnologyMapper {

    public Technology toDomain(TechnologyEntity entity) {
        return new Technology.Builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(String.valueOf(entity.getCreatedAt()))
                .updatedAt(String.valueOf(entity.getUpdatedAt()))
                .build();
    }
}
