package com.example.demo.entity;

import lombok.*;
import java.time.Instant;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillGapRecommendation {

    private Long id;
    private Skill skill;
    private Double gapScore;
    private String generatedBy;
    private Instant generatedAt = Instant.now();
}
