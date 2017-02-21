<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>New client</title>
</head>
<body>
   <h1>Hello World From Struts2</h1>
   <form action="addClient">
      <label for="name">Enter name</label>
      <input type="text" name="name"/>
      <label for="surname">Enter surname</label>
      <input type="text" name="surname"/>
      <label for="email">Enter surname</label>
      <input type="text" name="email"/>
   </form>
</body>
</html>