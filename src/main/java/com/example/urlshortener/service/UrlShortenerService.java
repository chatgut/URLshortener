package com.example.urlshortener.service;

import com.example.urlshortener.dto.UrlShortenRequest;
import com.example.urlshortener.dto.UrlShortenResponse;
import com.example.urlshortener.entity.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlShortenerService {

    private final UrlMappingRepository repository;

    public UrlShortenerService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public UrlShortenResponse shortenUrl(UrlShortenRequest request) {
        Optional<UrlMapping> existingMapping = repository.findByOriginalUrl(request.getOriginalUrl());
        if (existingMapping.isPresent()) {
            return new UrlShortenResponse(existingMapping.get().getShortenedUrl());
        }

        String shortenedUrl = UUID.randomUUID().toString().substring(0, 8);

        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(request.getOriginalUrl());
        mapping.setShortenedUrl(shortenedUrl);
        repository.save(mapping);

        return new UrlShortenResponse(shortenedUrl);
    }

    public String getOriginalUrl(String shortenedUrl) {
        UrlMapping mapping = repository.findByShortenedUrl(shortenedUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        return mapping.getOriginalUrl();
    }
}
