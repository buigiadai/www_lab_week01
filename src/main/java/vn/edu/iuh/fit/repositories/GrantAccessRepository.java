package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.GrantAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantAccessRepository {
    private  Connection connection;

    public GrantAccessRepository() {
    }

    public GrantAccess getGrantAccess(String account_id) {
        GrantAccess grantAccess = null;
        String sql = "Select * from grant_access  where account_id = ?; ";
        try {
            connection = ConnectDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String roleId = rs.getString("role_id");
                String accountId = rs.getString("account_id");
                int isGrant = rs.getInt("is_grant");
                String note = rs.getString("note");
//              GrantAccess(String roleId, String accountId, int isGrant, String note)
                grantAccess = new GrantAccess(roleId, accountId, isGrant, note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return grantAccess;
    }

}