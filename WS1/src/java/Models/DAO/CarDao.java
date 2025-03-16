/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.DTO.Car;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class CarDao {

    public List<Car> showCars() throws SQLException {
        ResultSet rs = null;
        PreparedStatement preStm = null;
        Connection conn = null;
        List<Car> carList = new ArrayList<>();
        try {
            String sql = "SELECT [CarID]\n"
                    + "      ,[CarName]\n"
                    + "      ,[Manufacturer]\n"
                    + "      ,[Price]\n"
                    + "      ,[ReleasedYear]\n"
                    + "  FROM [Cars]\n";

            conn = DBUtils.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String carId = rs.getString(1);
                String carName = rs.getString(2);
                String manufacturer = rs.getString(3);
                double price = rs.getDouble(4);
                int releasedYear = rs.getInt(5);
                Car car = new Car(carId, carName, manufacturer, price, releasedYear);
                carList.add(car);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return carList;
    }
public boolean deleteCar(String carId) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        boolean check = false;
        try {
            cnn = DBUtils.getConnection();
            String sql = "DELETE FROM Cars WHERE CarID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, carId);
            check = preStm.executeUpdate() > 0;
        } finally {
            if (preStm != null) preStm.close();
            if (cnn != null) cnn.close();
        }
        return check;
    } 

    public Car getDetails(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement preStm = null;
        Connection conn = null;
        try {
            String sql = "SELECT [CarID]\n"
                    + "      ,[CarName]\n"
                    + "      ,[Manufacturer]\n"
                    + "      ,[Price]\n"
                    + "      ,[ReleasedYear]\n"
                    + "  FROM [dbo].[Cars] \n"
                    + "  WHERE CarID = ?";

            conn = DBUtils.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String carId = rs.getString(1);
                String carName = rs.getString(2);
                String manufacturer = rs.getString(3);
                double price = rs.getDouble(4);
                int releasedYear = rs.getInt(5);
                Car car = new Car(carId, carName, manufacturer, price, releasedYear);
                return car;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return null;
    }

    public boolean addCar(Car car) throws Exception {
        ResultSet rs = null;
        PreparedStatement preStm = null;
        Connection conn = null;
        boolean check = false;
        try {
            String sql = "INSERT INTO [Cars]\n"
                    + "           ([CarName]\n"
                    + "           ,[Manufacturer]\n"
                    + "           ,[Price]\n"
                    + "           ,[ReleasedYear])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";

            conn = DBUtils.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, car.getCarName());
            preStm.setString(2, car.getManufacturer());
            preStm.setDouble(3, car.getPrice());
            preStm.setInt(4, car.getReleasedYear());
            check = preStm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;

    }

    public boolean updateCar(Car car) throws Exception{
        Connection cnn = null;
        PreparedStatement preStm = null;
        boolean check = false;
        try {
            cnn = DBUtils.getConnection();
            String sql = "UPDATE Cars SET CarName=?, Manufacturer=?, Price=?, ReleasedYear=? WHERE CarID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, car.getCarName());
            preStm.setString(2, car.getManufacturer());
            preStm.setDouble(3, car.getPrice());
            preStm.setInt(4, car.getReleasedYear());
            preStm.setString(5, car.getCarId());
            check = preStm.executeUpdate() > 0;
        } finally {
            if (preStm != null) preStm.close();
            if (cnn != null) cnn.close();
        }
        return check;
    }

    
}
