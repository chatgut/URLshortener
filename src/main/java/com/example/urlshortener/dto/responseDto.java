package com.example.urlshortener.dto;

public class responseDto {
    private String shortenedUrl;

    public responseDto(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
