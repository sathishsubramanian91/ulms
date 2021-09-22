package com.ulms.app.company.repo;

import com.ulms.app.company.entity.EmployerJobRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerJobRequestRepository extends JpaRepository<EmployerJobRequest,Long> {

}
