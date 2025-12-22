@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class StudentProfile {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String enrollmentId;

    private String grade;

    private Instant lastUpdatedAt = Instant.now();

    @PreUpdate
    public void preUpdate() {
        lastUpdatedAt = Instant.now();
    }
}
