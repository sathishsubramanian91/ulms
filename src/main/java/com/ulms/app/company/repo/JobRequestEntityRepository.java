package com.ulms.app.company.repo;

import com.ulms.app.company.entity.JobRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRequestEntityRepository extends JpaRepository<JobRequestEntity,Long> {
}
