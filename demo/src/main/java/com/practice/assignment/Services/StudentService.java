package com.practice.assignment.Services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.assignment.DTO.StudentDTO;
import com.practice.assignment.Entities.StudentEntity;
import com.practice.assignment.Repositories.StudentRepository;

@Service
public class StudentService {

	StudentRepository studentRepository;
	
	public StudentService(@Autowired StudentRepository student ) {
		// TODO Auto-generated constructor stub
		this.studentRepository=student;
	}
	
	
	public StudentDTO saveStudent(StudentDTO student)
	{
		ModelMapper mapper=new ModelMapper();
		
		StudentEntity studentEntity=mapper.map(student,StudentEntity.class);
		StudentEntity returnedStudentEntity=this.studentRepository.save(studentEntity);
		StudentDTO returnedStudentDTO=mapper.map(returnedStudentEntity, StudentDTO.class);
		
		return returnedStudentDTO;	
		
	}
	
	
	
	
	public List<StudentDTO> getStudents()
	{
		ModelMapper mapper=new ModelMapper();
		Iterable<StudentEntity> listStudentEntity=this.studentRepository.findAll();
		
		List<StudentDTO> listProductDTO=new ArrayList<>();
		
		for(StudentEntity studentEntity:listStudentEntity)
		{
			StudentDTO studentDTO=mapper.map(studentEntity, StudentDTO.class);
			
			listProductDTO.add(studentDTO);
		}
		return listProductDTO;
			
	}
	
	
	public void deleteStudentByName(String name)
	{
		this.studentRepository.deleteByName(name);
	}
	
	
	public List<StudentDTO>getstudentByName(String name)
	{
		
		List<StudentEntity> listStudentEntity=this.studentRepository.showByName(name);
		
		List<StudentDTO> listStudentDTO=new ArrayList<>();
		
		ModelMapper mapper=new ModelMapper();
		
		for(StudentEntity studentEntity:listStudentEntity)
		{
		StudentDTO tempDTO=mapper.map(studentEntity,StudentDTO.class);
		
		listStudentDTO.add(tempDTO);
			
		}
		return listStudentDTO;
		
	}
	
	
	
	
	
}
