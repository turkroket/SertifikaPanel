package cls.VeriTApi;
import java.sql.*;

public class MySql {
    public Connection connection;
    public String URL = "jdbc:mysql://localhost:3306/uye";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";
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
            
            // Sonuçları işleme
            while (resultSet.next()) {
                String id = resultSet.getString("kullaniciadi");
                String ad = resultSet.getString("etkinlikturu");
                String soyad = resultSet.getString("etkinliksuresi");
                
                System.out.println("ID: " + id + ", Ad: " + ad + ", Soyad: " + soyad);
            }
            
            // Kaynakları serbest bırakma
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
}
