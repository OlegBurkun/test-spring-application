package com.ob.testApp.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* 	Author Oleg Burkun
 *  Test application
 *  30-08-16
*/

@Entity
@Table(name = "table_of_content")
public class ContentEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "textField")
	private String textField;
	
	@Column(name = "numericField")
	private Long numericField;
	
	@Column(name = "booleanField")
	private boolean booleanField;
	
	@Column(name = "dateField")
	private Date dateField;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public Long getNumericField() {
		return numericField;
	}

	public void setNumericField(Long numericField) {
		this.numericField = numericField;
	}

	public boolean isBooleanField() {
		return booleanField;
	}

	public void setBooleanField(boolean booleanField) {
		this.booleanField = booleanField;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

}
