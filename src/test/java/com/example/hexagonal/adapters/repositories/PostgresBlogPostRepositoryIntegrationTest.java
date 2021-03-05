package com.example.hexagonal.adapters.repositories;

import com.example.hexagonal.ports.BlogPostRepositoryPort;

public class PostgresBlogPostRepositoryIntegrationTest implements BlogPostRepositorySpecification {
    @Override
    public BlogPostRepositoryPort provideRepository() {
        return new PostgresBlogPostRepository();
    }
}
