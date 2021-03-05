package com.example.hexagonal.domain.services;

import com.example.hexagonal.FixtureLibrary;
import com.example.hexagonal.adapters.repositories.InMemoryBlogPostRepository;
import com.example.hexagonal.ports.BlogServicePort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlogServiceTest {

    private BlogServicePort blogService = new BlogService(new InMemoryBlogPostRepository());

    @Test
    void postedArticleIsReturnedBack() {
        blogService.postArticle(FixtureLibrary.POST_RECENT);

        var articles = blogService.listArticlesChronologically();

        assertAll(
                () -> assertEquals(1, articles.size()),
                () -> assertEquals(FixtureLibrary.POST_RECENT, articles.get(0))
        );
    }
}