package com.example.vejret.services;

import com.example.vejret.models.Wind;
import com.example.vejret.repositories.IWindRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WindService implements IService<Wind> {

    private final IWindRepository iWindRepository;

    public WindService(IWindRepository iWindRepository) {
        this.iWindRepository = iWindRepository;
    }


    @Override
    public List<Wind> findAll() {
        return null;
    }

    @Override
    public void save(Wind wind) {
        iWindRepository.save(wind);
    }
}
