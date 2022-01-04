package com.lova.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lova.user.VO.ResponseTemplateVO;
import com.lova.user.entity.User;
import com.lova.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Controller - User Details Saving");
		return userService.saveUserEntity(user);
	}

	/*
	 * @GetMapping("/{id}") public User getUserDetails(@PathVariable("id") Long
	 * userId) { return userService.getUserEntity(userId); }
	 */

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}

}
