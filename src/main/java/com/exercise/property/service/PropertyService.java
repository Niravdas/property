package com.exercise.property.service;

import java.util.List;

import com.exercise.property.entity.PropertyEntity;

/**
 * @author Niravdas
 *
 */
public interface PropertyService {
	public PropertyEntity saveProperty(PropertyEntity propertyEntity);
	public String approveProperty(PropertyEntity propertyEntity);
	public List<PropertyEntity> searchProperty(PropertyEntity propertyEntity);
}
