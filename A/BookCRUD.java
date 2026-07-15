import java.sql.*;
import java.util.Scanner;

public class BookCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASSWORD = "admin";   // Change if necessary

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {

                System.out.println("\n===== BOOK MENU =====");
                System.out.println("1. Insert Book");
                System.out.println("2. Display Books");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {

                    case 1:

                        System.out.print("Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();

                        PreparedStatement ps1 = con.prepareStatement(
                                "INSERT INTO book VALUES(?,?,?,?,?,?)");

                        ps1.setInt(1, id);
                        ps1.setString(2, title);
                        ps1.setString(3, author);
                        ps1.setDouble(4, price);
                        ps1.setInt(5, qty);
                        ps1.setString(6, isbn);

                        int r1 = ps1.executeUpdate();

                        if (r1 > 0)
                            System.out.println("Book inserted successfully.");
                        else
                            System.out.println("Insertion failed.");

                        break;

                    case 2:

                        PreparedStatement ps2 = con.prepareStatement(
                                "SELECT * FROM book");

                        ResultSet rs = ps2.executeQuery();

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("book_id") + "  " +
                                    rs.getString("title") + "  " +
                                    rs.getString("author") + "  " +
                                    rs.getDouble("price") + "  " +
                                    rs.getInt("quantity") + "  " +
                                    rs.getString("isbn"));
                        }

                        break;

                    case 3:

                        System.out.print("Enter Book ID: ");
                        int uid = sc.nextInt();

                        System.out.print("New Price: ");
                        double newPrice = sc.nextDouble();

                        System.out.print("New Quantity: ");
                        int newQty = sc.nextInt();

                        PreparedStatement ps3 = con.prepareStatement(
                                "UPDATE book SET price=?, quantity=? WHERE book_id=?");

                        ps3.setDouble(1, newPrice);
                        ps3.setInt(2, newQty);
                        ps3.setInt(3, uid);

                        int r3 = ps3.executeUpdate();

                        if (r3 > 0)
                            System.out.println("Book updated successfully.");
                        else
                            System.out.println("Book not found.");

                        break;

                    case 4:

                        System.out.print("Enter Book ID: ");
                        int did = sc.nextInt();

                        PreparedStatement ps4 = con.prepareStatement(
                                "DELETE FROM book WHERE book_id=?");

                        ps4.setInt(1, did);

                        int r4 = ps4.executeUpdate();

                        if (r4 > 0)
                            System.out.println("Book deleted successfully.");
                        else
                            System.out.println("Book not found.");

                        break;

                    case 5:

                        con.close();
                        sc.close();
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");
                }

            }

        } catch (Exception e) {

            System.out.println("Database Error: " + e.getMessage());
        }

    }
}

/*
cd A
javac -cp ".;lib/mysql-connector-j-9.7.0.jar" BookCRUD.java
java -cp ".;lib/mysql-connector-j-9.7.0.jar" BookCRUD
*/