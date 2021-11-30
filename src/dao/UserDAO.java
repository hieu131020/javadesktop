/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ultities.MyConnection;

/**
 *
 * @author hieu1
 */
public class UserDAO {

    public static boolean checkLogin(String userID, String password) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select userID , password from TblUser";
//                where userID like 
                ps = con.prepareStatement(sql);
//                ps.setString(1, userID);
                rs = ps.executeQuery();
                if (rs.next()) {
//                    return true;
                    return rs.getString(1).equals(userID) && rs.getString(2).equals(password);
                }

            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return false;
    }
}
