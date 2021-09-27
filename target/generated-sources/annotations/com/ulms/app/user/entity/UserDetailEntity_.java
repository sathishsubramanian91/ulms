package com.ulms.app.user.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDetailEntity.class)
public abstract class UserDetailEntity_ extends com.ulms.app.repo.BaseId_ {

	public static volatile SingularAttribute<UserDetailEntity, String> firstname;
	public static volatile SingularAttribute<UserDetailEntity, String> password;
	public static volatile SingularAttribute<UserDetailEntity, String> role;
	public static volatile SingularAttribute<UserDetailEntity, Boolean> isActivated;
	public static volatile SingularAttribute<UserDetailEntity, Boolean> isActive;
	public static volatile SingularAttribute<UserDetailEntity, String> email;
	public static volatile SingularAttribute<UserDetailEntity, String> lastname;
	public static volatile SingularAttribute<UserDetailEntity, String> username;

	public static final String FIRSTNAME = "firstname";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String IS_ACTIVATED = "isActivated";
	public static final String IS_ACTIVE = "isActive";
	public static final String EMAIL = "email";
	public static final String LASTNAME = "lastname";
	public static final String USERNAME = "username";

}

