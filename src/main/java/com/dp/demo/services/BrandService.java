package com.dp.demo.services;

import com.dp.demo.domain.Brand;


public interface BrandService {

    Iterable<Brand> listAllBrands();
    Brand getBrandById(Integer id);
    Brand saveBrand(Brand brand);
    Iterable<Brand> saveBrandList(Iterable<Brand> brandIterable);
    void deleteBrand(Integer id);
    Brand findByBrandName(String brandName);


}
