package com.example.demo.repository;

import com.example.demo.entity.Skill;
import java.util.*;

public interface SkillRepository {
    Optional<Skill> findByCode(String code);
    Optional<Skill> findById(Long id);
    List<Skill> findByActiveTrue();
    Skill save(Skill skill);
}
