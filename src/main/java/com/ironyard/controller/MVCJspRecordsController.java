package com.ironyard.controller;

import com.ironyard.dto.Country;
import com.ironyard.dto.Records;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT.value;

/**
 * Created by nathanielellsworth on 11/7/16.
 */
@Controller
public class MVCJspRecordsController {

    @RequestMapping(value = "mvc/country/all/records", method = RequestMethod.POST)
    public String list(Map<String, Object> model, @RequestParam(value = "dropdown", required = true) String aCountry) {

        RestTemplate restTemplate = new RestTemplate();
        Records[] rec = restTemplate.getForObject("http://api.undata-api.org/WB/GDP growth (annual percent)/" + aCountry + "/records?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1" , Records[].class);

        // GET RID OF ALL THE %20 IN THE URL's!! (those represent blank spaces)

        model.put("records", rec);

        RestTemplate restTemplate2 = new RestTemplate();
        Country[] cntry = restTemplate2.getForObject("http://api.undata-api.org/WB/GDP growth (annual percent)/countries?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1" , Country[].class);

        // GET RID OF ALL THE %20 IN THE URL's!! (those represent blank spaces)

        model.put("country", cntry);
        return "country_gdp";


    }
}