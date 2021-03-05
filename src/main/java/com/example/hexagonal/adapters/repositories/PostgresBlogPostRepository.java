package com.example.hexagonal.adapters.repositories;

import com.example.hexagonal.domain.model.BlogPost;
import com.example.hexagonal.ports.BlogPostRepositoryPort;

import java.util.List;
import java.util.UUID;

public class PostgresBlogPostRepository implements BlogPostRepositoryPort {
    @Override
    public UUID savePost(BlogPost post) {
        return null;
    }

    @Override
    public List<BlogPost> findBlogPostsOrderedByDate() {
        return null;
    }

    @Override
    public void deleteById(UUID postId) {

    }
}
