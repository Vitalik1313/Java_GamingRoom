import Building.Building;
import SSMS_Con.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class BuildingTest {
    @Test
    public void TestFillingRooms() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Building building = new Building();
        Assert.assertTrue(building.fillRooms(connection.getConn()));
    }

    @Test
    public void TestSearching() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Building building = new Building();
        building.fillRoomsTest();

        Assert.assertTrue(building.searchByName("ball machine"));
        Assert.assertTrue(building.searchByGroup("Sport"));
        Assert.assertTrue(building.searchBySize("MEDIUM"));
    }

    @Test
    public void TestSortingByGroup() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Building building = new Building();
        building.fillInventTest();
        building.sortByGroup();

        for(int i = 0;i < building.getFullInvent().size() - 1;i++){
            int temp = building.getFullInvent().get(i).getGroup().compareTo(building.getFullInvent().get(i+1).getGroup());
            Assert.assertFalse(temp > 0);
        }
    }

    @Test
    public void TestSortingByPrice() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Building building = new Building();
        building.fillInventTest();
        building.sortByPrice();

        for(int i = 0;i < building.getFullInvent().size() - 1;i++){
            Assert.assertFalse(building.getFullInvent().get(i).getPrice() > building.getFullInvent().get(i+1).getPrice());
        }
    }


    @Test
    public void TestSortingBySize() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Building building = new Building();
        building.fillInventTest();
        building.sortBySize();

        for(int i = 0;i < building.getFullInvent().size() - 1;i++){
            int temp = building.getFullInvent().get(i).getSize().compareTo(building.getFullInvent().get(i+1).getSize());
            Assert.assertFalse(temp > 0);
        }
    }

    @Test
    public void TestSortingByNumber() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Building building = new Building();
        building.fillInventTest();
        building.sortByNumber();

        for(int i = 0;i < building.getFullInvent().size() - 1;i++){
            Assert.assertFalse(building.getFullInvent().get(i).getNumber() > building.getFullInvent().get(i+1).getNumber());
        }
    }
}
