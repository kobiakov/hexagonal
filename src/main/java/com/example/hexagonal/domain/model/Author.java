package com.example.hexagonal.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Author {
    UUID id;
    String name;
}
