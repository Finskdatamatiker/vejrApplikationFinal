package com.example.vejret.services;

import com.example.vejret.models.Coord;
import com.example.vejret.repositories.ICoordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordService implements IService<Coord> {

    private final ICoordRepository iCoordRepository;

    public CoordService(ICoordRepository iCoordRepository) {
        this.iCoordRepository = iCoordRepository;
    }


    @Override
    public List<Coord> findAll() {
        return null;
    }

    @Override
    public void save(Coord coord) {
        iCoordRepository.save(coord);
    }
}
