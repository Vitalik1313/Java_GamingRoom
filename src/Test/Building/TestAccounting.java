package Building;

import Logger.MyLogger;
import SSMS_Con.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestAccounting {
    @Test
    public void TestGettingInfo(){
        Accounting accounting = new Accounting();
        Assert.assertEquals(20000,accounting.getCurBudget());
        Assert.assertEquals(60,accounting.getMaxNumberToys());
        Assert.assertEquals(0,accounting.getCurNumberToys());
    }

    @Test
    public void TestAddingToy(){
        Accounting accounting = new Accounting();
        accounting.addNewToy();
        Assert.assertEquals(1,accounting.getCurNumberToys());
    }

    @Test
    public void TestReduceBudget(){
        Accounting accounting = new Accounting();
        accounting.reduceBudget(5000);
        Assert.assertEquals(15000,accounting.getCurBudget());
    }

    @Test
    public void TestGettingMaxBudget(){
        Accounting accounting = new Accounting();
        Assert.assertEquals(accounting.getMaxBudget(),20000);
    }

    @Test
    public void TestGettingAccounting() throws SQLException, IOException {
        MyLogger Log = new MyLogger();
        SSMS ssms = new SSMS();
        Building building = new Building(ssms.getConn());
        Assert.assertNotNull(building.getAccounting());
    }
}
