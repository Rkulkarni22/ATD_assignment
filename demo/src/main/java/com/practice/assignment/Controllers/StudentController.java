package com.practice.assignment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.assignment.DTO.StudentDTO;
import com.practice.assignment.Services.StudentService;


@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	StudentService studentService;
	
	
	public StudentController(@Autowired StudentService studentService ) {
		// TODO Auto-generated constructor stub
		
		this.studentService=studentService;
	}
	

	@PostMapping(value="/students", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StudentDTO> postProduct(@RequestBody StudentDTO student)
	{
		StudentDTO returnedStudentDTO=this.studentService.saveStudent(student);
		return new ResponseEntity<StudentDTO>(returnedStudentDTO,HttpStatus.CREATED);
	}
	
	
	@PutMapping(value="/students")
	public ResponseEntity<StudentDTO> putProduct(@RequestBody StudentDTO student)
	{
		StudentDTO returnedStudentDTO=this.studentService.updateStudent(student);
		return new ResponseEntity<StudentDTO>(returnedStudentDTO,HttpStatus.CREATED);
	}
	

	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDTO>> getStudentList()
	{
		List<StudentDTO> list=this.studentService.getStudents();
		return new ResponseEntity<List<StudentDTO>>(list,HttpStatus.OK);
	}
	
	
		@DeleteMapping(value="/students/{name}")
		public ResponseEntity<List<StudentDTO>> deleteStudent(@PathVariable("name") String studentName)
		{
			List<StudentDTO> listStudentDTO=this.studentService.getstudentByName(studentName);
			
			if(listStudentDTO !=null)
			{
				this.studentService.deleteStudentByName(studentName);
			}
			
			else
			{
	    		System.err.println("Cannot found the name of student");	
	
			}
			return null;
		}
	
	
		

}
