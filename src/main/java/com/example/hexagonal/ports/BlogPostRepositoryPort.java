package com.example.hexagonal.ports;

import com.example.hexagonal.domain.model.BlogPost;

import java.util.List;
import java.util.UUID;

public interface BlogPostRepositoryPort {
    UUID savePost(BlogPost post);

    List<BlogPost> findBlogPostsOrderedByDate();

    void deleteById(UUID postId);
}
