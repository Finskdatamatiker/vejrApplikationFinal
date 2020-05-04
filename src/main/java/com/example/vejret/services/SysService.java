package com.example.vejret.services;

import com.example.vejret.models.Sys;
import com.example.vejret.repositories.ISysRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysService implements IService<Sys> {

    private final ISysRepository iSysRepository;

    public SysService(ISysRepository iSysRepository) {
        this.iSysRepository = iSysRepository;
    }

    @Override
    public List<Sys> findAll() {
        return null;
    }

    @Override
    public void save(Sys sys) {
        iSysRepository.save(sys);
    }
}
