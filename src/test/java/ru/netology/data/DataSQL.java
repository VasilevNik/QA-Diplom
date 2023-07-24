package ru.netology.data;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSQL {

    private static QueryRunner runner = new QueryRunner();

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(
                System.getProperty("db.url"),
                System.getProperty("db.user"),
                System.getProperty("db.password")
        );
    }

    @SneakyThrows
    public static void cleanDataBase() {
        val connection = getConn();
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
    }

    public static String getPaymentStatus() {
        val statusSQL = "SELECT status FROM payment_entity order by created DESC LIMIT 1";
        try (val conn = getConn()) {
            val status = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return new String(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCreditStatus() {
        val statusSQL = "SELECT status FROM credit_request_entity order by created DESC LIMIT 1";
        try (val conn = getConn()) {
            val status = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return new String(status);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
