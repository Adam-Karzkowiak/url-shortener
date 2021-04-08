package com.karzkowiak.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Redirect {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    @NotNull
    private String alias;

    @Column(nullable = false)
    @NotNull
    private String url;

    public Redirect() {
    }

    public Redirect(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }
}
