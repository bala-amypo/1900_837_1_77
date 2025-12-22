@Service
public class SkillServiceImpl {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    public Skill createSkill(Skill s) {
        if (repo.findByCode(s.getCode()).isPresent())
            throw new IllegalArgumentException("unique");
        return repo.save(s);
    }

    public Skill updateSkill(Long id, Skill s) {
        Skill ex = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        ex.setName(s.getName());
        return repo.save(ex);
    }

    public Skill getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Skill> getActiveSkills() {
        return repo.findByActiveTrue();
    }
}
