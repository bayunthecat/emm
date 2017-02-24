<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/components/jsp/head.jsp">
    <jsp:param name="title" value="All clients" />
</jsp:include>
<body>
   <h1>All clients</h1>
   <jsp:useBean class="java.util.Date" id="now"/>
   <display:table name="requestScope.allClientsForm.allClients"
                  size="requestScope.allClientsForm.allClients.fullListSize"
                  sort="external"
                  requestURI="/allClients.do"
                  partialList="true"
                  pagesize="20"
                  id="row">
    <display:column property="id" sortable="true"/>
    <display:column property="name" sortable="true"/>
    <display:column property="surname" sortable="true"/>
    <display:column property="email" sortable="true"/>
    <display:column title="Age" sortable="true" sortProperty="birthDate">
        <c:if test="${row.birthDate != null}">
            <fmt:formatNumber type="number"
                              value="${(now.time - row.birthDate.time) / (1000*60*60*24*365)}"
                              pattern="#.##"/>
        </c:if>
    </display:column>
    <display:column property="gender" sortable="true"/>
    <display:column value="delete" href="/emm/deleteClient.do" paramId="id" paramProperty="id" title="Action"/>
   </display:table>
</body>
</html>
