@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class AssessmentResult {

    @Id @GeneratedValue
    private Long id;

    private String assessmentId;

    private Double score;

    private Double maxScore = 100.0;

    private Instant attemptedAt = Instant.now();
}
