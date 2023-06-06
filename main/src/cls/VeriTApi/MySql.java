package cls.VeriTApi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySql {
    
    public Connection connection;
    public String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";
    String[][] dataArray;
    public String defaultTablo(String a){
        if(a.equals("")){
            return "sertifika";
        }
        else{
            return a;
        }
    }
    
    public void connect() {
        try {
            // Veritabanı bağlantısı oluşturma
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void getData(String tabload) {
        connect();
        try {
            String query = "SELECT * FROM " + tabload;
    
            // Sorguyu çalıştırma
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            // Sütun adlarını al
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] columns = new String[columnsNumber];
            for (int i = 1; i <= columnsNumber; i++) {
                columns[i - 1] = rsmd.getColumnName(i);
            }
            
            // Satırları diziye dök
            List<String[]> data = new ArrayList<>();
            while (resultSet.next()) {
                String[] row = new String[columnsNumber];
                for (int i = 1; i <= columnsNumber; i++) {
                    row[i - 1] = resultSet.getString(i);
                }
                data.add(row);
            }
            
            dataArray = new String[data.size()][columns.length];
for (int i = 0; i < data.size(); i++) {
    String[] row = data.get(i);
    for (int j = 0; j < columns.length; j++) {
        dataArray[i][j] = row[j];
    }
            }
            
            System.out.println(dataArray[1][0]);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public String[][] getDataArray(){
        return dataArray;
    }

    public void TestBaglanti() {
        try {
            // Veritabanı bağlantısı oluşturma
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
