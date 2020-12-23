package com.order.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
public class Address {


    private String publicPlace;
    private String city;
    private String state;
    private String latitude;
    private String longitude;
}
