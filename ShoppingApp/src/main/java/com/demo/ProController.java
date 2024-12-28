package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	UserRepo userRepo;
	
	
	@RequestMapping(value="/login_form",method=RequestMethod.GET)
	@GetMapping("/login_form  ")
	public String display_login_form() {
		return "LoginPage";
		
	}
	
	
	@PostMapping("/user_login")
	public String processUser(User myUser) {
		
		
		System.out.println("username------->"+myUser.getUsername());
		System.out.println("password------->"+myUser.getPassword());
		
		List<User>allUsers=userRepo.findAll();
		
		System.out.println(allUsers);
		
		
		
		boolean flag=false;
		
		
		
		for(User u1:allUsers) {
			if(u1.getUsername().equals(myUser.getUsername()) &&(u1.getPassword().equals(myUser.getPassword()))) {
				
				flag=true;
				break;
			}
		}
		
		
	//hard code
		
		//if((myUser.getUsername().equals("Admin"))&&(myUser.getPassword().equals("root@123")))
			
			if (flag) {
		return "success";
		}else {	
			return "failure";
		}
	
	}
	
	@GetMapping("/add_new_product")
	public String display_product() {
		return "ProductFormPage";
		
	}
	
	
	
	@PostMapping("/add_Product")
	public String add_new_product(Product p1) {
		
		System.out.println(p1);

		productRepo.save(p1);
		
		return "Product_added_Successfully";
		
	}
	
	@GetMapping("/Products_List")
	public String list_of_products(Model model) {
		
		List<Product>prod_list=productRepo.findAll();
		
		model.addAllAttributes(prod_list);
		System.out.println(prod_list);
		
		return "ProductFormPage";
		
	}
	



}

