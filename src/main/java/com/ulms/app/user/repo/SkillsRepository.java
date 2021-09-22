package com.ulms.app.user.repo;

import com.ulms.app.user.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<SkillEntity,Long> {

   Optional<SkillEntity> findByName(String name);

}
