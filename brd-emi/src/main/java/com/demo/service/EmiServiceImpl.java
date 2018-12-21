package com.demo.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.demo.controller.EmiControllerImpl;
import com.demo.dao.EmiDAO;
import com.demo.entity.EmiParam;
import com.demo.entity.Component;

@Service
public class EmiServiceImpl implements EmiService{
	
    @Autowired
	private EmiDAO emiDAO;
    
	private static final Logger logger = LoggerFactory.getLogger(EmiServiceImpl.class);    
	@Override
	@Transactional
	public void calculateEmi(EmiParam theEmiParam) {
		logger.info("in service");	
		theEmiParam.setEmi(calculator(theEmiParam));
		logger.info("invoking dao");
		emiDAO.saveParam(theEmiParam);
	}
	@Override
	@Transactional
	public void generateSchedule(EmiParam theEmiParam)
	{
		logger.info("generating schedule");
		double principal = Double.parseDouble(theEmiParam.getPrincipal());
		double rateOfInterest = Double.parseDouble(theEmiParam.getRateOfInterest());
		rateOfInterest = rateOfInterest / 100;
		int noOfInstallments =Integer.parseInt(theEmiParam.getNoOfInstallments());
		int periodInMonths =Integer.parseInt(theEmiParam.getPeriodInMonths());
		double monthlyInstallmentAmount=calculator(theEmiParam);
		theEmiParam.setEmi(monthlyInstallmentAmount);
		emiDAO.saveParam(theEmiParam);
		
		int totalNoOfInstallments;
		totalNoOfInstallments = (periodInMonths * noOfInstallments) / 12;	
		//handle excep.... for tenure less than the period of first installment
		float[] interestComponent = new float[totalNoOfInstallments + 1];
		float[] principalComponent = new float[totalNoOfInstallments + 1];
	    float[] outstandingPrincipal = new float[totalNoOfInstallments + 1];
	    outstandingPrincipal[0] = (float) principal;
/*		System.out.println("\ns.no          O/s   \t       I              P        Installment");
*/		for (int l = 0; l < totalNoOfInstallments; l++) {
			interestComponent[l] = (outstandingPrincipal[l]) * ((float) rateOfInterest) / 12.0f;
			principalComponent[l] = ((float) monthlyInstallmentAmount - interestComponent[l]);
			if (l < totalNoOfInstallments) 
			{
				outstandingPrincipal[l + 1] = outstandingPrincipal[l] - principalComponent[l];
/*				System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (l + 1), outstandingPrincipal[l], interestComponent[l], principalComponent[l], monthlyInstallmentAmount);
*/			}
	    }
		
		//deleting previous schedule
        logger.info("deleting old schedule");
		emiDAO.deleteComponents();
		
		//storing the the current schedule
		for(int l=0; l<totalNoOfInstallments;l++)
		{
			Component theComponent = new Component();
			System.out.println(l+1);
			System.out.println();
			theComponent.setInstallmentNO(l+1);
			theComponent.setOutstandingPrincipal(outstandingPrincipal[l]);
			theComponent.setInterestComponent(interestComponent[l]);
			theComponent.setPrincipalComponent(principalComponent[l]);
			theComponent.setEmi(monthlyInstallmentAmount);
			emiDAO.saveComponent(theComponent);
			
		}
		
		
	}
	@Override
	@Transactional
	public List<Component> getComponents() {
		return emiDAO.getComponents();
	}
	@Override
	public double calculator(EmiParam theEmiParam)
	{
		System.out.println("in service method, calculator method");
		double principal = Double.parseDouble(theEmiParam.getPrincipal());
		double rateOfInterest = Double.parseDouble(theEmiParam.getRateOfInterest());
		int noOfInstallments =Integer.parseInt(theEmiParam.getNoOfInstallments());
		int periodInMonths =Integer.parseInt(theEmiParam.getPeriodInMonths());
		int totalNumberOfInstallments;
		totalNumberOfInstallments = (periodInMonths * noOfInstallments) / 12;
		double monthlyInstallmentAmount=0.0;
		rateOfInterest = rateOfInterest / 100;
		monthlyInstallmentAmount = (principal * (rateOfInterest / noOfInstallments))
				/ (1 - 1 / Math.pow((1 + rateOfInterest / noOfInstallments), totalNumberOfInstallments));
//		System.out.printf("Equated monthly installment is: %.2f ", monthlyInstallmentAmount);
		theEmiParam.setEmi(monthlyInstallmentAmount);
		
		return monthlyInstallmentAmount;
	}
	@Override
	@Transactional
	public void generatebreakSchedule(EmiParam theEmiParam) 
	{
		
		System.out.println("generate break");
		int breakup=Integer.parseInt(theEmiParam.getBreakup());
		System.out.println(breakup);
		double principal = Double.parseDouble(theEmiParam.getPrincipal());
		double rateOfInterest = Double.parseDouble(theEmiParam.getRateOfInterest());
		int noOfInstallments =Integer.parseInt(theEmiParam.getNoOfInstallments());
		int periodInMonths =Integer.parseInt(theEmiParam.getPeriodInMonths());
		theEmiParam.setEmi(calculator(theEmiParam));
		emiDAO.saveParam(theEmiParam);
	}
	@Override
	@Transactional
	public List<Component> getComponent(int breakup) {
		System.out.println("in service");
		return emiDAO.getComponent(breakup);
		 
	}
	@Override
	@Transactional
	public int getCount() {
		return emiDAO.getCount();
	}


}
