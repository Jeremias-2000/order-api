package com.order.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Contact {



    private String contactName;
    private String ddd;
    private String mobileNumber;
    private String residentialContact;
    private String birth;
    private String gender;
    private String occupation;

}
