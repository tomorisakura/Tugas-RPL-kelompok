/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mu_pet_coba;

import java.sql.Connection;

/**
 *
 * @author resky
 */
public class Mu_pet_coba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = new koneksi_db().koneksi();
    }
    
}
