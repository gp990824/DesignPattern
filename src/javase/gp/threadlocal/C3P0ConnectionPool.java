package javase.gp.threadlocal;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Gp
 * @create 2020/4/14 16:27
 */
public class C3P0ConnectionPool {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            dataSource.setDriverClass("oracle.jdbc.OracleDriver");
            dataSource.setJdbcUrl("jdbc:oracle:thin:localhost:1521:ORCL");
            dataSource.setUser("scott");
            dataSource.setPassword("tiger");
            dataSource.setMaxPoolSize(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (threadLocal.get() == null) {
            threadLocal.set(dataSource.getConnection());
        }
        return threadLocal.get();
    }
    public static void removeConnection(){
        threadLocal.remove();
    }

}
