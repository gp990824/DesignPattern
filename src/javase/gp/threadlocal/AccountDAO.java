package javase.gp.threadlocal;

import java.sql.*;

/**
 * @author Gp
 * @create 2020/4/14 15:36
 */
public class AccountDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void setNull() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean queryBalance(String name, int money) {
        try {
            connection = C3P0ConnectionPool.getConnection();
            String sql = "select balance from account where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getInt(1) >= money) {
                    return true;
                }
            }
            System.out.println(name + "余额不足!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addMoney(String name, int money) {
        try {
            connection = C3P0ConnectionPool.getConnection();
            String sql = "update account set balance = balance + ? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, money);
            preparedStatement.setString(2, name);
            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean downMoney(String name, int money) {
        try {
            connection = C3P0ConnectionPool.getConnection();
            String sql = "update account set balance = balance - ? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, money);
            preparedStatement.setString(2, name);
            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
