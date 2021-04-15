package com.exercise.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.property.entity.PropertyEntity;
import com.exercise.property.repository.PropertyRepository;

/**
 * @author Niravdas
 *
 */
@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyRepository propertyRepository; 
	
	@Override
	public PropertyEntity saveProperty(PropertyEntity propertyEntity) {
		return propertyRepository.save(propertyEntity);
	}
	@Override
	public String approveProperty(PropertyEntity propertyEntity) {
		try {
			propertyRepository.approve(propertyEntity.getId());
			return "Approved"; 
		} catch (Exception e) {
			e.printStackTrace();
			return "Not Approved"; 
		}
	}
	@Override
	public List<PropertyEntity> searchProperty(PropertyEntity propertyEntity) {
		return (List<PropertyEntity>) propertyRepository.findByCriteria(propertyEntity);
	}
}
