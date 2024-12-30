package com.example.urlshortener.dto;

public class UrlShortenResponse {
    private String shortenedUrl;

    public UrlShortenResponse(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
