package com.example.urlshortener.controller;

import com.example.urlshortener.dto.UrlShortenRequest;
import com.example.urlshortener.dto.UrlShortenResponse;
import com.example.urlshortener.service.UrlShortenerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public UrlShortenResponse shortenUrl(@RequestBody UrlShortenRequest request) {
        return service.shortenUrl(request);
    }

    @GetMapping("/{shortenedUrl}")
    public String getOriginalUrl(@PathVariable String shortenedUrl) {
        return service.getOriginalUrl(shortenedUrl);
    }
}
