package models;

import org.junit.After;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * This class is responsible for testing the DBConnection class.
 */
public class TestDBConnection {
    @After
    public void tearDown() throws SQLException {
        DBConnection.getConnection().close();
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(DBConnection.getConnection());
        assertTrue(DBConnection.getConnection().isValid(1));
        assertTrue(DBConnection.getConnection().getAutoCommit());

        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery("SELECT name FROM sqlite_schema;");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}
