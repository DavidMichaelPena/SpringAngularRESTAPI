package com.dp.demo.repos;

import com.dp.demo.domain.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand,Integer> {

    Brand findBrandByBrandName(String brandName);
}
