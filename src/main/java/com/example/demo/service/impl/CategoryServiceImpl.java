package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> categories() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Boolean existCategory(String name) {
		
		return categoryRepository.existByName(name);
	}

}
