package com.ob.testApp.data;

import java.util.Date;

/* 	Author Oleg Burkun
 *  Test application
 *  30-08-16
*/

public class ContentForm {
	
	private ContentEntity content;

	public ContentEntity getContent() {
		return content;
	}

	public void setContent(ContentEntity content) {
		this.content = content;
	}
	
	public Integer getId() {
		return content.getId();
	}

	public void setId(Integer id) {
		this.content.setId(id);
	}

	public String getTextField() {
		return content.getTextField();
	}

	public void setTextField(String textField) {
		this.content.setTextField(textField);
	}

	public Long getNumericField() {
		return content.getNumericField();
	}

	public void setNumericField(Long numericField) {
		this.content.setNumericField(numericField);
	}

	public boolean isBooleanField() {
		return content.isBooleanField();
	}

	public void setBooleanField(boolean booleanField) {
		this.content.setBooleanField(booleanField);
	}

	public Date getDateField() {
		return content.getDateField();
	}

	public void setDateField(Date dateField) {
		this.content.setDateField(dateField);
	}
}
