package com.dp.demo;


import com.dp.demo.domain.Soda;
import com.dp.demo.rest.SodaRest;
import com.dp.demo.services.BrandService;
import com.dp.demo.services.SodaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SimpleRestApiApplication.class)
public class SodaControllerTest {

    private MockMvc mockMvc;


    @InjectMocks
    private SodaRest sodaRest;

    @Mock
    private SodaService sodaServiceMock;
    @Mock
    private BrandService brandServiceMock;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new SodaRest(sodaServiceMock, brandServiceMock)).build();
    }

    @Test
    public void shouldGetSodaWithValidRequest() throws Exception {
        Soda soda = new Soda("Test");
        soda.setId(8);
        sodaServiceMock.saveSoda(soda);
        when(sodaServiceMock.getBySodaId(8)).thenReturn(soda);
        mockMvc.perform(get("/api/soda/{sodaId}", 8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
    @Test
    public void invalidRequest() throws Exception{
        Soda soda = new Soda("Test");
        soda.setId(8);
        sodaServiceMock.saveSoda(soda);
        when(sodaServiceMock.getBySodaId(8)).thenReturn(soda);
        mockMvc.perform(get("api/soda/{sodaId}", 8))
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createSodaTest() throws Exception{

    }
}
