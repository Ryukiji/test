package com.demo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.spring.model.Employe;
import com.demo.spring.model.Salon;

@Repository
public class SalonDAOImpl implements SalonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SalonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addSalon(Salon p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Salon saved successfully, Salon Details="+p);
	}

	@Override
	public void updateSalon(Salon p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Salon updated successfully, Salon Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salon> listSalons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Salon> salonsList = session.createQuery("from Salon").list();
		for(Salon p : salonsList){
			logger.info("Salon List::"+p);
		}
		return salonsList;
	}

	@Override
	public Salon getSalonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Salon p = (Salon) session.load(Salon.class, new Integer(id));
		logger.info("Salon loaded successfully, Salon details="+p);
		return p;
	}

	@Override
	public void removeSalon(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Salon p = (Salon) session.load(Salon.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Salon deleted successfully, salon details="+p);
	}



	

}
