<%@ page import="controller.DatabaseController" %>
<%
    
    DatabaseController con = new DatabaseController();
    String s = con.query();
    
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Place</title>

</head>
<body>

<p>LIZ!</p>
<%=s%>

</body>
</html>