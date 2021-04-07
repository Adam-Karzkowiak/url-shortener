package com.karzkowiak.urlshortener.request;


import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RedirectCreationRequest {
    @NotNull
    private String alias;
    @NotNull
    private String url;

    RedirectCreationRequest(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }
}
