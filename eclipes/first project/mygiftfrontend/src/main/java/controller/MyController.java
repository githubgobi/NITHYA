package controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.mygiftbackend.dao.ProductDAO;
import com.niit.mygiftbackend.model.Product;

@Controller
public class MyController {
	@Autowired
	ProductDAO productDAO;
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
	
	
	Product product;
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String Admin(Model model) {
	
		List<Product> products = productDAO.listProducts();
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
		String listproducts = new Gson().toJson(products);
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh"+ productDAO.listProducts().size());
		for(Product p: products)
		{
			System.out.println("pppppppppppppppppppppppppp"+p.getId());
			
		}
		model.addAttribute("listproducts",listproducts);
		return "product";

	}

	
}