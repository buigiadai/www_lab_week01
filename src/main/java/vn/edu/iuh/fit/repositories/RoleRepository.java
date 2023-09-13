package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRepository {
  private  Connection connection;

    public RoleRepository() {
    }

    public Role getRole(String role_id) {
        Role role = null;
        String sql = "Select * from role where role_id = ?; ";
        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("role_id");
                String role_name = rs.getString("role_name");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                role = new Role(id, role_name, description, status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

}