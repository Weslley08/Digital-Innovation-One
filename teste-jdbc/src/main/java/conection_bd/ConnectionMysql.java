package conection_bd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMysql {

	/*
	 *  Construtor declarado como privado. Evitando assim criar inst�ncias da conex�o.
	 */  
	private ConnectionMysql() {
		throw new UnsupportedOperationException();
	}

	public static Connection getConnection() {

		/* Declara objeto conex�o */
		Connection connection = null;

		/* Carrega arquivo de propriedades para pegar par�metros 
		 * necess�rios para se comunicar com o banco de dados */
		try (InputStream input = ConnectionMysql.class.getClassLoader()
				.getResourceAsStream("connection.properties")) {

			/* Define par�metros para se conectar ao banco de dados MySQL. */
			Properties prop = new Properties();
			prop.load(input);

			String driver = prop.getProperty("jdbc.driver");
			String dataBaseAddress = prop.getProperty("db.address");
			String dataBaseName = prop.getProperty("db.name");
			String user = prop.getProperty("db.user.login");
			String password = prop.getProperty("db.user.password");

			/* Constru��o da string de conex�o. */
			StringBuilder dbConnection = new StringBuilder("jdbc:").append(driver).append("://").append(dataBaseAddress)
					.append("/").append(dataBaseName);

			String connectionUrl = dbConnection.toString(); // dbConnection.toString() == "jdbc:mysql://localhost/teste"

			/* Cria a conex�o usando o DriverManager, passando como par�metros a 
			 * string de conex�o, usu�rio e senha do usu�rio. */
			
			try {
				connection = DriverManager.getConnection(connectionUrl, user, password);
			} catch (SQLException e) {
				System.out.println("FALHA ao tentar criar conex�o");
				throw new RuntimeException(e);
			}

		} catch (IOException e) {
			System.out.println("FALHA ao tentar carregar aquivos de propriedades");
			e.printStackTrace();
		}

		return connection;
	}
}
