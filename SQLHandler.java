package server;

import java.sql.*;

public class SQLHandler
{
    private static Connection connection;
    private static PreparedStatement getNickNameSTMNT;
    private static PreparedStatement registrationSTMNT;
    private static PreparedStatement changeNickNameSTMNT;


    public static boolean connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        preparation();
        return true;
    }



    private static void preparation() throws SQLException {
        getNickNameSTMNT= connection.prepareStatement("SELECT NickName FROM users WHERE Login = ? AND Password = ?;");
        registrationSTMNT = connection.prepareStatement("INSERT INTO users (Login, Password, NickName) VALES(?,?,?);");
        changeNickNameSTMNT = connection.prepareStatement("UPDATE users WHERE NickName =? WHERE NickName = ?"  );
    }


    public static String getNickNameByLoginAndPassword(String login, String password) throws SQLException {
        String NickName = null;
        getNickNameSTMNT.setString(1, login);
        getNickNameSTMNT.setString(2,password);
        ResultSet resultSet = getNickNameSTMNT.executeQuery();
        if (resultSet.next())
        {
            NickName = resultSet.getString(1);
        }
        resultSet.close();
        return NickName;
    }

    public static boolean registration(String login, String password, String nickName) throws SQLException {

        registrationSTMNT.setString(1,login);
        registrationSTMNT.setString(2,password);
        registrationSTMNT.setString(3,nickName);
        registrationSTMNT.executeUpdate();
        return true;
    }

    public static boolean changeNickName(String oldNickName,String newNickName)
    {
        try {
            changeNickNameSTMNT.setString(1,oldNickName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            changeNickNameSTMNT.setString(2,newNickName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void disconnect() throws SQLException {
        getNickNameSTMNT.close();
        registrationSTMNT.close();
        changeNickNameSTMNT.close();
        connection.close();
    }
}
