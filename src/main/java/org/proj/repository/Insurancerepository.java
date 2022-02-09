package org.proj.repository;

import java.io.Serializable;
import java.util.List;

import org.proj.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Insurancerepository extends JpaRepository<InsuranceEntity, Serializable> {
	@Query("select distinct planName from InsuranceEntity")
public List<String> getplansNames();
	@Query("select distinct planStatus from InsuranceEntity")
	public List<String> getplanStatus();
	
}
