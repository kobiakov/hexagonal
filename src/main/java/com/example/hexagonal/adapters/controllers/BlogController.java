package com.example.hexagonal.adapters.controllers;

import com.example.hexagonal.domain.model.Author;
import com.example.hexagonal.domain.model.BlogPost;
import com.example.hexagonal.ports.BlogServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@RestController("/")
public class BlogController {

    private final BlogServicePort blogService;

    @PostMapping
    public ResponseEntity<String> postArticle(@RequestBody CreateBlogPostRequest request) {
        return ResponseEntity.ok(blogService.postArticle(requestToDomainModel(request)).toString());
    }

    BlogPost requestToDomainModel(CreateBlogPostRequest request) {
        return BlogPost.builder()
                .author(Author.builder().id(request.getId()).name("Whoever").build())
                .content(request.getContent())
                .creationDate(OffsetDateTime.now())
                .build();
    }
}
