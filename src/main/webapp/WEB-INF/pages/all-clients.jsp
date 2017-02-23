<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/components/jsp/head.jsp">
    <jsp:param name="title" value="All clients" />
</jsp:include>
<body>
   <h1>All clients</h1>
   <display:table name="allClients"
                  sort="external"
                  requestURI="all-clients"
                  partialList="true"
                  size="allClients.fullListSize"
                  pagesize="20">
    <display:column property="name" sortable="true"/>
    <display:column property="surname" sortable="true"/>
    <display:column property="email" sortable="true"/>
    <display:column property="birthDate" sortable="true"/>
    <display:column property="gender" sortable="true"/>
   </display:table>
</body>
</html>
