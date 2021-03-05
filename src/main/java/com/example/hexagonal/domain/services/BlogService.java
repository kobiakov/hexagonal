package com.example.hexagonal.domain.services;

import com.example.hexagonal.domain.model.BlogPost;
import com.example.hexagonal.ports.BlogPostRepositoryPort;
import com.example.hexagonal.ports.BlogServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BlogService implements BlogServicePort {
    private final BlogPostRepositoryPort repository;

    @Override
    public UUID postArticle(BlogPost post) {
        validate(post);
        repository.savePost(post);
        return post.getId();
    }

    private void validate(BlogPost post) {
        // do some validation here
        // for example the blog post body should not be shorter than one sentence.
        // an author is mandatory.
        // etc.
    }

    @Override
    public List<BlogPost> listArticlesChronologically() {
        return repository.findBlogPostsOrderedByDate();
    }

    @Override
    public void deleteArticle(UUID postId) {
        repository.deleteById(postId);
    }
}
