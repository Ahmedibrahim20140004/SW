package com.SWEProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SWEProject.Entities.Account;
import com.SWEProject.model.AccountDB;

@Controller

public class AccountController {
	@RequestMapping("/HomePage")
	public String HomePage(){
		
		
		return "HomePage";
	}
	@RequestMapping("/teacherPage")
	public String teacherPage(){
		
		
		return "teacherPage";
	}
	@RequestMapping("/StudentPage")
	public String StudentPage(){
		
		
		return "StudentPage";
	}
	@GetMapping("/LoginPage")
	public String HomePage(Model model){
		model.addAttribute("Account",new Account());
		
		return "LoginPage";
	}
	
	@PostMapping("/LoginPage")
	public String LoginPage(Model model ,@ModelAttribute Account Account ){
		String b="";
		AccountDB x= new AccountDB();
		
		if(Account.getType().equals("student"))
		{
			 b=x.LoginStudentDB(Account.getEmail(), Account.getpassword());
		}
		else if(Account.getType().equals("teacher"))
		{
			System.out.println("123");
			b=x.LoginTeacherDB(Account.getEmail(), Account.getpassword());
		}
		System.out.println(b);
		model.addAttribute("Account", new Account());
		return null;
	}
		
	@GetMapping("/SignUpPage")
	public String SignupPage(Model model){
		model.addAttribute("Account",new Account());
	
		return "SignUpPage";
	}
	
	@PostMapping("/SignUpPage")
	public String Signup (Model model ,@ModelAttribute Account Account ){
		boolean b=false;
		AccountDB x= new AccountDB();
		
		if(Account.getType().equals("student"))
		{
			 b=x.CreateStudentAccountDB(Account);
		}
		else if(Account.getType().equals("teacher"))
		{
			
			b=x.CreateTeacherAccountDB(Account);
		}
		System.out.println(b);
		model.addAttribute("Account", new Account());
		
	
		return null;
	}	
			

	
		
	

}
