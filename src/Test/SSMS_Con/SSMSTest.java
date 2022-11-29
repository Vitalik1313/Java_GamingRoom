package SSMS_Con;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SSMSTest {
    @Test
    public void TestSSMSConnection() throws SQLException, IOException {
        SSMS connection = new SSMS();
        Assert.assertNotNull(connection);
    }
}