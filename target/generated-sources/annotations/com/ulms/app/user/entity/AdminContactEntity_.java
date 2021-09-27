package com.ulms.app.user.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AdminContactEntity.class)
public abstract class AdminContactEntity_ extends com.ulms.app.repo.BaseId_ {

	public static volatile SingularAttribute<AdminContactEntity, String> officeLandline;
	public static volatile SingularAttribute<AdminContactEntity, String> emailAddress;
	public static volatile SingularAttribute<AdminContactEntity, String> contactPersonName;
	public static volatile SingularAttribute<AdminContactEntity, String> secondaryMobileNumber;
	public static volatile SingularAttribute<AdminContactEntity, Long> userDetailsEntityId;
	public static volatile SingularAttribute<AdminContactEntity, String> primaryMobileNumber;

	public static final String OFFICE_LANDLINE = "officeLandline";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String CONTACT_PERSON_NAME = "contactPersonName";
	public static final String SECONDARY_MOBILE_NUMBER = "secondaryMobileNumber";
	public static final String USER_DETAILS_ENTITY_ID = "userDetailsEntityId";
	public static final String PRIMARY_MOBILE_NUMBER = "primaryMobileNumber";

}

