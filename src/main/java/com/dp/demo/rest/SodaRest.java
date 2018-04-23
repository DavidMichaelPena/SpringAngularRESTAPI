package com.dp.demo.rest;

import com.dp.demo.domain.Soda;
import com.dp.demo.services.BrandService;
import com.dp.demo.services.SodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*
@CrossOrigin
@RestController
@RequestMapping("api")


public class SodaRest {

    private final SodaService sodaService;
    private final BrandService brandService;

    @Autowired
    public SodaRest(SodaService sodaService, BrandService brandService) {
        this.sodaService = sodaService;
        this.brandService = brandService;
    }

    @RequestMapping(value = "/sodas", method = RequestMethod.GET)
    public Collection<Resource<Soda>> getAllSoda() {
        Iterable<Soda> sodas = sodaService.listAllSodas();
        List<Resource<Soda>> resources = new ArrayList<>();
        for(Soda soda: sodas){
            resources.add(getSodaResource(soda));
        }
        return resources;
    }

    @RequestMapping(value = "/{sodaId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
    public Resource<Soda> getById(@PathVariable int sodaId) {

        Soda soda = sodaService.getBySodaId(sodaId);
        Resource<Soda> resource = new Resource<>(soda);
        resource.add(linkTo(methodOn(SodaRest.class).getById(sodaId)).withSelfRel());
        return resource;
    }

    @RequestMapping(value = "/sodas", method = RequestMethod.POST)
    public Soda createSoda(@RequestBody Soda soda) {
        return sodaService.saveSoda(soda);
    }

    @RequestMapping(value = "/sodas", method = RequestMethod.PUT)
    public Soda updateSoda(@RequestBody Soda soda) {
        return sodaService.saveSoda(soda);
    }

    @RequestMapping(value = "/sodas/{sodaId}", method = RequestMethod.DELETE)
    public Boolean deleteSoda(@PathVariable int sodaId) {
        boolean result = false;
        try {
            sodaService.deleteSoda(sodaId);
            result = true;
        } catch (Exception e) {
            System.out.println("You goofed");
        }
        return result;
    }

    @RequestMapping(value = "purchase/soda/{sodaId}", method = RequestMethod.GET)
    public Resource<Soda> purchaseSoda(@PathVariable int sodaId) {

        Soda soda = sodaService.getBySodaId(sodaId);
        soda.setStock(soda.getStock() - 1);
        Resource<Soda> resource = new Resource<>(soda);
        resource.add(linkTo(methodOn(SodaRest.class).getById(sodaId)).withSelfRel());
        return resource;

    }

    private Resource<Soda> getSodaResource(Soda soda){
        Resource<Soda> resource = new Resource<>(soda);
        //link to soda
        resource.add(linkTo(methodOn(SodaRest.class).getById(soda.getId())).withSelfRel());

        //link to brand
        resource.add(linkTo(methodOn(BrandRest.class).getBrandById(soda.getBrand().getId())).withRel("Brand"));
        //link to to purchase
        if(soda.getStock() >0 ) {
            resource.add(linkTo(methodOn(SodaRest.class).purchaseSoda(soda.getId())).withRel("soda.purchase"));
        }
        return resource;
    }


}
