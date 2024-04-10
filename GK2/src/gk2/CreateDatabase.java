package gk2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        // Thông tin kết nối đến SQL Server
        String url = "jdbc:sqlserver://localhost:1433";
        String dbName = "Quanlinhanvien";
        String username = "sa";
        String password = "abcde";

        // Thực hiện kết nối đến SQL Server
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Tạo đối tượng Statement để thực thi các câu lệnh SQL
            Statement stmt = conn.createStatement();

            // Tạo cơ sở dữ liệu
            String createDatabaseSQL = "CREATE DATABASE " + dbName;
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Database created successfully");

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
