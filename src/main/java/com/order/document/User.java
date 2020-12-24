package com.order.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Document(collection = "users")
@AllArgsConstructor
public class User {


    @Id
    private String id;
    @Size(max = 250)
    @NotNull
    private String userName;
    @Size(min = 8)
    @NotNull
    private String password;
    @Email
    @NotNull
    private String email;
    @Size(min = 11,max = 11)
    @NotNull
    private String cpf;
    @NotNull
    private Contact contact;
    @NotNull
    private Address address;

}
