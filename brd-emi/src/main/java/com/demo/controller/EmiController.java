package com.demo.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.demo.entity.EmiParam;

public interface EmiController {
	public String getParam(Model theModel );
	String calculateEmi(Model themodel, EmiParam theEmiParam, BindingResult result);
	String schedule(Model theModel, EmiParam theEmiParam, BindingResult result);
	String breakschedule(Model theModel, EmiParam theEmiParam, BindingResult result);
	
	
}
