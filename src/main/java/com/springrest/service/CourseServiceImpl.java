package com.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
//	private List<Course> list;
//	
//	CourseServiceImpl(){
//		
//		list = new ArrayList<>();
//		list.add(new Course(1,"Java Course","Java Course contaning core concepts"));
//		list.add(new Course(2, "Spring boot", "Spring boot containing all atonation"));
//		
//	}
//
//	@Override
//	public List<Course> getCourses() {
//		// TODO Auto-generated method stub
//		return list;
//	}
//
//	@Override
//	public Course getCourse(long courseId) {
//		
//		Course c =null;
//		
//		for(Course course:list) {
//			if(course.getId() == courseId) {
//				c=course;
//				break;
//			}
//		}
//		
//		return c;
//		
//	}
//
//	@Override
//	public Course addCourse(Course course) {
//		
//		list.add(course);
//		
//		return course;
//	}
//
//	@Override
//	public Course updateCourse(Course course) {
//		
//		list.forEach(e ->{
//			if(e.getId() == course.getId()) {
//				e.setCourseName(course.getCourseName());
//				e.setDescription(course.getDescription());
//			}
//		});
//		
//		return course;
//	}
//
//	@Override
//	public void deleteCourse(long parseLong) {
//		// TODO Auto-generated method stub
//		
//		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//		
//	}
	
	@Autowired
    private CourseDao courseDao;
	
	CourseServiceImpl(){
				
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();

	}

	@Override
	public Course getCourse(long courseId) {
		
	return courseDao.getOne(courseId);
		
	}

	@Override
	public Course addCourse(Course course) {
		
		return courseDao.save(course);
		
	}

	@Override
	public Course updateCourse(Course course) {
		
	
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(long parseLong) {
		
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
	

}
