package com.dp.demo.bootstrap;

import com.dp.demo.domain.Brand;
import com.dp.demo.domain.Soda;
import com.dp.demo.services.BrandService;
import com.dp.demo.services.SodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {


    private final SodaService sodaService;

    private final BrandService brandService;

    @Autowired
    public SeedData(SodaService sodaService, BrandService brandService){
        this.sodaService = sodaService;
        this.brandService = brandService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Soda soda1 = new Soda("Coca-Cola");
        Soda soda2 = new Soda("Sprite");
        Soda soda3 = new Soda("Mr Pibb");
        Soda soda4 = new Soda("Pepsi");
        Soda soda5 = new Soda("Sierra Mist");
        Soda soda6 = new Soda("7-Up");
        Soda soda7 = new Soda("Pamplemousse");

        Brand pepsi = new Brand("Pepsi");
        Brand coke = new Brand("Coke");
        Brand sevenUp = new Brand("SevenUp");
        Brand lacroix = new Brand("La Croix");

        brandService.saveBrand(pepsi);
        brandService.saveBrand(coke);
        brandService.saveBrand(sevenUp);
        brandService.saveBrand(lacroix);

        soda1.setBrand(coke);
        soda2.setBrand(coke);
        soda3.setBrand(coke);
        soda4.setBrand(pepsi);
        soda5.setBrand(pepsi);
        soda6.setBrand(sevenUp);
        soda7.setBrand(lacroix);

        soda1.setCalories(450);
        soda2.setCalories(600);
        soda3.setCalories(700);
        soda4.setCalories(500);
        soda5.setCalories(550);
        soda6.setCalories(400);
        soda7.setCalories(80);

        soda1.setStock(10);
        soda2.setStock(4);
        soda3.setStock(23);
        soda4.setStock(11);
        soda5.setStock(3);
        soda6.setStock(5);
        soda7.setStock(13);

        sodaService.saveSoda(soda1);
        sodaService.saveSoda(soda2);
        sodaService.saveSoda(soda3);
        sodaService.saveSoda(soda4);
        sodaService.saveSoda(soda5);
        sodaService.saveSoda(soda6);
        sodaService.saveSoda(soda7);

    }
}


