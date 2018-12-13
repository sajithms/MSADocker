package com.zcare.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zcare.api.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
