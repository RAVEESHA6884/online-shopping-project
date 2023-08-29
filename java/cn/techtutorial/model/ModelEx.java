package cn.techtutorial.model;
import java.sql.Connection;
import java.sql.DriverManager;

import cn.techtutorial.connection.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelEx {
	private String id;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private Connection connection;
   
    private PreparedStatement pstmt;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public ModelEx() throws Exception 
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart", "root", "root");
        System.out.println("Loading the Driver and Establishing the Connection Completed");
    }
    
    public boolean register() throws SQLException
    {
        String s ="insert into users values(?,?,?,?,?)";
      
		pstmt = connection.prepareStatement(s);
		pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, email);
        pstmt.setString(4, password);
        pstmt.setString(5, confirmPassword);
        
        int x = pstmt.executeUpdate();
        if(x>0)
        {
            return true;
        }
        else
        {
          return false;  
        }
    }  
    }  
    