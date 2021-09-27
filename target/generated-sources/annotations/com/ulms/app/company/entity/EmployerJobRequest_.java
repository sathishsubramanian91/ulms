package com.ulms.app.company.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmployerJobRequest.class)
public abstract class EmployerJobRequest_ extends com.ulms.app.repo.BaseId_ {

	public static volatile SingularAttribute<EmployerJobRequest, String> skills;
	public static volatile SingularAttribute<EmployerJobRequest, Boolean> foodProvided;
	public static volatile SingularAttribute<EmployerJobRequest, String> salaryType;
	public static volatile SingularAttribute<EmployerJobRequest, Long> requestId;
	public static volatile SingularAttribute<EmployerJobRequest, Boolean> accommodation;
	public static volatile SingularAttribute<EmployerJobRequest, String> description;
	public static volatile SingularAttribute<EmployerJobRequest, Double> salary;
	public static volatile SingularAttribute<EmployerJobRequest, Date> requiredFromDate;
	public static volatile SingularAttribute<EmployerJobRequest, Long> noOfPplRequired;
	public static volatile SingularAttribute<EmployerJobRequest, Date> requiredToDate;

	public static final String SKILLS = "skills";
	public static final String FOOD_PROVIDED = "foodProvided";
	public static final String SALARY_TYPE = "salaryType";
	public static final String REQUEST_ID = "requestId";
	public static final String ACCOMMODATION = "accommodation";
	public static final String DESCRIPTION = "description";
	public static final String SALARY = "salary";
	public static final String REQUIRED_FROM_DATE = "requiredFromDate";
	public static final String NO_OF_PPL_REQUIRED = "noOfPplRequired";
	public static final String REQUIRED_TO_DATE = "requiredToDate";

}

