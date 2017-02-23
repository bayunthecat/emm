<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="/WEB-INF/components/jsp/head.jsp">
    <jsp:param name="title" value="Create client" />
</jsp:include>
<body>
   <h1>Create user</h1>
   <html:form action="addClient">
      <html:text property="name"/></br>
      <html:text property="surname"/></br>
      <html:text property="email"/></br>
      <html:text property="birthDate"/></br>
      <html:select property="gender">
        <html:option value="MALE">Male</html:option>
        <html:option value="FEMALE">Female</html:option>
      </html:select></br>
      <html:submit/>
   </html:form>
</body>
</html>