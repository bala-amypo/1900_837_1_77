package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class RecommendationDTO {
    private Long studentProfileId;
    private Long skillId;
    private String skillName;
    private Double gapScore;
    private String priority;
    private String recommendedAction;
    private Instant generatedAt;
}
