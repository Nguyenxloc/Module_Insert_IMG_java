/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JTextArea;

/**
 *
 * @author 84374
 */
public class jdbc {

    private String Name;
    private String Mobile;
    private String Gender;
    private String dateOfbirth;
    private String Address;
    private ResultSet rs;

    public jdbc(String Name, String Mobile, String Gender, String dateOfbirth, String Address) {
        this.Name = Name;
        this.Mobile = Mobile;
        this.Gender = Gender;
        this.dateOfbirth = dateOfbirth;
        this.Address = Address;
    }

    public jdbc() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void stored() {
        String connectionString = "jdbc:sqlserver://DESKTOP-OOEDQDP\\SQLEXPRESS:1433;" + "databaseName=custommer;user=sa;password=123456;encrypt=false";
        try ( Connection conn = DriverManager.getConnection(connectionString);  Statement stmt = conn.createStatement();) {
            String sql = "INSERT INTO customer(Name,Mobile,Gender,dateOfbirth,Address) values ('" + this.Name + "','" + this.Mobile + "','" + this.Gender + "','" + this.dateOfbirth + "','" + this.Address + "')";
            stmt.executeUpdate(sql);
            System.out.println("Connection successfully");
        } catch (SQLException ex) {
            System.out.println("Connection is failed !");
            ex.printStackTrace();
        }
    }

    public void selected(JTextArea para) {
        String data ="";
        String connectionString = "jdbc:sqlserver://DESKTOP-OOEDQDP\\SQLEXPRESS:1433;" + "databaseName=custommer;user=sa;password=123456;encrypt=false";
        try ( Connection conn = DriverManager.getConnection(connectionString);  Statement stmt = conn.createStatement();) {
            String sql = "SELECT *FROM customer";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                        data += "==========================" + "\n"
                        + "Index: " + rs.getInt("CustomerID") + "\n"
                        + "Name:" + rs.getString("Name") + "\n"
                        + "Mobile:" + rs.getString("Mobile") + "\n"
                        + "Gender:" + rs.getString("Gender") + "\n"
                        + "dateOfbirth: " + rs.getString("dateOfbirth") + "\n"
                        + "Address: " + rs.getString("Address") + "\n"
                        + "==========================" + "\n";
                para.setText(data);
                para.setEditable(false);
            }
            System.out.println("Query successfully");
        } catch (SQLException ex) {
            System.out.println("Query is failed !");
            ex.printStackTrace();
        }

        // you should release your resources here
    }

    public ResultSet getRs() {
        return this.rs;
    }
}
