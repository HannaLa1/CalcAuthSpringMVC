package spring.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.application.repository.DBConnection;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "spring.application")
public class JDBCConfig {

    @Bean
    public DBConnection dbConnection() {
        Properties properties = new Properties();

        try {
            properties.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dbUrl = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        return new DBConnection(dbUrl, user, password);
    }
}
