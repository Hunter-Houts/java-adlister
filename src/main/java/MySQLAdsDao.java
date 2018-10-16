import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config con) {
        try{
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    con.getUrl(),
                    con.getUser(),
                    con.getPassword()
            );

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        String query = "SELECT * FROM Ads";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                ads.add(new Ad(rs.getLong("user_id"),rs.getString("title"),rs.getString("description")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        String query = String.format("insert into Ads(user_id,title,description) values('%d','%s','%s')",ad.getUserId(),ad.getTitle(),ad.getDescription());
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
