package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Category;

import lombok.RequiredArgsConstructor;


public interface CategoryService {
	public Category saveCategory(Category category);
	public List<Category> categories();
	public Boolean existCategory(String name);

}
