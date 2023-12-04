package com.urlshortener.service;

import com.urlshortener.dto.Url;
import com.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.urlshortener.util.GenerateShortUrl.getShortUrl;
import static com.urlshortener.util.GenerateShortUrl.isUrlValid;


@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;


    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url) {
        if(! isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));

        return urlRepository.save(urlObject);
    }
}
