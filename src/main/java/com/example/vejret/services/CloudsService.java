package com.example.vejret.services;

import com.example.vejret.models.Clouds;
import com.example.vejret.repositories.ICloudsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudsService implements IService<Clouds> {

    private final ICloudsRepository iCloudsRepository;

    public CloudsService(ICloudsRepository iCloudsRepository) {
        this.iCloudsRepository = iCloudsRepository;
    }


    @Override
    public List<Clouds> findAll() {
        return null;
    }

    @Override
    public void save(Clouds clouds) {
        iCloudsRepository.save(clouds);

    }
}
