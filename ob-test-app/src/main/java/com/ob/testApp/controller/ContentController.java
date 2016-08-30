package com.ob.testApp.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ob.testApp.data.MyRestResponse;
import com.ob.testApp.data.ContentEntity;
import com.ob.testApp.data.ContentForm;
import com.ob.testApp.exception.MyException;
import com.ob.testApp.service.ContentService;

/* 	Author Oleg Burkun
 *  Test application
 *  30-08-16
*/ 

@Controller
@RequestMapping("/")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping(method = RequestMethod.GET)
	public String getTable(Map<String, Object> model) {
		
		List<ContentEntity> table = contentService.findAll();
		
		model.put("table", table);
		
		return "table";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getNew(Map<String, Object> model) {
		
		ContentEntity entity = new ContentEntity();
		ContentForm content = new ContentForm();
		content.setContent(entity);
		model.put("content", content);
		
		return "content_form";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getById(@RequestParam(value = "id", required = true) Integer id,
												Map<String, Object> model) {
		
		ContentEntity entity = contentService.getOne(id);
		ContentForm content = new ContentForm();
		content.setContent(entity);
		model.put("content", content);
		
		return "content_form";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("content") ContentForm content, BindingResult result) {
		
		ContentEntity entity = content.getContent();
		contentService.saveOrUpdate(entity);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer id) {
		contentService.delete(id);
		return "table";
	}

	@RequestMapping("/fail")
	public String fail() {
		throw new MyException("Oh dear!");
	}
	
	@RequestMapping("/fail2")
	public String fail2() {
		throw new IllegalStateException();
	}

	// REST and Ajax exception handler for example
	// try it on "/fail" link
	@ExceptionHandler(MyException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MyRestResponse handleMyRuntimeException(MyException exception) {
		return new MyRestResponse("Some data I want to send back to the client.");
	}

}
