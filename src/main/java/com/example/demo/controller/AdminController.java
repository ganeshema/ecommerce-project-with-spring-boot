package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Category;
import com.example.demo.service.impl.CategoryServiceImpl;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl; 
	
@GetMapping("/")
public String index() {
	return "admin/index";
}
@GetMapping("/loadAddProduct")
public String addProduct() {
	return "admin/add_product";
}
@GetMapping("/category")
public String addCategory() {
	return "admin/category";
}
@PostMapping("/saveCategory")
public String saveCategory(@ModelAttribute Category category,HttpSession session ) {
	if(categoryServiceImpl.existCategory(category.getName())) {
		session.setAttribute("errorMsg", "The category you have entered is already exists.");
	}else {
		Category savedCategory=categoryServiceImpl.saveCategory(category);
		if(ObjectUtils.isEmpty(savedCategory)) {
			session.setAttribute("errorMsg", "Not saved!! Internal Server Error");
		}else {
			session.setAttribute("succmsg", "Saved Successfully");	
			
		}
	}
	
	return "redirect:/category";
}


}
