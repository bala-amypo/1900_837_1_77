@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class User {

    public enum Role { ADMIN, INSTRUCTOR, STUDENT }

    @Id @GeneratedValue
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    private Instant createdAt = Instant.now();
}
