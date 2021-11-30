/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.MotocycleDTO;
import ultities.MyConnection;

/**
 *
 * @author hieu1
 */
public class MotocycleDAO {

    public static ArrayList<MotocycleDTO> getAllMoto() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<MotocycleDTO> list = new ArrayList<>();
        try {
            con = MyConnection.makeConnection();
            String sql = "Select motocycleID, model,year,condition,price,quantity,warranty,brandID from TblBike";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bikeID = rs.getString("motocycleID");
                String model = rs.getString("model");
                String year = rs.getString("year");
                String condition = rs.getString("condition");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");
                MotocycleDTO moto = new MotocycleDTO(bikeID, model, year, condition, price, quantity, warranty, brandID);
                list.add(moto);

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

        return list;
    }

    public static MotocycleDTO getMotoByID(String ID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select * from TblBike  where motocycleID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new MotocycleDTO(rs.getString("motocycleID"), rs.getString("model"), rs.getString("year"), rs.getString("condition"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("warranty"), rs.getString("brandID"));
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

        return null;
    }

    public static int addMoto(MotocycleDTO moto) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int exUpdate = 0;

        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Insert TblBike Values(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, moto.getMotocycleID());
                ps.setString(2, moto.getModel());
                ps.setString(3, moto.getYear());
                ps.setString(4, moto.getCondition());
                ps.setFloat(5, moto.getPrice());
                ps.setInt(6, moto.getQuantity());
                ps.setString(7, moto.getWarranty());
                ps.setString(8, moto.getBrandID());
                exUpdate = ps.executeUpdate();
            }

        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return exUpdate;

    }

    public static int updateMoto(MotocycleDTO moto) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int exUpdate = 0;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Update TblBike Set model = ?, year = ?, condition = ?,price = ?, quantity = ?, warranty=?,brandID=? Where motocycleID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, moto.getModel());
                ps.setString(2, moto.getYear());
                ps.setString(3, moto.getCondition());
                ps.setFloat(4, moto.getPrice());
                ps.setInt(5, moto.getQuantity());
                ps.setString(6, moto.getWarranty());
                ps.setString(7, moto.getBrandID());
                ps.setString(8, moto.getMotocycleID());
                exUpdate = ps.executeUpdate();
            }
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return exUpdate;

    }

    public static int deleteBike(String ID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int exUpdate = 0;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Update TblBike  Set quantity =0  Where motocycleID =?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                exUpdate = ps.executeUpdate();
            }

        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return exUpdate;
    }
}
