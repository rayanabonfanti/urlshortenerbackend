package com.urlshortener.controller;

import com.urlshortener.dto.Url;
import com.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url/shortener")
@CrossOrigin(origins = "*")
public class UrlController {

    @Autowired
    private  UrlService urlService;

    @GetMapping("/{id}")
    public String getOriginlUrl(@PathVariable String id) {
        return urlService.getOriginlUrl(id);
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }

}
