package com.example.hexagonal.adapters.repositories;

import com.example.hexagonal.ports.BlogPostRepositoryPort;

@SuppressWarnings("java:S2187")
class InMemoryBlogPostRepositoryIntegrationTest implements BlogPostRepositorySpecification {
    @Override
    public BlogPostRepositoryPort provideRepository() {
        return new InMemoryBlogPostRepository();
    }
}