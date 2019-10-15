<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="hiveTableDesc" class="com.manage.model.HiveTableDesc"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta charset="UTF-8">
    <title>listCustomer</title>

	  <style type="text/css">
		.even{background-color: #FFFF00}
    	.odd{background-color: #FFCCFF}
    	tr:hover{background-color: #FF99FF}
	  </style>

  </head>
  
  <body style="text-align: center;">
  <table frame="border" width="85%" align="center" valign="center"  border="1" >
    <tr>
    	<td>id</td>
    	<td>dbTable</td>
    	<td>CreateDate</td>
    	<td>ModifyDate</td>
    	<td>CreateBy</td>
    	<td>ModifyBy</td>
    	<td>Action</td>
    </tr>
    <c:forEach var="c" items="${requestScope.resultMap.data}" varStatus="status">
    <tr class="${status.count%2==0?'even':'odd' }">
    	<td>${c.id}</td>
    	<td>${c.dbTable}</td>
    	<td>${c.createDateStr}</td>
    	<td>${c.modifyDateStr}</td>
    	<td>${c.createBy}</td>
    	<td>${c.modifyBy}</td>
    	<td>
    	<a href="../html/ShowDesc.html?dbTable=${c.dbTable}&userName=${c.createBy}">Search</a>
		<a href="../html/EditDesc.html?dbTable=${c.dbTable}&userName=${c.createBy}">Modify</a>
		</td>
    </tr>
    </c:forEach>
    </table>
  <a href="../html/CreateDesc.html" name="Create" id="create_newDesc">Create</a>
  </body>
</html>
