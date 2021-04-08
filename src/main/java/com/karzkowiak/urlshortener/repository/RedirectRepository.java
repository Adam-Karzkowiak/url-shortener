package com.karzkowiak.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.karzkowiak.urlshortener.model.Redirect;

import java.util.Optional;

@Repository
public
interface RedirectRepository extends JpaRepository<Redirect, Long> {
    Optional<Redirect> findByAlias(String alias);

    Boolean existsByAlias(String alias);
}
