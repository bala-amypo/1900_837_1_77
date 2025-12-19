@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    // ✅ CREATE → POST
    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        return ResponseEntity.ok(service.createSkill(skill));
    }

    // ✅ READ (ALL) → GET
    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    // ✅ READ (BY ID) → GET
    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // ✅ UPDATE → PUT
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(
            @PathVariable Long id,
            @RequestBody Skill skill) {
        return ResponseEntity.ok(service.updateSkill(id, skill));
    }

    // ✅ DELETE → DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {
        service.deleteSkill(id);
        return ResponseEntity.ok("Skill deleted successfully");
    }
}
