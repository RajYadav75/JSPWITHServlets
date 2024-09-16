package in.raj.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionFtry {
    private static DataSource ds = null;

    public static Connection getConnection() {
        Connection con = null;
        try {
            if (ds ==null){
                FileInputStream fis = new FileInputStream(new File("C:\\Users\\Raj Yadav\\Desktop\\JSPWITHServlets\\01.LoginAndRegister\\src\\main\\resources\\db.properties"));
                Properties p = new Properties();
                p.load(fis);
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setUsername(p.getProperty("db.uname"));
                hikariConfig.setPassword(p.getProperty("db.password"));
                hikariConfig.setJdbcUrl(p.getProperty("db.url"));
                hikariConfig.setDriverClassName(p.getProperty("db.driver"));

                ds=new HikariDataSource(hikariConfig);
            }
            con= ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}