package com.example.hexagonal.domain.model;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class BlogPost {
    UUID id;
    Author author;
    String content;
    OffsetDateTime creationDate;
}
