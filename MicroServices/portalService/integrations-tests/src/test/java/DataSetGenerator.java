import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.List;

import static java.lang.Class.forName;
import static java.sql.DriverManager.getConnection;
import static org.dbunit.dataset.xml.XmlDataSet.write;

/**
 * @author Artem Karnov @date 20.04.2017.
 *         artem.karnov@t-systems.com
 */

public abstract class DataSetGenerator {
    private static Logger logger = LogManager.getLogger(DataSetGenerator.class);

    @Autowired
    private Environment environment;

    private List<String> tables;
    private static IDatabaseConnection connection;

    public DataSetGenerator(List<String> tables) {
        this.tables = tables;
        setUpConnection();
    }

    public DataSetGenerator() {
        setUpConnection();
    }

    private void setUpConnection() {
        Connection jdbcConnection;
        try {
            forName(environment.getRequiredProperty("jdbc.driverClassName"));
            jdbcConnection = getConnection(environment.getRequiredProperty("jdbc.url"));
            connection = new DatabaseConnection(jdbcConnection);
        } catch (Exception e) {
            logger.error("Create connection fail, message: %s", e.getMessage());
        }
    }

    public void generate() {
        if (tables.isEmpty()) {
            createDefaultTablesDataSet();
        } else {
            createCustomTablesDataSet();
        }
    }


    public void createDefaultTablesDataSet() {

    }

    public void createCustomTablesDataSet() {
        for (String table : tables) {
            createTableDataSet(table);
        }
    }

    public static void createTableDataSet(String table) {
        try {
            QueryDataSet queryDataSet = new QueryDataSet(connection);
            queryDataSet.addTable(table, "select * from " + table);
            write(queryDataSet, new FileOutputStream("dataSets/" + table + ".xml"));
        } catch (Exception e) {
            logger.error("Create Xml Fail, message: %s", e.getMessage());
        }
    }
}