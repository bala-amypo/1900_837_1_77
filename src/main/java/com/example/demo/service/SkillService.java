public interface SkillService {

    Skill createSkill(Skill skill);

    List<Skill> getAllSkills();

    Skill getById(Long id);

    Skill updateSkill(Long id, Skill skill);

    void deleteSkill(Long id);
}
