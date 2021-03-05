package com.example.hexagonal.adapters.controllers;

import lombok.Value;

import java.util.UUID;

@Value
public class CreateBlogPostRequest {
    // some request validation, via java validation api for example
    UUID id;

    // validated content
    String content;
}
