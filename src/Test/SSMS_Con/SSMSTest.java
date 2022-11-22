package SSMS_Con;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class SSMSTest {
    @Test
    public void TestSSMSConnection() throws SQLException {
        SSMS connection = new SSMS();
        Assert.assertNotNull(connection);
    }
}