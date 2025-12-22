@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class SkillGapRecommendation {

    @Id @GeneratedValue
    private Long id;

    private Double gapScore;

    private String generatedBy;

    private Instant generatedAt = Instant.now();
}
