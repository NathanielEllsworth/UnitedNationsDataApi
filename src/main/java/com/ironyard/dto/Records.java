package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nathanielellsworth on 11/7/16.
 */
public class Records {

    //(fourth in order) this is the country's GDP growth (or shrink) year-by-year as a percent of the previous year.

    //URL for list of records

    //Australia was just a test ----------------------------------------------------------v

    //curl -v  -X GET "http://api.undata-api.org/WB/GDP%20growth%20(annual%20percent)/Australia/records?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1"


    //want to exclude 'footnotes' since there is no data in String 'footnotes'.


    @JsonProperty(value = "area_name")
    private String area_name;

    @JsonProperty(value = "measurement")
    private String measurement;

    @JsonProperty(value = "value")
    private String value;

    @JsonProperty(value = "year")
    private String year;

    public String getArea_name() {return area_name;}

    public void setArea_name(String area_name) {this.area_name = area_name;}

    public String getMeasurement() {return measurement;}

    public void setMeasurement(String measurement) {this.measurement = measurement;}

    public String getValue() {return value;}

    public void setValue(String value) {this.value = value;}

    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}
}
