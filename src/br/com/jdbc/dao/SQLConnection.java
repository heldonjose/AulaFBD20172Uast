package br.com.jdbc.dao;

import br.com.jdbc.exception.DaoException;
import br.com.jdbc.util.SQLUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {

    public static String NOME_BD_CONNECTION_POSTGRESS = "POSTGRES";
    
    private static Connection conexao = null;

    private SQLConnection() {

    }
    public static Connection getConnectionInstance(String bd) throws DaoException {
        try {
            if (conexao == null) {
                switch (bd) {
                    case "POSTGRES":
                        conexao = DriverManager.getConnection(
                                SQLUtil.URL_POSTGRES,
                                SQLUtil.USUARIO_POSTGRES,
                                SQLUtil.SENHA_POSTGRES
                        );
                        break;
                    default:
                        break;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Problema na Conexão com o BD");
        }
        return conexao;
    }

}
