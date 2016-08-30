package com.ob.testApp.repository;

/* 	Author Oleg Burkun
 *  Test application
 *  30-08-16
*/

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ob.testApp.data.ContentEntity;

@Repository
@Table(name = "tableOfContent")
public interface ContentReposiory extends JpaRepository<ContentEntity, Integer> {
	

}
