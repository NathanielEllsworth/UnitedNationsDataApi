package com.ironyard.controller;

import com.ironyard.dto.Country;
//import com.ironyard.dto.Records;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by nathanielellsworth on 11/9/16.
 */
@Controller
public class MVCJspCountryController {

        @RequestMapping(value = "/mvc/country/all", method = RequestMethod.GET)
        public String list(Map<String, Object> model) {

            RestTemplate restTemplate = new RestTemplate();
            Country[] cntry = restTemplate.getForObject("http://api.undata-api.org/WB/GDP growth (annual percent)/countries?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1" , Country[].class);

            // GET RID OF ALL THE %20 IN THE URL's!! (those represent blank spaces)

            model.put("country", cntry);
            return "country_gdp";


        }
}
