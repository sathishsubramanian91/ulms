package com.ulms.app.employee.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmployeEntity.class)
public abstract class EmployeEntity_ extends com.ulms.app.repo.BaseId_ {

	public static volatile SingularAttribute<EmployeEntity, String> skills;
	public static volatile SingularAttribute<EmployeEntity, String> employeeName;
	public static volatile SingularAttribute<EmployeEntity, String> country;
	public static volatile SingularAttribute<EmployeEntity, String> address;
	public static volatile SingularAttribute<EmployeEntity, String> aadharNumber;
	public static volatile SingularAttribute<EmployeEntity, String> city;
	public static volatile SingularAttribute<EmployeEntity, String> district;
	public static volatile SingularAttribute<EmployeEntity, String> contactNumber;
	public static volatile SingularAttribute<EmployeEntity, String> panNumber;
	public static volatile SingularAttribute<EmployeEntity, String> state;
	public static volatile SingularAttribute<EmployeEntity, String> uniqueId;

	public static final String SKILLS = "skills";
	public static final String EMPLOYEE_NAME = "employeeName";
	public static final String COUNTRY = "country";
	public static final String ADDRESS = "address";
	public static final String AADHAR_NUMBER = "aadharNumber";
	public static final String CITY = "city";
	public static final String DISTRICT = "district";
	public static final String CONTACT_NUMBER = "contactNumber";
	public static final String PAN_NUMBER = "panNumber";
	public static final String STATE = "state";
	public static final String UNIQUE_ID = "uniqueId";

}

