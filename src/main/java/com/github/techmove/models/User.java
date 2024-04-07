package com.github.techmove.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private String salt;
    private String hash;
    private List<Activity> activities;
    private double score;
    private Guild guild;    
}
