package com.example.demo.dto;

import java.sql.Timestamp;

public class RecommendationDTO {

    private Long studentProfileId;
    private Long skillId;
    private String skillName;
    private Double gapScore;
    private String priority;
    private String recommendedAction;
    private Timestamp generatedAt;

    // getters & setters
}
