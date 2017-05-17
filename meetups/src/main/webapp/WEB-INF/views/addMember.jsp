<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Meetup Form Handling</title>
 </head>
 <body>
  <h2>Add Member Data</h2>
  <form:form method="POST" action="/sdnext/save.html">
      <table>
       <tr>
           <td><form:label path="email">Member Email:</form:label></td>
           <td><form:input path="email" value="${member.email}" /></td>
       </tr>
       <tr>
           <td><form:label path="password">Member Password:</form:label></td>
           <td><form:input path="password" value="${member.password}"/></td>
       </tr>
       <tr>
           <td><form:label path="company">Member Company:</form:label></td>
           <td><form:input path="company" value="${member.company}"/></td>
       </tr>
       <tr>
           <td><form:label path="companyAddress">Member Company Adddress:</form:label></td>
           <td><form:input path="companyAddress" value="${member.companyAddress}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="mobile">Member Mobile No.:</form:label></td>
           <td><form:input path="mobile" value="${member.mobile}"/></td>
       </tr>
       <tr>
           <td><form:label path="capabilities">Member Capabilities:</form:label></td>
           <td><form:input path="capabilities" value="${member.capabilities}"/></td>
       </tr>
       <tr>
           <td><form:label path="experience">Member Experience:</form:label></td>
           <td><form:input path="experience" value="${member.experience}"/></td>
       </tr>
          <tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
   </table> 
  </form:form>
  
  <c:if test="${!empty members}">
  <h2>List Members</h2>
 <table align="left" border="1">
  <tr>
   <th>Member Email</th>
   <th>Member Company</th>
   <th>Member Company Address</th>
   <th>Member Mobile</th>
   <th>Member Capabilities</th>
   <th>Member Experience</th>
           <th>Actions on Row</th>
  </tr>

  <c:forEach items="${members}" var="member">
   <tr>
    <td><c:out value="${member.email}"/></td>
    <td><c:out value="${member.company}"/></td>
    <td><c:out value="${member.companyAddress}"/></td>
    <td><c:out value="${member.mobile}"/></td>
    <td><c:out value="${member.capabilities}"/></td>
    <td><c:out value="${member.experience}"/></td>
    <td align="center"><a href="edit.html?id=${member.email}">Edit</a> | <a href="delete.html?id=${member.email}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
 </body>
</html>