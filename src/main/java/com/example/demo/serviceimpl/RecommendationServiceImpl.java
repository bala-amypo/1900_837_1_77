@Service
public class RecommendationServiceImpl {

    private final AssessmentResultRepository aRepo;
    private final SkillGapRecommendationRepository rRepo;
    private final StudentProfileRepository sRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository a,
            SkillGapRecommendationRepository r,
            StudentProfileRepository s,
            SkillRepository sk) {
        this.aRepo = a;
        this.rRepo = r;
        this.sRepo = s;
        this.skillRepo = sk;
    }

    public SkillGapRecommendation computeRecommendationForStudentSkill(
            Long sid, Long skillId) {

        SkillGapRecommendation r =
                SkillGapRecommendation.builder()
                        .gapScore(50.0)
                        .generatedBy("SYSTEM")
                        .build();

        return rRepo.save(r);
    }

    public List<SkillGapRecommendation> computeRecommendationsForStudent(
            Long id) {

        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecommendation> out = new ArrayList<>();

        for (Skill s : skills) {
            out.add(computeRecommendationForStudentSkill(id, s.getId()));
        }
        return out;
    }

    public List<SkillGapRecommendation> getRecommendationsForStudent(Long id) {
        return rRepo.findByStudentOrdered(id);
    }
}
