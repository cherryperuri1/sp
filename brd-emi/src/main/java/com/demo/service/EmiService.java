package com.demo.service;

import java.util.List;

import com.demo.entity.Component;
import com.demo.entity.EmiParam;

public interface EmiService {
	public void calculateEmi(EmiParam theEmiParam);
	public void generateSchedule(EmiParam theEmiParam);
	public double calculator(EmiParam theEmiParam);
	public void generatebreakSchedule(EmiParam theEmiParam);
	public List<Component> getComponents();
	public List<Component> getComponent(int breakup);
	public int getCount();


}
