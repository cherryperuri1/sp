package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.EmiParam;
import com.demo.entity.Component;
import com.demo.service.EmiService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class EmiControllerImpl implements EmiController {
	@Autowired
	private EmiService emiService;

	@Autowired
	EmiParamValidator validator;

	private static final Logger logger = LoggerFactory.getLogger(EmiControllerImpl.class);

	@GetMapping("/emi")
	public String getParam(Model theModel) {
		EmiParam theEmiParam = new EmiParam();
		theModel.addAttribute("emiParam", theEmiParam);

		List<Component> theComponents = null;
		theModel.addAttribute("components", theComponents);

		logger.info("Showing emi calculator page");
		return "emi-calculator";
	}

	@Override
	@PostMapping("/calculate")
	public String calculateEmi(Model theModel, @Valid @ModelAttribute("emiParam") EmiParam theEmiParam,
			BindingResult result) {
		validator.validate(theEmiParam, result);
		if (result.hasErrors()) {
			logger.info("errors in input");
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					logger.info("error:" + fieldError.getCode());

				}
			}

			return "emi-calculator";
		}

		logger.info("No errors");
		theEmiParam.setSno(1);
		logger.info("invoking service to calculate installment");
		emiService.calculateEmi(theEmiParam);

		theModel.addAttribute("emiParam", theEmiParam);
		theModel.addAttribute("error", "true");
		theModel.addAttribute("emival", Math.round(theEmiParam.getEmi()));
		return "emi-calculator";
	}

	@Override
	@PostMapping("schedule")
	public String schedule(Model theModel, @Valid @ModelAttribute("emiParam") EmiParam theEmiParam,
			BindingResult result) {

		validator.validate(theEmiParam, result);
		if (result.hasErrors()) {
			logger.info("errors in input");
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					logger.info("error:" + fieldError.getCode());
				}
			}
			return "emi-calculator";

		}

		logger.info("No errors");
		theEmiParam.setSno(2);
		logger.info("generating repayments schedule");
		emiService.generateSchedule(theEmiParam);
		logger.info("schedule created");

		// retrieving the records
		logger.info("retrieving schedule from database");
		List<Component> theComponents = emiService.getComponents();
		theModel.addAttribute("components", theComponents);
		theModel.addAttribute("emiParam", theEmiParam);
		theModel.addAttribute("emival", Math.round(theEmiParam.getEmi()));
		return "emi-calculator";
	}

	@Override
	@PostMapping("breakschedule")
	public String breakschedule(Model theModel, @Valid @ModelAttribute("emiParam") EmiParam theEmiParam,
			BindingResult result) {
		validator.validatebreak(theEmiParam, result);
		if (result.hasErrors()) {
			logger.info("errors in input");
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					logger.info("error:" + fieldError.getCode());
				}
			}
			return "emi-calculator";

		}

		theEmiParam.setSno(2);
		logger.info("generating schedule");
		emiService.generateSchedule(theEmiParam);
		logger.info("schedule created");

		int count=emiService.getCount();
		validator.validateCount(theEmiParam, result,count);
		if (result.hasErrors()) {
			logger.info("errors in input");
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					logger.info("error:" + fieldError.getCode());
				}
			}
			return "emi-calculator";

		}
		// retrieving the record
		logger.info("processing particular break component");
		int breakup = Integer.parseInt(theEmiParam.getBreakup());
		List<Component> theComponents = emiService.getComponent(breakup);
		logger.info("obtained component");
		theModel.addAttribute("components", theComponents);
		theModel.addAttribute("emiParam", theEmiParam);
		theModel.addAttribute("emival", Math.round(theEmiParam.getEmi()));
		return "emi-calculator";
	}

}
