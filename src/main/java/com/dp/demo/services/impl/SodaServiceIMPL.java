package com.dp.demo.services.impl;

import com.dp.demo.domain.Soda;
import com.dp.demo.repos.SodaRepository;
import com.dp.demo.services.SodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SodaServiceIMPL implements SodaService{


    private final SodaRepository sodaRepository;

    @Autowired
    public SodaServiceIMPL(SodaRepository sodaRepository){
        this.sodaRepository = sodaRepository;
    }

    @Override
    public Iterable<Soda> listAllSodas(){
        return sodaRepository.findAll();
    }

    @Override
    public Soda getBySodaId(Integer id){
        return sodaRepository.findOne(id);
    }

    @Override
    public Soda saveSoda(Soda soda){
        return sodaRepository.save(soda);
    }

    @Override
    public Iterable<Soda> saveSodaList(Iterable<Soda> sodaIterable){
        return sodaRepository.save(sodaIterable);
    }
    @Override
    public void deleteSoda(Integer id){
        sodaRepository.delete(id);
    }
}
