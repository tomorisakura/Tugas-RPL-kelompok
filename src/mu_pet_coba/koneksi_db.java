/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mu_pet_coba;
import java.sql.*;
/**
 *
 * @author resky
 */
public class koneksi_db {
    public static Connection conn;
    public Connection koneksi(){
        try {
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);
            String url = "jdbc:mysql://localhost/petsop_hehe";
            String usr = "root";
            String pwd = "";
            
            conn = DriverManager.getConnection(url,usr,pwd);
            System.out.println("Berhasil");
        } catch (Exception e) {
            System.err.println("noooo !" +e.getMessage());
        }
        return conn;
    }
}
