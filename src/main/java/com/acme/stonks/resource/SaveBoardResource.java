package com.acme.stonks.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveBoardResource {
    @NotNull
    private String name;

}
