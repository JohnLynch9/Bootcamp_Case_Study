package com.Tek_Systems.case_study_final.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tek_Systems.case_study_final.Models.Message;

@Repository
public interface MessageDaoI extends JpaRepository<Message, Integer> {

}
