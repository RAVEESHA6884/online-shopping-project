
package cn.techtutorial.servlet;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.techtutorial.model.ModelEx;



@WebServlet("/Signup") 
public class Signup extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException
    {
    	String id=request.getParameter("id");
       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       String confirmPassword = request.getParameter("confirmPassword");
       
       try
       {
          ModelEx m = new ModelEx();
          m.setId(id);
          m.setName(name);
          m.setEmail(email);
          m.setPassword(password);
          m.setConfirmPassword(confirmPassword);
         
          System.out.println(name);
          
          boolean b = m.register();
          if(b==true)
          {
              response.sendRedirect("successReg.html");
              
          }
          else
          {
              response.sendRedirect("failure.html");
          }
       }
       catch(Exception e){
       e.printStackTrace();
       }
       
    
    }
    
        

        
}
