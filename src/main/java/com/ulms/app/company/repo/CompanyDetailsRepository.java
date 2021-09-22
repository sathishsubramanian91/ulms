package com.ulms.app.company.repo;

import com.ulms.app.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyDetailsRepository  extends JpaRepository<CompanyEntity,String> {
    Optional<CompanyEntity> findByuniqueId(String uniqueId);
}
