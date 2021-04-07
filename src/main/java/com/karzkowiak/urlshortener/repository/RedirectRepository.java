package com.karzkowiak.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.karzkowiak.urlshortener.model.Redirect;

@Repository
interface RedirectRepository extends JpaRepository<Redirect, Long> {
}
