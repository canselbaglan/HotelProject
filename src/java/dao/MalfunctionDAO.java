
package dao;

import entity.Malfunction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ali
 */
public class MalfunctionDAO {
    private Connection db;
    
    
    public void createMalfunction(Malfunction malfunction) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO malfunction (name,date) values('" + malfunction.getName() + "','" + malfunction.getDate() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Malfunction> getAllMalfunctions() {
        List<Malfunction> malfunctions = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from malfunction";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                malfunctions.add(new Malfunction(rs.getLong("id"), rs.getString("name"), rs.getDate("date")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return malfunctions;
    }

    public Malfunction getMalfunction(int id) {
        Malfunction malfunction = null;
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from malfunction where id='" + id + "' limit 1";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                malfunction = new Malfunction(rs.getLong("id"), rs.getString("name"), rs.getDate("date"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return malfunction;
    }

    public void updateMalfunction(Malfunction malfunction) {
        try {
            String query = "UPDATE malfunction SET name='" + malfunction.getName() + "', date='" + malfunction.getDate() + "' WHERE id='" + malfunction.getId() + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteMalfunction(Long id) {
        try {
            String query = "DELETE FROM malfunction WHERE id = '" + id + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public Connection getDb() {
        if (this.db == null) {
            DBConnection dbc = new DBConnection();
            this.db = dbc.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
