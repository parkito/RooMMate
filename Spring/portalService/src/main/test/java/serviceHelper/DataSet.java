package java.serviceHelper;


import java.io.FileOutputStream;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Artem Karnov @date 09.12.2016.
 *         artem.karnov@t-systems.com
 **/
public class DataSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, SQLException, DatabaseUnitException {
        DataSet dataSet = new DataSet();
        dataSet.createDataSet("Grup");
        dataSet.createDataSet("Room");
        dataSet.createDataSet("Room_has_Grup");
        dataSet.createDataSet("User");
        dataSet.createDataSet("User_has_Grup");
    }

    public void createDataSet(String tableTitle) throws ClassNotFoundException, SQLException, IOException, SQLException, DatabaseUnitException {
        System.out.println("Starting generating " + tableTitle);

        Class.forName("com.mysql.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "214189");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable(tableTitle, "SELECT * FROM " + tableTitle);
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(tableTitle + ".xml"));
        connection.close();

        System.out.println(tableTitle + " successfully created");

    }
}
