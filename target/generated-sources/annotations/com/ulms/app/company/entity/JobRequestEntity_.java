package com.ulms.app.company.entity;

import com.ulms.app.user.entity.UserDetailEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JobRequestEntity.class)
public abstract class JobRequestEntity_ extends com.ulms.app.repo.BaseId_ {

	public static volatile ListAttribute<JobRequestEntity, EmployerJobRequest> jobRequestList;
	public static volatile SingularAttribute<JobRequestEntity, Date> requestedDate;
	public static volatile SingularAttribute<JobRequestEntity, UserDetailEntity> user;
	public static volatile SingularAttribute<JobRequestEntity, String> status;

	public static final String JOB_REQUEST_LIST = "jobRequestList";
	public static final String REQUESTED_DATE = "requestedDate";
	public static final String USER = "user";
	public static final String STATUS = "status";

}

