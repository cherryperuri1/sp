package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "component")
public class Component {
	@Id
	@Column(name = "installment_no")
	private int installmentNO;
	
	@Column(name = "outstanding_principal")
	private double outstandingPrincipal;
	
	@Column(name = "interest_component")
	private double interestComponent;

	@Column(name = "principal_component")
	private double principalComponent;
	
	@Column(name = "emi")
	private double emi;

	@Override
	public String toString() {
		return "Component [installmentNO=" + installmentNO + ", outstandingPrincipal=" + outstandingPrincipal
				+ ", interestComponent=" + interestComponent + ", principalComponent=" + principalComponent + ", emi="
				+ emi + "]";
	}

	public int getInstallmentNO() {
		return installmentNO;
	}

	public void setInstallmentNO(int installmentNO) {
		this.installmentNO = installmentNO;
	}

	public double getOutstandingPrincipal() {
		return outstandingPrincipal;
	}

	public void setOutstandingPrincipal(double outstandingPrincipal) {
		this.outstandingPrincipal = outstandingPrincipal;
	}

	public double getInterestComponent() {
		return interestComponent;
	}

	public void setInterestComponent(double interestComponent) {
		this.interestComponent = interestComponent;
	}

	public double getPrincipalComponent() {
		return principalComponent;
	}

	public void setPrincipalComponent(double principalComponent) {
		this.principalComponent = principalComponent;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}
	


}
