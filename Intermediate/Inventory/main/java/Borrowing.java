package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Borrowing {

    public static boolean borrowBook(int userId, int bookId) {
        String sql = "INSERT INTO borrowing(user_id, book_id, borrow_date, status) VALUES(?, ?, datetime('now'), 'Borrowed')";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookId);
            pstmt.executeUpdate();

            updateBookStatus(bookId, "Borrowed");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void updateBookStatus(int bookId, String status) {
        String sql = "UPDATE books SET status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, bookId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
