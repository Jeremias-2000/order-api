package com.order.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection = "users")
@AllArgsConstructor
public class User {


    @Id
    private String id;
    private String userName;
    private String password;
    private String email;
    private String cpf;
    private Contact contact;
    private Address address;

}
