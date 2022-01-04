package com.lova.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lova.department.entity.Department;
import com.lova.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartmentEntiry(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartment(Long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
