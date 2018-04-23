package com.dp.demo;

import com.dp.demo.repos.SodaRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class SodaRestTest{


    @Autowired
    SodaRepository sodaRepository;

    @BeforeClass
    public static void setBaseUri(){


        RestAssured.baseURI = "http://localhost:8888";
    }

    @Test
    public void testConnection(){
        given().get("/api/soda/")
                .then()
                .contentType(ContentType.JSON)
                .assertThat().statusCode(200);
    }

    @Test
    public void errorOnConnectionReturnsFourHundo() {
        given().get("/api/asdfdsf/")
                .then()
                .assertThat().statusCode(404);
    }

    @Test
    public void getAllSodasReturnsSevenItems() {
        given().get("/api/soda/")
                .then()
                .body("id", hasItems(1,2,3,4,5,6,7));
    }
    @Test
    public void sodaNamesWithIdLessThanThree(){
        given().get("/api/soda/")
                .then()
                .body("findAll {it.id <3 }.name", hasItems("Coca-Cola", "Sprite"));
    }
    @Test
    public void getBrandFromSodaOne(){
        given().get("/api/soda/1")
                .then()
                .body("brand.brandName", equalTo("Coke"));
    }
}