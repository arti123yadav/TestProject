<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<%
out.print("item added");
String item=request.getParameter("item");
String quantity=request.getParameter("quantity");
String add=request.getParameter("add");
out.print(item);
out.print(quantity);
out.print(add);
	if(add!=null){
		Cookie c1= new Cookie(item,quantity);
		response.addCookie(c1);
		response.sendRedirect("cart.html");
	
}
	else{
		out.print("no item selected");

	}
%>
</body>
</html>