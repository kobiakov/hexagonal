package com.example.hexagonal;

import com.example.hexagonal.domain.model.BlogPost;

import java.time.OffsetDateTime;
import java.util.UUID;

public class FixtureLibrary {
    public static final BlogPost POST_FROM_10_DAYS_AGO = BlogPost.builder().id(UUID.randomUUID()).creationDate(OffsetDateTime.now().minusDays(10)).build();
    public static final BlogPost POST_RECENT = BlogPost.builder().id(UUID.randomUUID()).creationDate(OffsetDateTime.now()).build();
}
