/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;
import java.sql.*;
/**
 *
 * @author Realme book
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem?useSSL=false&allowPublicKeyRetrieval=true","root","Mintulram#9918");
           s=c.createStatement();
           
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
    }
}
