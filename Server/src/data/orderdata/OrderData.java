package data.orderdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 常德隆 on 2016/11/20.
 */
public class OrderData {
    private Statement stmt;
    private ResultSet rs;

    public OrderData(){
        String url = "jdbc:sqlserver://127.0.0.1:1368;databaseName=DS_HRS_OrderData;user=sa;password=";//sa身份连接

        // Declare the JDBC objects.
        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
