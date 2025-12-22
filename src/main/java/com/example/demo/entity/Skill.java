package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    private Long id;
    private String code;
    private String name;
    private boolean active = true;
}
