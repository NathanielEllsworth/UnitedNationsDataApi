package com.ironyard.controller;

import com.ironyard.dto.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nathanielellsworth on 11/7/16.
 */
@RestController
public class UNCountryController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/country/gdp", method = RequestMethod.GET)
    public Iterable<Country> list(@RequestParam(value = "filter", required = false) String filter) {
        log.debug("Request to list Countries.");
        RestTemplate restTemplate = new RestTemplate();
        Country[] cntry = restTemplate.getForObject("http://api.undata-api.org/WB/World Development Indicators/GDP growth (annual percent)/countries?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1", Country[].class);
        log.info(cntry.toString());
        log.debug("Fetch Country complete.");
        List<Country> foundAllList = Arrays.asList(cntry);
        List<Country> filteredList = new ArrayList<>();

        if (filter != null) {
            // filter the list
            for (Country aCountry : foundAllList) {
                if (aCountry.getName().startsWith(filter)) {
                    filteredList.add(aCountry);
                }
            }
        } else {
            filteredList = foundAllList;
        }
        return filteredList;
    }





}
