package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.model.Salon;

public interface SalonDAO {
	public void addSalon(Salon p);
	public void updateSalon(Salon p);
	public List<Salon> listSalons();
	public Salon getSalonById(int id);
	public void removeSalon(int id);
}