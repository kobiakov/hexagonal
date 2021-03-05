package com.example.hexagonal.adapters.repositories;

import com.example.hexagonal.domain.model.BlogPost;
import com.example.hexagonal.ports.BlogPostRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.*;

@Component
public class InMemoryBlogPostRepository implements BlogPostRepositoryPort {
    private final Map<UUID, BlogPost> posts = new HashMap<>();

    @Override
    public UUID savePost(BlogPost post) {
        posts.put(post.getId(), post);
        return post.getId();
    }

    @Override
    public List<BlogPost> findBlogPostsOrderedByDate() {
        List<BlogPost> orderedPosts = new ArrayList<>(posts.values());
        orderedPosts.sort(Comparator.comparing(BlogPost::getCreationDate, OffsetDateTime::compareTo));
        return orderedPosts;
    }

    @Override
    public void deleteById(UUID postId) {
        posts.remove(postId);
    }
}
