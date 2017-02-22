<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/components/jsp/head.jsp">
    <jsp:param name="title" value="Create client" />
</jsp:include>
<body>
   <h1>Create user</h1>
   <s:form action="createClient">
      <s:textfield name="client.name" label="Name"/>
      <s:textfield name="client.surname" label="Surname"/>
      <s:textfield name="client.email" label="Email"/>
      <s:textfield id="datepicker"
                   name="client.birthDate"
                   label="Birth date"/>
      <s:select name="client.gender"
                label="Gender"
                list="#{'MALE':'Male','FEMALE':'Female'}"/>
      <s:submit/>
   </s:form>
</body>
</html>