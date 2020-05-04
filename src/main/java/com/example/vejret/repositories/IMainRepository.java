package com.example.vejret.repositories;

import com.example.vejret.models.Main;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMainRepository extends JpaRepository<Main, Long> {
}
