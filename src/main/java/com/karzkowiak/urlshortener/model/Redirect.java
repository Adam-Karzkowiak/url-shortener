package com.karzkowiak.urlshortener.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
class Redirect {
    @Id
    @GeneratedValue
    private long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String alias;

    @Column(nullable = false)
    private String url;

    public Redirect() {
    }

    public Redirect(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }
}
