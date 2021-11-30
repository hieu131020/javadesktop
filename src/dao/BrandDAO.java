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
import dto.BrandDTO;
import dto.MotocycleDTO;
import ultities.MyConnection;

/**
 *
 * @author hieu1
 */
public class BrandDAO {

    public static ArrayList<BrandDTO> getAllBrand() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BrandDTO> list = new ArrayList<>();
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select * from TblBrand";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String brandID = rs.getString("brandID");
                    String brandName = rs.getString("brandName");
                    String country = rs.getString("country");
                    String description = rs.getString("description");
                    BrandDTO brand = new BrandDTO(brandID, brandName, country, description);
                    list.add(brand);

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

        return list;

    }

    public static BrandDTO getBrandByID(String brandID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select * from TblBrand Where brandID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, brandID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new BrandDTO(rs.getString("brandID"), rs.getString("brandName"), rs.getString("country"), rs.getString("description"));
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

    public static BrandDTO getBrandByName(String brandName) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select * from TblBrand Where brandName=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, brandName);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new BrandDTO(rs.getString("brandID"), rs.getString("brandName"), rs.getString("country"), rs.getString("description"));
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

    public static String getBrandNameByID(String brandID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select brandName from TblBrand Where brandID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, brandID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("brandName");
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

    public static String getIDByName(String brandName) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select brandID from TblBrand Where brandName=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, brandName);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("brandID");
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

    public static ArrayList<String> ChoiceBrand(ArrayList<BrandDTO> data) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        for (BrandDTO brand : data) {
            list.add(brand.getBrandName());
        }
        return list;
    }

    public static int addBrand(BrandDTO brand) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int exUpdate = 0;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Insert TblBrand Values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, brand.getBrandID());
                ps.setString(2, brand.getBrandName());
                ps.setString(3, brand.getCountry());
                ps.setString(4, brand.getDescription());
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

    public static int updateBrand(BrandDTO brand) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int exUpdate = 0;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = " Update TblBrand Set brandName =?, country=?,description=? Where brandID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, brand.getBrandName());
                ps.setString(2, brand.getCountry());
                ps.setString(3, brand.getDescription());
                ps.setString(4, brand.getBrandID());
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

    public static int deleteBrand(String brandID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int exUpdate = 0;
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Delete from TblBrand Where brandID =?";
                ps = con.prepareStatement(sql);
                ps.setString(1, brandID);
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

    public static ArrayList<MotocycleDTO> checkRelate(String ID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<MotocycleDTO> list = new ArrayList<>();
        try {
            con = MyConnection.makeConnection();
            if (con != null) {
                String sql = "Select * from TblBike  Where TblBike.brandID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                while (rs.next()) {

                    MotocycleDTO moto = new MotocycleDTO(rs.getString("motocycleID"), rs.getString("model"), rs.getString("year"), rs.getString("condition"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("warranty"), rs.getString("brandID"));
                     list.add(moto);
                     return list;

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
}
