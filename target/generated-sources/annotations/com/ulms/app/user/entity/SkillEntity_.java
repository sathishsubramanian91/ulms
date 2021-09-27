package com.ulms.app.user.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SkillEntity.class)
public abstract class SkillEntity_ extends com.ulms.app.repo.BaseId_ {

	public static volatile ListAttribute<SkillEntity, SubCategory> subCategory;
	public static volatile SingularAttribute<SkillEntity, String> name;

	public static final String SUB_CATEGORY = "subCategory";
	public static final String NAME = "name";

}

