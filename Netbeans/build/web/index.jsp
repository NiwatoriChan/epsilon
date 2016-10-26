<%-- 
    Document   : index
    Created on : 2016-10-03, 10:49:00
    Author     : usager
--%>


<% 
    if (session.getAttribute("connecte")==null)  //non connecté
    {
%>
      <jsp:forward page="login.jsp" />
<%
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%       
        if (session.getAttribute("connecte")!=null)
        {
            out.println("<p class=\"resultat\">"+session.getAttribute("connecte")+", vous êtes connectés. "+
                        "<a href=\"logout.do?action=logout\">déconnexion</a></p>");
        }
        %>
    </head>
    <body>
<%    
        if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
%>
    </body>
</html>
