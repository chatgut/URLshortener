package com.example.urlshortener.mapper;

import com.example.urlshortener.dto.UrlShortenRequest;
import com.example.urlshortener.dto.UrlShortenResponse;
import com.example.urlshortener.entity.UrlMapping;
import org.springframework.stereotype.Component;

@Component
public class UrlMapper {

    public UrlMapping toEntity(UrlShortenRequest request, String shortenedUrl) {
        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(request.getOriginalUrl());
        mapping.setShortenedUrl(shortenedUrl);
        return mapping;
    }

    public UrlShortenResponse toDto(UrlMapping mapping) {
        return new UrlShortenResponse(mapping.getShortenedUrl());
    }
}
