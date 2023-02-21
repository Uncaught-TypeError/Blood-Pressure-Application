/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BloodPressureCalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Connector {
    public Connection newConnection() {
        Connection con = null;
        Statement st;
        ResultSet rs;
        String url = "jdbc:ucanaccess://E:\\Blood Pressure Cal\\BloodCal.accdb";
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            String sql = "Select * from UserInfo";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String Username, Password, Email, PhoneNumber, Address;
                Username = rs.getString("Username");
                Password = rs.getString("Password");
                Email = rs.getString("Email");
                PhoneNumber = rs.getString("Phone Number");
                Address = rs.getString("Address");

            }
        } catch (Exception sqlEx) {
            System.out.println(sqlEx);
        }
        return con;
    }
}
