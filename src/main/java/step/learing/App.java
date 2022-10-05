package step.learing;


import java.sql.*;

import com.mysql.cj.jdbc.Driver;
public class App {
    public void run()
    {

        Driver mysqlDriver;
        try {
            mysqlDriver = new Driver() ;
            DriverManager.registerDriver( mysqlDriver ) ;

        }
        catch( SQLException ex ) {
            System.out.println( "Driver ini error: " + ex.getMessage() ) ;
            return ;
        }
        String connectionString = "jdbc:mysql://localhost:3306/java191?useUnicode=true&characterEncoding=UTF-8";
        Connection connection ;

        try {
            connection = DriverManager.getConnection( connectionString, "root", "" ) ;
        }
        catch( SQLException ex ) {
            System.out.println( "DB Connection error: " + ex.getMessage() ) ;
            return ;
        }

        String sql = "CREATE TABLE  IF NOT EXISTS  randoms ( " +
                "id BIGINT PRIMARY KEY," +
                "num INT NOT NULL," +
                "str VARCHAR(64) NULL" +
                ") Engine=InnoDB  DEFAULT CHARSET = UTF8" ;




        try {
            Statement statement = connection.createStatement() ;
            statement.executeUpdate( sql ) ;   // вариант без возврата данных

            System.out.println( "Query OK" ) ;
        }
        catch( SQLException ex ) {
            System.out.println( "Query error: " + ex.getMessage() ) ;
            return ;
        }

            System.out.println("app works");

        String sql2 = " insert into users (id, num, str)"
                + " values (?, ?, ?)";




        try {
            connection.close() ;
            DriverManager.deregisterDriver( mysqlDriver ) ;
        } catch( SQLException ignored ) {}





    }
}
