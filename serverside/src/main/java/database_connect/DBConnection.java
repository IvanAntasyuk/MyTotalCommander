package database_connect;

import interfaces.AuthService;

import java.sql.*;

public class DBConnection  implements AuthService {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB = "jdbc:mysql://127.0.0.1/DBclients";
    static final String USER = "root";
    static final String PASSWORD = "rootroot";
    static Connection connection;
    static Statement statement;


    public static void start() {
        System.out.println("DB connection start");
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB,USER,PASSWORD);
            statement = connection.createStatement();
            System.out.println("DB connection start");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection error");
        }
    }

    public static String getIdByLoginAndPass(String login, String password) {

        String sql = String.format("SELECT nickname FROM main " + "WHERE login = '%s' AND password = '%s'", login, password);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   public static void registrationByLoginPassAndNick(String login, String password, String nick){
        try {
            String query = "INSERT INTO main (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public static void stop() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
