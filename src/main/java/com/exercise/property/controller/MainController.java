package com.exercise.property.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.property.entity.PropertyEntity;
import com.exercise.property.service.PropertyService;
import com.exercise.property.utilities.HTTPHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Niravdas
 */
@RestController
public class MainController {

	@Autowired
	PropertyService propertyService;

	@RequestMapping(path = "/")
	public String main() {
		return "Test API through postman";
	}

	@RequestMapping(path = "/create-property", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HTTPHelper createProperty(@RequestBody PropertyEntity propertyEntity) {
		try {
			return new HTTPHelper(HttpStatus.OK.value(), propertyService.saveProperty(propertyEntity), "Success");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new HTTPHelper(HttpStatus.OK.value(), "Internal Error");
		}
	}

	@RequestMapping(path = "/update-property", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HTTPHelper updateProperty(@RequestBody PropertyEntity propertyEntity) {
		try {
			return new HTTPHelper(HttpStatus.OK.value(), propertyService.saveProperty(propertyEntity), "Success");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new HTTPHelper(HttpStatus.OK.value(), "Internal Error");
		}
	}

	@RequestMapping(path = "/approve-property")
	public HTTPHelper approveProperty(@RequestParam("id") Long id) {
		PropertyEntity propertyEntity = new PropertyEntity();
		propertyEntity.setId(id);
		return new HTTPHelper(HttpStatus.OK.value(), propertyService.approveProperty(propertyEntity));
	}

	@RequestMapping(path = "/search-property", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HTTPHelper searchProperty(@RequestBody PropertyEntity propertyEntity) {
		try {
			return new HTTPHelper(HttpStatus.OK.value(), propertyService.searchProperty(propertyEntity), "Success");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new HTTPHelper(HttpStatus.OK.value(), "Internal Error");
		}
	}
}
