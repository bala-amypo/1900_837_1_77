@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;

    private String recommendedAction;
    private String priority;
    private Double gapScore;
    private String generatedBy;

    @Builder.Default
    private Instant generatedAt = Instant.now();
}
