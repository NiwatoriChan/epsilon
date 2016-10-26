<%-- 
    Document   : login
    Created on : 2016-10-03, 11:49:17
    Author     : Étienne Demers
--%>
<%
    if (session.getAttribute("connecte")!=null)  //déjà connecté
    {
%>
        <jsp:forward page="index.jsp" />
<%
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        //garde L'username en mémoire et l'affiche dans le form
        String  us1 = request.getParameter("username");
        if (us1==null) us1="";
        else us1 = us1.trim();
        %>
        <form action="login.do" method="post">
            Username : <input type="text" name="username" value="<%=us1%>" /><br />
            Password : <input type="password" name="password" />
            <input type="hidden" name="action" value="login" /><br />
            <input type="submit" value=" Connexion " />
        </form>    
    </body>
</html>
