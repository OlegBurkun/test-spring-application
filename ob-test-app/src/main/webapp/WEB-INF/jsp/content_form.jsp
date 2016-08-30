<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html lang="en">
<link href="/css/testApp.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<h3>Create or Edit Content</h3>

<body>
			
	<form:form action="update" method="POST" modelAttribute="content">
		<form:hidden path="content.id"/>
		<table>
			<tbody>
				<tr>
					<td>Text Field</td>
					<td><form:input path="content.textField"/></td>
				</tr>
				<tr>
					<td>Numeric Field</td>
					<td><form:input path="content.numericField"/></td>
				</tr>
				<tr>
					<td>Boolean Field</td>
					<td><form:checkbox path="content.booleanField"/></td>
				</tr>
				<tr>
					<td>Date Field</td>
					<td><form:input path="content.dateField" readonly="true"/></td>
				</tr>
			</tbody>
		</table>
		
		<input type="submit" value="Save" id="save" />
		<input type="button" value="Cancel" id="cancel" onclick="history.back()" />
	</form:form>
	
	
</body>
</html>
