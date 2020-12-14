package server;

import java.sql.SQLException;

public class DBServicies implements AuthService
{
    @Override
    public String getNicknameByLoginAndPassword(String login, String password) throws SQLException {
        return SQLHandler.getNickNameByLoginAndPassword(login,password);
    }

    @Override
    public boolean registration(String login, String password, String NickName) throws SQLException {
        return SQLHandler.registration(login,password,NickName);
    }

    @Override
    public boolean changeNickName(String oldNickName, String newNikcName) {
        return changeNickName(oldNickName,newNikcName);
    }
}
