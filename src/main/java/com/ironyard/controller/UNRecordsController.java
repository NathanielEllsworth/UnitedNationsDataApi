package com.ironyard.controller;


//import com.ironyard.dto.Country;
import com.ironyard.dto.Records;
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
import java.util.Map;

/**
 * Created by nathanielellsworth on 11/7/16.
 */
@RestController
public class UNRecordsController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/data/country/records", method = RequestMethod.GET)
    public Iterable<Records> list(@RequestParam(value = "Country", required = true) String country,
                                  @RequestParam(value = "filter", required = false) String filter){
        log.debug("Request to list a Country's records.");
        RestTemplate restTemplate = new RestTemplate();

        Records[] recrd = restTemplate.getForObject("http://api.undata-api.org/WB/GDP growth (annual percent)/" + country + "/records?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1", Records[].class);
        log.info(recrd.toString());
        log.debug("Fetch Records complete.");
        List<Records> foundAllList = Arrays.asList(recrd);
        List<Records> filteredList = new ArrayList<>();



        if (filter != null) {
            // filter the list
            for (Records aRecord : foundAllList) {
                if (aRecord.getArea_name().startsWith(filter)) {
                    filteredList.add(aRecord);
                }
            }
        } else {
            filteredList = foundAllList;
        }
        return filteredList;
    }




}
