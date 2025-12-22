@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Skill {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    private boolean active = true;
}
