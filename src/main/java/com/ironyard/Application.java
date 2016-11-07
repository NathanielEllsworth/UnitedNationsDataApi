package com.ironyard;


import com.ironyard.dto.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nathanielellsworth on 11/7/16.
 */
@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        RestTemplate restTemplate = new RestTemplate();


        Country[] cntry = restTemplate.getForObject("http://api.undata-api.org/WB/GDP%20growth%20(annual%20percent)/countries?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1",Country[].class);
        log.info(cntry.toString());
    }



}
