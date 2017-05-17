<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Members</title>
</head>
<body>
<h1>List Members</h1>
<h3><a href="add.html">Add More Member</a></h3>

<c:if test="${!empty members}">
 <table align="left" border="1">
  <tr>
   <th>Member Email</th>
   <th>Member Company</th>
   <th>Member Company Address</th>
   <th>Member Mobile</th>
   <th>Member Capabilities</th>
   <th>Member Experience</th>
  </tr>

  <c:forEach items="${members}" var="member">
   <tr>
    <td><c:out value="${member.email}"/></td>
    <td><c:out value="${member.company}"/></td>
    <td><c:out value="${member.companyAddress}"/></td>
    <td><c:out value="${member.mobile}"/></td>
    <td><c:out value="${member.capabilities}"/></td>
    <td><c:out value="${member.experience}"/></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
</body>
</html>