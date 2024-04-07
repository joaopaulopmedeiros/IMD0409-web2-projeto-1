package com.github.techmove.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ranking {
    private Integer month;
    private Integer year;
    private Guild guild;    
    private List<User> users;
}
