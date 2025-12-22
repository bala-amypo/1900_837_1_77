package com.example.demo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillGapRecommendation {

    private Long id;
    private Long studentProfileId;
    private Long skillId;
    private double gapScore;
    private String recommendation;

    public double getGapScore() {
        return gapScore;
    }
}
