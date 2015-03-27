package db;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.h2.tools.RunScript;
import org.h2.tools.Server;

public class H2Db {
	private Server h2Server;
	private Connection conn;
	private static Logger log = Logger.getLogger(H2Db.class.getName());

	public void init() {
		log.log(Level.INFO, "starting db");
		startDb();
		populateDb();

	}

	public void populateDb() {
		InputStream is = H2Db.class.getClassLoader().getResourceAsStream("create.sql");
		Reader reader = new InputStreamReader(is);
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9078/./test;MODE=Oracle;", "sa", "sa");
			log.log(Level.INFO, "running sql script");
			RunScript.execute(conn, reader);
			log.log(Level.INFO, "done");
		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, "filed to populate db", e);
		}

	}

	public void cleanDb() {
		StringBuilder builder = new StringBuilder();
		builder.append("delete from author_book;");
		builder.append("delete from author;");
		builder.append("delete from book;");
		builder.append("delete from cathegory;");
		StringReader stringReader = new StringReader(builder.toString());

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9078/./test;MODE=Oracle;", "sa", "sa");
			log.log(Level.INFO, "cleaning db");
			RunScript.execute(conn, stringReader);
			log.log(Level.INFO, "cleaned");
		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, "filed to populate db", e);
		}

	}

	public void startDb() {
		try {
			log.log(Level.INFO, "starting server");
			h2Server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9078").start();
			log.log(Level.INFO, h2Server.getStatus());
		} catch (SQLException e) {
			log.log(Level.SEVERE, "filed to start db", e);
		}

	}

	public void destroy() {
		log.log(Level.INFO, "stopping db");
		h2Server.stop();
		log.log(Level.INFO, "db.stpped");
	}

	public static void main(String[] args) {
		H2Db h2 = new H2Db();
		h2.init();
	}
}
