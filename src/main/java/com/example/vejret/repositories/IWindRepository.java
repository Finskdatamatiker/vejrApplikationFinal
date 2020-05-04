package com.example.vejret.repositories;

import com.example.vejret.models.Wind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWindRepository extends JpaRepository<Wind, Long> {
}
