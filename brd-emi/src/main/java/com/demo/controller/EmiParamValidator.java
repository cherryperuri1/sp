package com.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import com.demo.entity.EmiParam;

@Component
public class EmiParamValidator implements Validation {
	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "principal", "principal.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rateOfInterest", "rateOfInterest.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "periodInMonths", "periodInMonths.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noOfInstallments", "noOfInstallments.required");

		EmiParam emiParam = (EmiParam) target;
		String principal = emiParam.getPrincipal();

		if (principal != null && principal != "") {
			System.out.println(principal);
			try {
				Double dPrincipal = Double.parseDouble(principal);
				if ((dPrincipal < 1) || (dPrincipal > 5000000)) {
					errors.rejectValue("principal", "outOfRange", new Object[] { "'principal'" },
							"Please enter values between '1' and '5000000'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("principal", "notNumber", new Object[] { "'principal'" },
						"Please enter positive integers");

			}

		}
		String rateOfInterest = emiParam.getRateOfInterest();

		if (rateOfInterest != null && rateOfInterest != "") {
			System.out.println(rateOfInterest);
			try {
				Double dRateOfInterest = Double.parseDouble(rateOfInterest);
				if ((dRateOfInterest < 1) || (dRateOfInterest > 120)) {
					errors.rejectValue("rateOfInterest", "outOfRange", new Object[] { "'rateOfInterest'" },
							"Please enter values between '1' and '120'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("rateOfInterest", "notNumber", new Object[] { "'rateOfInterest'" },
						"Please enter positive integers");

			}

		}

		String noOfInstallments = emiParam.getNoOfInstallments();

		if (noOfInstallments != null && noOfInstallments != "") {
			System.out.println(noOfInstallments);
			try {
				Double dNoOfInstallments = Double.parseDouble(noOfInstallments);
				if ((dNoOfInstallments < 1) || (dNoOfInstallments > 12)) {
					errors.rejectValue("noOfInstallments", "outOfRange", new Object[] { "'noOfInstallments'" },
							"Number of installment can only be between'1' and '12' in year");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("noOfInstallments", "notNumber", new Object[] { "'noOfInstallments'" },
						"Please enter positive integers");

			}

		}

		String periodInMonths = emiParam.getPeriodInMonths();

		if (periodInMonths != null && periodInMonths != "") {
			System.out.println(periodInMonths);
			try {
				Double dPeriodInMonths = Double.parseDouble(periodInMonths);
				if ((dPeriodInMonths < 1)) {
					errors.rejectValue("periodInMonths", "outOfRange", new Object[] { "'periodInMonths'" },
							"Period should be atleast '1'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("periodInMonths", "notNumber", new Object[] { "'periodInMonths'" },
						"Period is a positive integer");

			}

		}

	}
@Override
	public void validatebreak(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "principal", "principal.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rateOfInterest", "rateOfInterest.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "periodInMonths", "periodInMonths.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noOfInstallments", "noOfInstallments.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "breakup", "breakup.required");

		EmiParam emiParam = (EmiParam) target;
		String principal = emiParam.getPrincipal();

		if (principal != null && principal != "") {
			System.out.println(principal);
			try {
				Double dPrincipal = Double.parseDouble(principal);
				if ((dPrincipal < 1) || (dPrincipal > 5000000)) {
					errors.rejectValue("principal", "outOfRange", new Object[] { "'principal'" },
							"Please enter values between '1' and '5000000'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("principal", "notNumber", new Object[] { "'principal'" },
						"Please enter positive integers");

			}

		}
		String rateOfInterest = emiParam.getRateOfInterest();

		if (rateOfInterest != null && rateOfInterest != "") {
			System.out.println(rateOfInterest);
			try {
				Double dRateOfInterest = Double.parseDouble(rateOfInterest);
				if ((dRateOfInterest < 1) || (dRateOfInterest > 120)) {
					errors.rejectValue("rateOfInterest", "outOfRange", new Object[] { "'rateOfInterest'" },
							"Please enter values between '1' and '120'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("rateOfInterest", "notNumber", new Object[] { "'rateOfInterest'" },
						"Please enter positive integers");

			}

		}

		String noOfInstallments = emiParam.getNoOfInstallments();

		if (noOfInstallments != null && noOfInstallments != "") {
			System.out.println(noOfInstallments);
			try {
				Double dNoOfInstallments = Double.parseDouble(noOfInstallments);
				if ((dNoOfInstallments < 1) || (dNoOfInstallments > 12)) {
					errors.rejectValue("noOfInstallments", "outOfRange", new Object[] { "'noOfInstallments'" },
							"Number of installment can only be between'1' and '12' in year");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("noOfInstallments", "notNumber", new Object[] { "'noOfInstallments'" },
						"Please enter positive integers");

			}

		}

		String periodInMonths = emiParam.getPeriodInMonths();

		if (periodInMonths != null && periodInMonths != "") {
			System.out.println(periodInMonths);
			try {
				Double dPeriodInMonths = Double.parseDouble(periodInMonths);
				if ((dPeriodInMonths < 1)) {
					errors.rejectValue("periodInMonths", "outOfRange", new Object[] { "'periodInMonths'" },
							"Period should be atleast '1'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("periodInMonths", "notNumber", new Object[] { "'periodInMonths'" },
						"Period is a positive integer");

			}

		}
		
		String breakup = emiParam.getBreakup();

		if (breakup != null && breakup != "") {
			System.out.println(breakup);
			try {
				Double dBreakup = Double.parseDouble(breakup);
				if ((dBreakup < 1)) {
					errors.rejectValue("breakup", "outOfRange", new Object[] { "'breakup'" },
							"Installment number should be atleast '1'");

				}

			} catch (NumberFormatException numberFormatException) {

				errors.rejectValue("breakup", "notNumber", new Object[] { "'breakup'" },
						"Installment number is a positive integer");

			}

		}

}
@Override
	public void validateCount(Object target, Errors errors, int count) {
	EmiParam emiParam = (EmiParam) target;
	String principal = emiParam.getPrincipal();
	String breakup = emiParam.getBreakup();
	Double dBreakup = Double.parseDouble(breakup);
	if ((dBreakup >count)) {
		errors.rejectValue("breakup", "outOfRange", new Object[] { "'breakup'" },
				"Installment number you entered is greater than total schedule");

	}
		
	}
}
