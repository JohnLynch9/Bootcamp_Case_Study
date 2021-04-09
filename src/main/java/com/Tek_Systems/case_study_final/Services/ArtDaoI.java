package com.Tek_Systems.case_study_final.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tek_Systems.case_study_final.Models.Art;

public interface ArtDaoI extends JpaRepository<Art, String> {

}
