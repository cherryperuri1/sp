package com.demo.dao;

import java.util.List;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Component;
import com.demo.entity.EmiParam;
@Repository
public class EmiDAOImpl implements EmiDAO{
	@Autowired
	private SessionFactory sessionFactory;	
	@Override
	public void saveParam(EmiParam theEmiParam) {
		System.out.println("inside dao");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theEmiParam);

		
	}
	@Override
	public List<Component> getComponents() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Component> components=null;	
		System.out.println("retriving components from database");
    	Query<Component> theQuery =currentSession.createQuery("from Component ORDER BY installmentNO",Component.class);
		components=theQuery.getResultList();		
		return components;
	}
	@Override
	public void deleteComponents()
	{
		sessionFactory.getCurrentSession().createQuery("delete from Component").executeUpdate();
        
	}
	@Override
	public void saveComponent(Component theComponent)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(theComponent);
	}
	
	
	@Override
	public List<Component> getComponent(int breakup) {
		System.out.println("in dao retriving break component");
		Session currentSession = sessionFactory.getCurrentSession();
		List<Component> components=null;	
        String hql = "from Component where installmentNO= :installmentNO";
        Query<Component> query = currentSession.createQuery(hql);
        query.setParameter("installmentNO", breakup);
		components=query.getResultList();	
		return components;
	}

	@Override
	public int getCount()
	{
		int count = 0;
		Session currentSession = sessionFactory.getCurrentSession();
		String hql="select count(*) from Component";
		Query query=currentSession.createQuery(hql);
		Long res=(Long)query.uniqueResult();
		return res.intValue();
	}
	
	
}
