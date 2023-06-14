package com.practice.assignment.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.practice.assignment.Entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	@Query("SELECT e  from StudentEntity e where e.first_name=?1" )
	public List<StudentEntity> showByName(String name);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM StudentEntity e where e.first_name=?1")
	public int deleteByName(String name);
}
	