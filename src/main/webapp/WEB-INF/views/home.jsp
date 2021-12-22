<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Agents</h1>
	        <h3><a href="addagent">New Agent</a></h3>
	        
	        <table border="1">
				<tr>
					<th>Agent ID</th>
					<th>Name</th>
					<th>City</th>
					<th>Gender</th>
					<th>Marital Status</th>
					<th>Premium</th>
				</tr>
				<c:forEach var="agent" items="${agents}">
					<tr>
						<td>${agent.agentId}</td>
						<td>${agent.name}</td>
						<td>${agent.city}</td>
						<td>${agent.gender}</td>
						<td><c:out value="${agent.maritalStatus == 0 ? 'SINGLE' : 'MARRIED'}"/></td>
						<td>${agent.premium}</td>
					</tr>
				</c:forEach>
	        </table>
        </div>
    </body>
</html>
