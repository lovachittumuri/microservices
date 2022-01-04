package com.lova.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lova.user.VO.Department;
import com.lova.user.VO.ResponseTemplateVO;
import com.lova.user.entity.User;
import com.lova.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public User saveUserEntity(User user) {
		log.info("User is Details Saving.");
		return userRepository.save(user);
	}

	public User getUserEntity(Long userId) {
		return userRepository.findByUserId(userId);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Calling - getUserWithDepartment  - in Service ");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(),
				Department.class);
		vo.setDepartment(department);
		vo.setUser(user);
		return vo;
	}
	
}
