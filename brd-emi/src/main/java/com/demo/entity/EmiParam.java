package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "emi_param")
public class EmiParam {

	@Column(name = "breakup")
	private String breakup;
	@Column(name = "emi")
	private double emi;
	
	@Column(name = "no_of_installments")
    private String noOfInstallments;
	
    public String getBreakup() {
		return breakup;
	}





	public void setBreakup(String breakup) {
		this.breakup = breakup;
	}

	@Column(name = "period_in_months")
	private String periodInMonths;
    
	@Column(name = "principal")
	private String principal;
    
	@Column(name = "rate_of_interest")
	private String rateOfInterest;

	@Id
	@Column(name = "sno")
	private int sno;
	

	public double getEmi() {
		return emi;
	}




	
	public int getSno() {
		return sno;
	}





	public void setEmi(double monthlyInstallmentAmount) {
		this.emi = monthlyInstallmentAmount;
	}



	public String getNoOfInstallments() {
		return noOfInstallments;
	}

	public void setNoOfInstallments(String noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}





	public String getPeriodInMonths() {
		return periodInMonths;
	}

	public void setPeriodInMonths(String periodInMonths) {
		this.periodInMonths = periodInMonths;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}



	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "EmiParam [emi=" + emi + ", noOfInstallments=" + noOfInstallments + ", breakup=" + breakup
				+ ", periodInMonths=" + periodInMonths + ", principal=" + principal + ", rateOfInterest="
				+ rateOfInterest + ", sno=" + sno + "]";
	}

}
