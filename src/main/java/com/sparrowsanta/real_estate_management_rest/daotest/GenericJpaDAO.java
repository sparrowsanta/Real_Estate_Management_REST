package com.sparrowsanta.real_estate_management_rest.daotest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericJpaDAO< T extends Serializable>
        extends AbstractJpaDAO< T > {

}
