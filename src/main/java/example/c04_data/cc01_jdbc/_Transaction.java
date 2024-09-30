package example.c04_data.cc01_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _Transaction {
    static public void exec(Connection connection) throws Exception {
        connection.setAutoCommit(false);

        String queryUpdate = "UPDATE USER_WALLETS SET balance = balance + ? where name = ? ;";
        String sender = "Joun", recipient = "Joph";
        int amount = 100;

        // #1: reduce sender balance
        // assume that sender is legit
        PreparedStatement updateStatement = connection.prepareStatement(queryUpdate);
        updateStatement.setInt(1, -amount);
        updateStatement.setString(2, sender);
        updateStatement.executeUpdate();

        // #2: increase recipient balance
        // assume recipient doesn't exist
        String queryGet = "SELECT * FROM USER_WALLETS WHERE name = ?";
        PreparedStatement getStatement = connection.prepareStatement(queryGet);
        getStatement.setString(1, recipient);

        ResultSet resultSet = getStatement.executeQuery();
        if (!resultSet.next()) throw new Exception("Recipient not found !!!");

        // update balance
        updateStatement.setInt(1, amount);
        updateStatement.setString(2, recipient);
        updateStatement.executeUpdate();

        connection.commit();
        connection.setAutoCommit(true);
    }
}
