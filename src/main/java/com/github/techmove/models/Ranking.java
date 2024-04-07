package com.github.techmove.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ranking {
    private Integer position;
    private Integer month;
    private Integer year;
    private User user;
    private Guild guild;    
}
