package com.ulms.app.user.repo;

import com.ulms.app.user.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

    Optional<SubCategory> findByName(String name);

}
