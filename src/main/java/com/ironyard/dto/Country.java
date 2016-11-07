package com.ironyard.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nathanielellsworth on 11/7/16.
 */
@Entity
public class Country {

    //(third in order) User will be able to choose which country

    //URL for list of countries

    //curl -v  -X GET "http://api.undata-api.org/WB/GDP%20growth%20(annual%20percent)/countries?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1"

    private String name;
    @OneToMany(cascade = CascadeType.ALL);
    List<Records>records;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO);
    private long id;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public List<Records> getRecords() {return records;}

    public void setRecords(List<Records> records) {this.records = records;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}
}
