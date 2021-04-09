package com.Tek_Systems.case_study_final.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tek_Systems.case_study_final.Models.User;

@Repository
public interface UserDaoI extends JpaRepository<User, String> {

	User findByEmail(String email);
	
}