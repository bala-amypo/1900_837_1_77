List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId);

List<AssessmentResult> findResultsForStudentBetween(
        Long studentId,
        Instant start,
        Instant end
);

Double avgScoreByCohortAndSkill(String grade, Long skillId);
