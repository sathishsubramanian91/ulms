package com.ulms.app.user.services;

import com.ulms.app.user.dto.SkillsDto;
import com.ulms.app.user.entity.SkillEntity;
import com.ulms.app.user.entity.SubCategory;
import com.ulms.app.user.repo.SkillsRepository;
import com.ulms.app.user.repo.SubCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class SkillServices {

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Transactional
    public List<SkillsDto> getAllSkills() {
        List<SkillEntity>  skills=skillsRepository.findAll();
        return skills.stream().flatMap(s -> Stream.ofNullable(s))
                .map(each -> {
                    SkillsDto skillsDto=new SkillsDto();
                    skillsDto.setId(each.getId());
                    skillsDto.setName(each.getName());
                    if(each.getSubCategory() != null)
                        skillsDto.setSubCategory(each.getSubCategory().
                                stream().map(SubCategory::getName)
                                .collect(Collectors.toList()));
                    return skillsDto;
                }).collect(Collectors.toList());

    }

    @Transactional
    public boolean save(String skill,String subskill){
        Optional<SkillEntity> skillEntity=skillsRepository.findByName(skill);
        if(skillEntity.isEmpty())
           throw new RuntimeException("Skill is not present in DB");
        subCategoryRepository.save(new SubCategory(subskill,skillEntity.get().getId()));
        return true;
    }


    @Transactional
    public boolean save(SkillsDto skill) {
        try {
            Optional<SkillEntity> skills=skillsRepository.findByName(skill.getName());
            if(!skills.isEmpty() && skill.getSubCategory()!=null){
               skills.get().getSubCategory().addAll(skill.getSubCategory().stream()
                       .map(each -> new SubCategory(each,skills.get().getId()))
                       .collect(Collectors.toList()));
            } else {
                SkillEntity entity = new SkillEntity();
                entity.setName(skill.getName());
                entity = skillsRepository.saveAndFlush(entity);
                if (skill.getSubCategory() != null) {
                    Long skillId = entity.getId();
                    skill.getSubCategory().stream().flatMap(s -> Stream.ofNullable(s))
                            .forEach(each -> {
                                SubCategory subCategory = new SubCategory();
                                subCategory.setName(each);
                                subCategory.setSkillId(skillId);
                                subCategoryRepository.save(subCategory);
                            });
                }
            }
        }catch(Exception ex){
            log.info("Exception occurred while saving "+ ex);
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        skillsRepository.deleteById(id);
    }

    @Transactional
    public void delete(String skill,String subskill){
        Optional<SkillEntity> skillEntity=skillsRepository.findByName(skill);
        if(skillEntity.isEmpty())
            throw new RuntimeException("Skill entity is not present");
        Optional<SubCategory> subCategory=subCategoryRepository.findByName(subskill);
        if(subCategory.isEmpty())
            throw new RuntimeException("sub skill is not present");
        subCategoryRepository.deleteById(subCategory.get().getId());
    }
}
