package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

	private static Connection connection;
	private static String pathDB="/Users/jeremux/Dropbox/Etudes/2015-2016/siad/eclipse/COVOITURAGE/WebContent/WEB-INF/db/";
	private static String nomDB="covoiturage.db";

	static {
		/**
		 * Chargement du pilote SQlite
		 */
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Pilote SQlite JDBC charge");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Erreur lors du chargmement du pilote");
		}

		/**
		 * Connexion avec la base
		 */
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:"+SingletonConnection.pathDB+nomDB);
			System.out.println("Connexion operationnelle");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l etablissement de la connexion");
		}

	}

	public static Connection getConnection() {
		return connection;
	}
}
