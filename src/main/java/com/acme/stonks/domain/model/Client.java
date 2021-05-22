package com.acme.stonks.domain.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotNull
    private Integer dni;
    @NotNull
    private String name;
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


}
