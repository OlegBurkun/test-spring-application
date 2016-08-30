package com.ob.testApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.testApp.data.ContentEntity;
import com.ob.testApp.repository.ContentReposiory;

/* 	Author Oleg Burkun
 *  Test application
 *  30-08-16
*/

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentReposiory contentRepository;

	@Override
	public List<ContentEntity> findAll() {
		return contentRepository.findAll();
	}

	@Override
	public ContentEntity getOne(Integer id) {
		return contentRepository.findOne(id);
	}

	@Override
	public ContentEntity saveOrUpdate(ContentEntity entity) {
		entity.setDateField(new Date());
		return contentRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		contentRepository.delete(id);
	}

}
