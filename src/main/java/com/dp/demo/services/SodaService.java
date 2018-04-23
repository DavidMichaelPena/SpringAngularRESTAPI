package com.dp.demo.services;

import com.dp.demo.domain.Soda;


public interface SodaService {

    Iterable<Soda> listAllSodas();
    Soda getBySodaId(Integer id);
    Soda saveSoda(Soda soda);
    Iterable<Soda> saveSodaList(Iterable<Soda> sodaIterable);
    void deleteSoda(Integer id);
}
