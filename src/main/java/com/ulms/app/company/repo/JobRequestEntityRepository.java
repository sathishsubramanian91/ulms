package com.ulms.app.company.repo;

import com.ulms.app.company.entity.JobRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRequestEntityRepository extends JpaRepository<JobRequestEntity,Long> {


  @Query(value = "select * from JobRequestEntity je where je.user_id= :requestId ",nativeQuery = true)
  List<JobRequestEntity> findRequestByUserId(Long requestId);


}
