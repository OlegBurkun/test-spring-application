package com.ob.testApp.service;

import java.util.List;

import com.ob.testApp.data.ContentEntity;

/* 	Author Oleg Burkun
 *  Test application
 *  30-08-16
*/

public interface ContentService {
	
	List<ContentEntity> findAll();
	
	ContentEntity getOne(Integer id);
	
	ContentEntity saveOrUpdate(ContentEntity entity);
	
	void delete(Integer id);

}
