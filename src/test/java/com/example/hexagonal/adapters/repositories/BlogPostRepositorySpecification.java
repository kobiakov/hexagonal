package com.example.hexagonal.adapters.repositories;

import com.example.hexagonal.FixtureLibrary;
import com.example.hexagonal.ports.BlogPostRepositoryPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface BlogPostRepositorySpecification {
    @Test
    default void savedPostsAreOrderedChronologically() {
        var repository = provideRepository();
        repository.savePost(FixtureLibrary.POST_FROM_10_DAYS_AGO);
        repository.savePost(FixtureLibrary.POST_RECENT);

        var posts = repository.findBlogPostsOrderedByDate();

        assertEquals(FixtureLibrary.POST_FROM_10_DAYS_AGO, posts.get(0));
        assertEquals(FixtureLibrary.POST_RECENT, posts.get(1));
    }

    BlogPostRepositoryPort provideRepository();
}
