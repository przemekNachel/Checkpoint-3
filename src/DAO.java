package src;

import java.sql.*;
import java.util.ArrayList;

class DAO {

    private Connection c = null;

    private void connectToDatabase() throws SQLException {
        c = DriverManager.getConnection("jdbc:sqlite:library.db");
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

    private void sendQuery(String query) {
        try {
            getConnection().createStatement().executeUpdate(query);
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
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

    void addBook(ArrayList<String> data) {
        String query = "INSERT INTO Books VALUES (";
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i > 3) {
                query += data.get(i);
            } else {
                query += "\"" + data.get(i) + "\"";
            }
            if (i != 6) {
                query += ", ";
            }
        }
        query += ");";
        sendQuery(query);
    }
}