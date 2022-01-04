package com.lova.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lova.department.entity.Department;
import com.lova.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartmentEntiry(department);
	}

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long departmentId) {
		log.info("Here is the requesting Department ID :"+departmentId);
		return departmentService.getDepartment(departmentId);
	}

}
