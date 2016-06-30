package com.demo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.SalonDAO;
import com.demo.spring.model.Salon;

@Service
public class SalonServiceImpl implements SalonService {
	
	private SalonDAO salonDAO;

	public void setSalonDAO(SalonDAO salonDAO) {
		this.salonDAO = salonDAO;
	}

	@Override
	@Transactional
	public void addSalon(Salon p) {
		this.salonDAO.addSalon(p);
	}

	@Override
	@Transactional
	public void updateSalon(Salon p) {
		this.salonDAO.updateSalon(p);
	}

	@Override
	@Transactional
	public List<Salon> listSalons() {
		return this.salonDAO.listSalons();
	}

	@Override
	@Transactional
	public Salon getSalonById(int id) {
		return this.salonDAO.getSalonById(id);
	}

	@Override
	@Transactional
	public void removeSalon(int id) {
		this.salonDAO.removeSalon(id);
	}

}
