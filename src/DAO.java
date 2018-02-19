package src;

import java.sql.*;
import java.util.ArrayList;

class DAO {

    private Connection c = null;

    private void connectToDatabase() throws SQLException {
        c = DriverManager.getConnection("jdbc:sqlite:library.db?foreign_keys=on;");
        c.setAutoCommit(true);
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        if (c != null) {
            try {
                c.close();
                connectToDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (c == null || c.isClosed()) {
            try {
                connectToDatabase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    private ArrayList<ArrayList<String>> sendQuery(String query, ArrayList<String> collumnsToReturn) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            for (ResultSet rs = getConnection().createStatement().executeQuery(query);rs.next();) {
                ArrayList<String> row = new ArrayList<>();
                for (String collumnLabel : collumnsToReturn) {
                    row.add(rs.getString(collumnLabel));
                }
                result.add(row);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return result;
    }

    private String resultToString(ArrayList<ArrayList<String>> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<String> row : result) {
            for (String value : row) {
                stringBuilder.append(value + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    String getAllBooks() {
        String query = "SELECT title FROM Books";
        ArrayList<String> collums = new ArrayList<>();
        collums.add("title");
        ArrayList<ArrayList<String>> books = sendQuery(query, collums);

        return resultToString(books);
    }
}