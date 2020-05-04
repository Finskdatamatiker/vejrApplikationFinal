package com.example.vejret.repositories;

import com.example.vejret.models.Coord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoordRepository extends JpaRepository<Coord, Long> {
}
