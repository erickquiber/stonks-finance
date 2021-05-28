package com.acme.stonks.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResource {
    private  Long id;
    private Integer dni;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String Country;

}
