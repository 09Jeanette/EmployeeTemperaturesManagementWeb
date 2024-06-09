<%-- 
    Document   : view2Outcome
    Created on : 07 Jun 2024, 9:48:23 PM
    Author     : Jeanette
--%>

<%@page import="za.ac.tut.entities.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view employees with more high temperatures Page</title>
    </head>
    <body>
        <h1>More than one high temperature!</h1>
        
        <%
        List<Employee> emp = (List<Employee>)request.getAttribute("emp");
        
        for(int i = 0 ; i < emp.size(); i++)
        {
           Employee e = emp.get(i);
        %>
        <table border="1">
            <tr>
                <td>Name:</td>
                <td><%= e.getName() %></td>
            </tr>
            
            <tr>
                <td>List of temperatures:</td>
                
                <td>
                    <ul>
                        <%
                          for(Double temp : e.getTemperatures())
                          {
                             %>
                             
                             <li><%=temp%></li>
                             <%
                          }
                        %>
                    </ul>
                </td>
                
                
            </tr>
            
                 <tr>
                <td>List of temperature statuses:</td>
                
                <td>
                    <ul>
                        <%
                          for(String status : e.getStatuses())
                          {
                             %>
                             
                             <li><%=status%></li>
                             <%
                          }
                        %>
                    </ul>
                </td>
                 
            </tr>
            
              <tr>
                <td>Date</td>
                <td><%= e.getHire_date() %></td>
            </tr>
            
              <tr>
                <td>Employee id</td>
                <td><%= e.getId() %></td>
            </tr>
                 <%
        }
        %>
        </table>
        <p>Please click <a href="menu.html">here</a> to go back to the menu.</p>
       
    </body>
</html>
