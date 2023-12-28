package com.springrest.controller;

import java.util.List;

import org.apache.tomcat.util.buf.CharChunk.CharOutputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Course;
import com.springrest.service.CourseService;
import com.springrest.service.CourseServiceImpl;

@RestController
public class controller {
	
	@Autowired
    private CourseService courseservice;
    

//	
//	@GetMapping("/Courses")
//	public String output(){
//		
//		return "hi this is my first webpage";
//	}
	
	
	@GetMapping("/Courses")
	public List<Course> getCourses(){
		
		return this.courseservice.getCourses();
	}
	
	@GetMapping("/Courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/Courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseservice.addCourse(course);
		
	}
	
	@PutMapping("/Courses")
	public Course updateCOurse(@RequestBody Course course) {
		
		return this.courseservice.updateCourse(course);
	}
	
	@DeleteMapping("/Courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
