package com.example.hexagonal.ports;

import com.example.hexagonal.domain.model.BlogPost;

import java.util.List;
import java.util.UUID;

public interface BlogServicePort {
    UUID postArticle(BlogPost post);

    List<BlogPost> listArticlesChronologically();

    void deleteArticle(UUID postId);
}
