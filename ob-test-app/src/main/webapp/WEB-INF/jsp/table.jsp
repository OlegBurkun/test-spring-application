<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="/css/testApp.css" rel="stylesheet" type="text/css">

<h3>Table Of Content</h3>

<body>
			
	<form id="tableofcontent">
		<display:table defaultsort="1" id="row" name="table" pagesize="100" class="list">
			<display:column style="width: 5%" title="" media="html" >
				<input type="checkbox" name="row_id" value="<c:out value="${row.id}" />" id="row_id" />    
			</display:column>
			<display:column property="id" title="Id" href="/update" paramId="id" paramProperty="id" />
			<display:column property="textField" title="Text Field" />	
			<display:column property="numericField" title="Numeric Field" />
			<display:column property="booleanField" title="Boolean Field">
				<input type="checkbox" name="boolean field" value="${row.id}" /> 
			</display:column>	
			<display:column property="dateField" title="Date Field" />
		</display:table>
		
		<a href="/create">
			<input type="button" value="Add" id="add" />
		</a>
		<input type="button" value="Refresh" id="refresh" onclick="refresh();" />
		<input type="button" value="Delete" id="delete" onclick="delete_checked();" />
	</form>
	
	
</body>

	<script>
	function refresh() {
	    location.reload();
	}
	
	function get_selected(checkbox_name_id){
		var ids = '';
		var selectedItems = new Array();
		$('input[type="checkbox"]:checked').each(function() {
			selectedItems.push($(this).val());
		});
		ids = selectedItems.join(',');
		return ids;
	}
	
	function delete_checked(){
	        var ids = get_selected("row_id");
	        if(ids == '' || ids.length > 1) {
	            alert("Please check 1 checkbox");
	            return false;
	        }
	        if(!confirm("Are you sure?")) return false;
	        $.get("/delete",{
	            "id":ids[0]
	        },function(r){
	            location.href = location.href;
	        });
	        return false;
	}
	</script>

</html>

