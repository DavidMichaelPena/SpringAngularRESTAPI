package com.dp.demo.services.impl;

import com.dp.demo.domain.Brand;
import com.dp.demo.repos.BrandRepository;
import com.dp.demo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceIMPL implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceIMPL(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public Iterable<Brand> listAllBrands(){
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Integer id){
        return brandRepository.findOne(id);
    }

    @Override
    public Brand saveBrand(Brand brand){
        return brandRepository.save(brand);
    }

    @Override
    public Iterable<Brand> saveBrandList(Iterable<Brand> brandIterable){
        return brandRepository.save(brandIterable);
    }

    @Override
    public void deleteBrand(Integer id){
        brandRepository.delete(id);
    }

    @Override
    public Brand findByBrandName(String brandName){
       return brandRepository.findBrandByBrandName(brandName);
    }

}
