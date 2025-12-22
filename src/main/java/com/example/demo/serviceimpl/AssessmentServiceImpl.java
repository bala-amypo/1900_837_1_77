@Service
public class AssessmentServiceImpl {

    private final AssessmentResultRepository repo;

    public AssessmentServiceImpl(AssessmentResultRepository repo) {
        this.repo = repo;
    }

    public AssessmentResult recordAssessment(AssessmentResult r) {
        if (r.getScore() == null ||
            r.getScore() < 0 ||
            r.getScore() > r.getMaxScore())
            throw new IllegalArgumentException("Score");

        return repo.save(r);
    }
}
