package com.example.vejret.services;

import com.example.vejret.models.Main;
import com.example.vejret.repositories.IMainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService implements IService<Main> {

    private final IMainRepository iMainRepository;

    public MainService(IMainRepository iMainRepository) {
        this.iMainRepository = iMainRepository;
    }

    @Override
    public List<Main> findAll() {
        return null;
    }

    @Override
    public void save(Main main) {
        iMainRepository.save(main);
    }
}
