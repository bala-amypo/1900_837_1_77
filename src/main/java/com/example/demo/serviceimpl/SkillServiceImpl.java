@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public Skill getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = getById(id);
        existing.setName(skill.getName());
        existing.setDescription(skill.getDescription());
        return repository.save(existing);
    }

    @Override
    public void deleteSkill(Long id) {
        repository.deleteById(id);
    }
}
