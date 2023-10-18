package by.it.academy.jd2.messanger.repository.postgres;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {

        private static volatile DBConnection instance;

        private ComboPooledDataSource cpds;

        private static final Properties properties = new Properties();

        private DBConnection() throws PropertyVetoException {

            try (InputStream input = DBConnection.class.getResourceAsStream("/db.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(properties.getProperty("db.driver"));
            cpds.setJdbcUrl(properties.getProperty("db.url"));
            cpds.setUser(properties.getProperty("db.user"));
            cpds.setPassword(properties.getProperty("db.password"));
            cpds.setMinPoolSize(Integer.parseInt(properties.getProperty("db.minPoolSize")));
            cpds.setAcquireIncrement(Integer.parseInt(properties.getProperty("db.acquireIncrement")));
            cpds.setMaxPoolSize(Integer.parseInt(properties.getProperty("db.maxPoolSize")));
            cpds.setMaxStatements(Integer.parseInt(properties.getProperty("db.maxStatements")));
        }

        public static DataSource getInstance() {
            if (instance == null) {
                synchronized (DBConnection.class) {
                    try {
                        instance = new DBConnection();
                    } catch (PropertyVetoException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return instance.cpds;
        }
}
