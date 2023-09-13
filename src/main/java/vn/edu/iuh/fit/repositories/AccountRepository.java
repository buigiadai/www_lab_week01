package vn.edu.iuh.fit.repositories;


import vn.edu.iuh.fit.entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private Connection connection;

    public AccountRepository() {
    }

    public void insertAccount(Account account) throws SQLException, ClassNotFoundException {
        connection = ConnectDB.getInstance().getConnection();
        String sql = "insert into account "
                + "(account_id, full_name, password, email, phone, status) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setInt(6, account.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Account getAccount(String fullName, String password) {
        String sql = "select * from account where full_name = ? and password = ?";
        Account acount = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, fullName);
            ps.setNString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int status = rs.getInt(6);
                acount = new Account(id, name, pass, email, phone, status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return acount;
    }

    public List<Account> getAllAccount() throws SQLException {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String acc_id = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                list.add(new Account(acc_id, fullName, password, email, phone, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean updateAccount(Account account) throws SQLException, ClassNotFoundException {
        boolean rs = false;
        String sql = "Update account set full_name = ?, password = ?, email = ?, phone = ?, status = ? where account_id = ?";
        connection = ConnectDB.getInstance().getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getFullName());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getPhone());
            ps.setInt(5, account.getStatus());
            ps.setString(6, account.getAccountId());
            rs = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public boolean deleteAccount(String accountId) throws SQLException, ClassNotFoundException {
        String sql = "Delete from account where account_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setNString(1, accountId);

        return ps.executeUpdate() > 0;
    }

    public Account checkLogin(String email, String password) {
        Account account = null;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "select * from account" + " where email = ? and password = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String accountId = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                String pass = rs.getString("password");
                String ema = rs.getString("email");
                String phone = rs.getString("phone");
                int status = rs.getInt("status");
                account = new Account(accountId, fullName, pass, ema, phone, status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}