package com.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.demo.entity.EmiParam;

public interface Validation {

	void validate(Object target, Errors errors);

	void validatebreak(Object target, Errors errors);

	void validateCount(Object target, Errors errors, int count);


}
