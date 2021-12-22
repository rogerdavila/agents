<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Create agent</title>
</head>
<body>
	<div align="center">
		<h1>Edit Agent</h1>
		<form:form action="updateagent" method="post" modelAttribute="agent">
			<table>
				<tr>
					<td>Agent Id:</td>
					<td><form:input path="agentId" readOnly="true"/></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>
						<form:select path="gender">
							<form:option value="MALE" label="Male"/>
							<form:option value="FEMALE" label="Female"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Marital Status:</td>
					<td>
						<form:select path="maritalStatus">
							<form:option value="0" label="Single"/>
							<form:option value="1" label="Married"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Premium</td>
					<td><form:input type="number" path="premium" step=".01"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>