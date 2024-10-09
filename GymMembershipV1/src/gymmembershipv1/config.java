/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmembershipv1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class config {
    
    //Connection Method to SQLITE
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:gym_dbV1.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    
    //RECORD METHOD
    public void addRecord(String sql, Object... values) {
        try (Connection conn = this.connectDB(); // Use the connectDB method
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Loop through the values and set them in the prepared statement dynamically
            for (int i = 0; i < values.length; i++) {
                if (values[i] instanceof Integer) {
                    pstmt.setInt(i + 1, (Integer) values[i]); // If the value is Integer
                } else if (values[i] instanceof Double) {
                    pstmt.setDouble(i + 1, (Double) values[i]); // If the value is Double
                } else if (values[i] instanceof Float) {
                    pstmt.setFloat(i + 1, (Float) values[i]); // If the value is Float
                } else if (values[i] instanceof Long) {
                    pstmt.setLong(i + 1, (Long) values[i]); // If the value is Long
                } else if (values[i] instanceof Boolean) {
                    pstmt.setBoolean(i + 1, (Boolean) values[i]); // If the value is Boolean
                } else if (values[i] instanceof java.util.Date) {
                    pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime())); // If the value is Date
                } else if (values[i] instanceof java.sql.Date) {
                    pstmt.setDate(i + 1, (java.sql.Date) values[i]); // If it's already a SQL Date
                } else if (values[i] instanceof java.sql.Timestamp) {
                    pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]); // If the value is Timestamp
                } else {
                    pstmt.setString(i + 1, values[i].toString()); // Default to String for other types
                }
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }
    
    //VIEW METHOD
    public void viewRecords(String sqlQuery, String[] columnHeaders, String[] columnNames) {
        // Check that columnHeaders and columnNames arrays are the same length
        if (columnHeaders.length != columnNames.length) {
            System.out.println("Error: Mismatch between column headers and column names.");
            return;
        }

        try (Connection conn = this.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
             ResultSet rs = pstmt.executeQuery()) {

            // Print the headers dynamically
            StringBuilder headerLine = new StringBuilder();
            headerLine.append("--------------------------------------------------------------------------------\n| ");
            for (String header : columnHeaders) {
                headerLine.append(String.format("%-20s | ", header)); // Adjust formatting as needed
            }
            headerLine.append("\n--------------------------------------------------------------------------------");

            System.out.println(headerLine.toString());

            // Print the rows dynamically based on the provided column names
            while (rs.next()) {
                StringBuilder row = new StringBuilder("| ");
                for (String colName : columnNames) {
                    String value = rs.getString(colName);
                    row.append(String.format("%-20s | ", value != null ? value : "")); // Adjust formatting
                }
                System.out.println(row.toString());
            }
            System.out.println("--------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Error retrieving records: " + e.getMessage());
        }
    }
    
    public void deleteRecord(String tableName, String condition, Object... values) {
    String sql = "DELETE FROM " + tableName + " WHERE " + condition;

    try (Connection conn = this.connectDB(); // Use the connectDB method
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Loop through the values and set them in the prepared statement dynamically
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) values[i]); // If the value is Integer
            } else if (values[i] instanceof Double) {
                pstmt.setDouble(i + 1, (Double) values[i]); // If the value is Double
            } else if (values[i] instanceof Float) {
                pstmt.setFloat(i + 1, (Float) values[i]); // If the value is Float
            } else if (values[i] instanceof Long) {
                pstmt.setLong(i + 1, (Long) values[i]); // If the value is Long
            } else if (values[i] instanceof Boolean) {
                pstmt.setBoolean(i + 1, (Boolean) values[i]); // If the value is Boolean
            } else if (values[i] instanceof java.util.Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime())); // If the value is Date
            } else if (values[i] instanceof java.sql.Date) {
                pstmt.setDate(i + 1, (java.sql.Date) values[i]); // If it's already a SQL Date
            } else if (values[i] instanceof java.sql.Timestamp) {
                pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]); // If the value is Timestamp
            } else {
                pstmt.setString(i + 1, values[i].toString()); // Default to String for other types
            }
        }

            int affectedRows = pstmt.executeUpdate(); // Execute the delete statement
            if (affectedRows > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("No record found to delete.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting record: " + e.getMessage());
        }
    }   
    
    public void updateRecord(String tableName, String setClause, String condition, Object[] setValues, Object... conditionValues) {
    // Construct the SQL UPDATE statement
    String sql = "UPDATE " + tableName + " SET " + setClause + " WHERE " + condition;

    try (Connection conn = this.connectDB(); // Use the connectDB method
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Set values for the attributes to be updated
        for (int i = 0; i < setValues.length; i++) {
            if (setValues[i] instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) setValues[i]);
            } else if (setValues[i] instanceof Double) {
                pstmt.setDouble(i + 1, (Double) setValues[i]);
            } else if (setValues[i] instanceof Float) {
                pstmt.setFloat(i + 1, (Float) setValues[i]);
            } else if (setValues[i] instanceof Long) {
                pstmt.setLong(i + 1, (Long) setValues[i]);
            } else if (setValues[i] instanceof Boolean) {
                pstmt.setBoolean(i + 1, (Boolean) setValues[i]);
            } else if (setValues[i] instanceof java.util.Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) setValues[i]).getTime()));
            } else if (setValues[i] instanceof java.sql.Date) {
                pstmt.setDate(i + 1, (java.sql.Date) setValues[i]);
            } else if (setValues[i] instanceof java.sql.Timestamp) {
                pstmt.setTimestamp(i + 1, (java.sql.Timestamp) setValues[i]);
            } else {
                pstmt.setString(i + 1, setValues[i].toString());
            }
        }

        // Set values for the condition (where clause)
        for (int i = 0; i < conditionValues.length; i++) {
            if (conditionValues[i] instanceof Integer) {
                pstmt.setInt(setValues.length + i + 1, (Integer) conditionValues[i]);
                } else if (conditionValues[i] instanceof Double) {
                    pstmt.setDouble(setValues.length + i + 1, (Double) conditionValues[i]);
                } else if (conditionValues[i] instanceof Float) {
                    pstmt.setFloat(setValues.length + i + 1, (Float) conditionValues[i]);
                } else if (conditionValues[i] instanceof Long) {
                    pstmt.setLong(setValues.length + i + 1, (Long) conditionValues[i]);
                } else if (conditionValues[i] instanceof Boolean) {
                    pstmt.setBoolean(setValues.length + i + 1, (Boolean) conditionValues[i]);
                } else if (conditionValues[i] instanceof java.util.Date) {
                    pstmt.setDate(setValues.length + i + 1, new java.sql.Date(((java.util.Date) conditionValues[i]).getTime()));
                } else if (conditionValues[i] instanceof java.sql.Date) {
                    pstmt.setDate(setValues.length + i + 1, (java.sql.Date) conditionValues[i]);
                } else if (conditionValues[i] instanceof java.sql.Timestamp) {
                    pstmt.setTimestamp(setValues.length + i + 1, (java.sql.Timestamp) conditionValues[i]);
                } else {
                    pstmt.setString(setValues.length + i + 1, conditionValues[i].toString());
                }
            }

            // Execute the update statement
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No record found to update.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
    }
    
}
