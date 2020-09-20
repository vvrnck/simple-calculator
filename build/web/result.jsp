<%-- 
    Document   : result.jsp
    Created on : 20/09/2020, 00:45:53
    Author     : rwndm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Cookie c[] = request.getCookies(); 
    //c.length gives the cookie count 
    for(int i=0;i<c.length;i++){  
       if (c[i].getName().equals("acessos")) {
           out.print("num de acessos: "+c[i].getValue());
       }
    }
    String op1 = request.getParameter("op1");
    String op2 = request.getParameter("op2");
    String op = request.getParameter("operation");
    float total;
    if (op.equals("+")) {
        total = Integer.parseInt(op1) + Integer.parseInt(op2);
    } else if (op.equals("-")) {
        total = Integer.parseInt(op1) - Integer.parseInt(op2);
    } else if (op.equals("x")) {
        total = Integer.parseInt(op1) * Integer.parseInt(op2);
    } else {
        total = Integer.parseInt(op1) / Integer.parseInt(op2);
    }
    String result = op1 + op + op2 + " = " + total;
    System.out.print(result);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h2><% out.println(result); %> </h2>
        <a href="Calculadora">Voltar</a>
    </body>
</html>
