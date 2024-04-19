package com.github.techmove.models;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ranking 
{
    private Integer month;
    private Integer year;
    private Guild guild;    
    private List<User> users;
}
