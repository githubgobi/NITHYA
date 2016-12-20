package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String indexPage()
	{
		return "index";
	}
	
//	@RequestMapping(value="/login",method=RequestMethod.GET)
//	public String loginPage()
//	{
//		return "login";
//	}
	
	/*@RequestMapping("/admin")
	public String adminPage()
	{
		return "admin";
	}
	
	@RequestMapping(value="/authfailure",method=RequestMethod.GET)
	public String accessDeniedPage()
	{
		return "accessDenied";
	}*/
	@RequestMapping("/login")
	public ModelAndView login()
	{
		System.out.println("login page is runing");
		ModelAndView model= new ModelAndView("login");
		return model;
	}
	@RequestMapping("/register")
	public ModelAndView register()
	{
		System.out.println("register page is runing");
		ModelAndView model= new ModelAndView("register");
		return model;
	}
	@RequestMapping("/prodect")
	public ModelAndView prodectlist()
	{
		System.out.println("prodect page is runing");
		ModelAndView model= new ModelAndView("prodect");
		return model;
	}
	@RequestMapping("/images")
	public ModelAndView images()
	{
		System.out.println("images page is runing");
		ModelAndView model= new ModelAndView("images");
		return model;
	}

	
}