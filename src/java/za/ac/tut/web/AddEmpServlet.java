/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.EmployeeFacadeLocal;
import za.ac.tut.entities.Employee;

/**
 *
 * @author Jeanette
 */
public class AddEmpServlet extends HttpServlet {

    @EJB
    private EmployeeFacadeLocal efl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Date date2 = Date.valueOf(date);
        
        
        String[] temp = request.getParameterValues("temp");
        
        List<Double> temperatres = new ArrayList<>();
        
        for(String temperature:temp)
        {
            temperatres.add(Double.parseDouble(temperature));
        }
        
        List<String> statuses = new ArrayList<>();
        
        for(String temperature:temp)
        {
            double tempValue = Double.parseDouble(temperature);
            
            if(tempValue < 38)
            {
            statuses.add("Acceptable");
            }
            else{
                 statuses.add("High");
            }
        }
        
        Employee emp = createEmployee(statuses,temperatres,date2,name);
        
        efl.create(emp);
        RequestDispatcher disp = request.getRequestDispatcher("addOutcome.jsp");
        disp.forward(request, response);
    }

    private Employee createEmployee(List<String> statuses, List<Double> temperatres, Date date2, String name) {
        Employee emp = new Employee();
        
        Timestamp time = new Timestamp(System.currentTimeMillis());
        emp.setCreation_date(time);
        emp.setHire_date(date2);
        emp.setName(name);
        emp.setStatuses(statuses);
        emp.setTemperatures(temperatres);
        
        return emp;
    }
}
