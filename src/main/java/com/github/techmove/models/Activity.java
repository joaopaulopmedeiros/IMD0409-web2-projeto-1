package com.github.techmove.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
    private Long id;
    private LocalDateTime publishedAt;
    private User user;
    private ActivityType type;
}
