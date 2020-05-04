package com.example.vejret.repositories;

import com.example.vejret.models.Clouds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICloudsRepository extends JpaRepository<Clouds, Long> {
}
