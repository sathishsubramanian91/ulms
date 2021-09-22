package com.ulms.app.employee.repo;

import com.ulms.app.employee.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository  extends JpaRepository<EmployeEntity,Long> {
}
