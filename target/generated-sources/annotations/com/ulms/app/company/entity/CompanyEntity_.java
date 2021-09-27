package com.ulms.app.company.entity;

import com.ulms.app.user.entity.UserDetailEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CompanyEntity.class)
public abstract class CompanyEntity_ extends com.ulms.app.repo.BaseId_ {

	public static volatile SingularAttribute<CompanyEntity, String> country;
	public static volatile SingularAttribute<CompanyEntity, String> address;
	public static volatile SingularAttribute<CompanyEntity, String> city;
	public static volatile SingularAttribute<CompanyEntity, String> companyName;
	public static volatile SingularAttribute<CompanyEntity, String> contactPerson;
	public static volatile SingularAttribute<CompanyEntity, String> panNumber;
	public static volatile SingularAttribute<CompanyEntity, String> natureOfBusiness;
	public static volatile SingularAttribute<CompanyEntity, UserDetailEntity> userDetailEntity;
	public static volatile SingularAttribute<CompanyEntity, String> gstNumber;
	public static volatile SingularAttribute<CompanyEntity, String> district;
	public static volatile SingularAttribute<CompanyEntity, String> contactNumber;
	public static volatile SingularAttribute<CompanyEntity, String> state;
	public static volatile SingularAttribute<CompanyEntity, String> uniqueId;

	public static final String COUNTRY = "country";
	public static final String ADDRESS = "address";
	public static final String CITY = "city";
	public static final String COMPANY_NAME = "companyName";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String PAN_NUMBER = "panNumber";
	public static final String NATURE_OF_BUSINESS = "natureOfBusiness";
	public static final String USER_DETAIL_ENTITY = "userDetailEntity";
	public static final String GST_NUMBER = "gstNumber";
	public static final String DISTRICT = "district";
	public static final String CONTACT_NUMBER = "contactNumber";
	public static final String STATE = "state";
	public static final String UNIQUE_ID = "uniqueId";

}

