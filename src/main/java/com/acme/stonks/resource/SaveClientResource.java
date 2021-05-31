package com.acme.stonks.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveClientResource {
    @NotNull
    private Integer dni;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String Country;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
