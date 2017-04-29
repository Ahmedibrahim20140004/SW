package com.SWEProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SWEProject.Entities.Course;
import com.SWEProject.model.CourseDB;
@Controller
public class CourseController {
	@GetMapping("/CoursePage")
	public String CoursePage(Model model){
		model.addAttribute("Course",new Course());
		//ModelAndView mv=new ModelAndView();
		//mv.setViewName("new");
		return "CoursePage";
	}
	
	@PostMapping("/CoursePage")
	public String CreateGame(Model model ,@ModelAttribute Course Course ){
		
		
		CourseDB x= new CourseDB();
		boolean str=x.CreateCourseDB(Course);
		System.out.println(str);
		model.addAttribute("Course",new Course());
		return null;
	}

	@GetMapping("/ShowCourses")
	public String ShowCoursesPage(Model model){
		model.addAttribute("Course",new Course());
		//ModelAndView mv=new ModelAndView();
		//mv.setViewName("new");
		return "ShowCourses";
	}
	
	@PostMapping("/ShowCourses")
	public String ShowCourses(Model model ,@ModelAttribute Course Course ){
		
		
		CourseDB x= new CourseDB();
		List  <Course> arr=new ArrayList<Course> ();
		
		arr=x.ShowCoursesDB();
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i).getCourseID());
			System.out.println(arr.get(i).getCourseName());
			System.out.println(arr.get(i).getCourseDuration());
			System.out.println(arr.get(i).getCourseDescription());
			
		}
		model.addAttribute("courses",arr);
		return null;
	}
}
