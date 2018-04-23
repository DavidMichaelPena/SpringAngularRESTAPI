package com.dp.demo.rest;

import com.dp.demo.domain.Brand;
import com.dp.demo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")

public class BrandRest {


    private final BrandService brandService;

    @Autowired
    public BrandRest(BrandService brandService){
        this.brandService = brandService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public Collection<Resource<Brand>> getAllBrands(){
        Iterable<Brand> brands =  brandService.listAllBrands();
        List<Resource<Brand>> resources =new ArrayList<>();
        for(Brand brand: brands){
            resources.add(getAllbrandResources(brand));
        }

        return resources;
    }

    @RequestMapping(value = "/{brandId}", method = RequestMethod.GET)

    public Resource<Brand> getBrandById(@PathVariable int brandId){
     Brand brand =  brandService.getBrandById(brandId);
     Resource<Brand> resource = new Resource<>(brand);
     resource.add(linkTo(methodOn(BrandRest.class).getBrandById(brandId)).withSelfRel());
     return resource;


    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    @RequestMapping(value = "/{brandId}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int brandId){
        boolean result = false;
        try {
            brandService.deleteBrand(brandId);
            result = true;
        }
        catch (Exception e){
            System.out.println("No delete occurred");
        }
        return result;
    }

    private Resource<Brand> getAllbrandResources(Brand brand){
        Resource<Brand> resource = new Resource<>(brand);
        resource.add(linkTo(methodOn(BrandRest.class).getBrandById(brand.getId())).withSelfRel());
    return resource;
    }

}
