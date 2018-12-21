package com.demo.dao;

import java.util.List;

import com.demo.entity.Component;
import com.demo.entity.EmiParam;

public interface EmiDAO {

	public void saveParam(EmiParam theEmiParam);

	public List<Component> getComponents();

	public void deleteComponents();

	public void saveComponent(Component theComponent);

	public List<Component> getComponent(int breakup);

	int getCount();

}
