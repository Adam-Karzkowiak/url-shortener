package com.karzkowiak.urlshortener.service;

import com.karzkowiak.urlshortener.exception.BadRequestException;
import com.karzkowiak.urlshortener.exception.NotFoundException;
import com.karzkowiak.urlshortener.model.Redirect;
import com.karzkowiak.urlshortener.repository.RedirectRepository;
import com.karzkowiak.urlshortener.request.RedirectCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    private RedirectRepository repository;

    @Autowired
    RedirectService(final RedirectRepository repository) {
        this.repository = repository;
    }

    public Optional<Redirect> createRedirect(RedirectCreationRequest redirectCreationRequest) {
        if (repository.existsByAlias(redirectCreationRequest.getAlias())) {
            throw new BadRequestException("Alias already exists");
        }
        Redirect redirect = repository.save(new Redirect(redirectCreationRequest.getAlias(), redirectCreationRequest.getUrl()));
        return Optional.ofNullable(redirect);
    }

    public Redirect getRedirect(String alias) {
        return repository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Aliast not found."));

    }
}
