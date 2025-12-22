@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentResultRepository repository;

    public AssessmentServiceImpl(AssessmentResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssessmentResult recordAssessment(AssessmentResult result) {

        if (result.getScore() == null || result.getMaxScore() == null) {
            throw new IllegalArgumentException("Score cannot be null");
        }

        if (result.getScore() > result.getMaxScore()) {
            throw new IllegalArgumentException("Score exceeds maximum");
        }

        return repository.save(result);
    }
}
