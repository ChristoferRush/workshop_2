package pl.coderslab.christoferrush;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Group {

    private int id;
    private String name;

    public Group(){}

    public Group(String name){
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void saveToDb(Connection conn) throws SQLException {
        if (this.id == 0){
            String sql = "INSERT INTO user_group (name) VALUES (?) ;";
            String[] generatedColumns = { "ID" };
            PreparedStatement stmt = conn.prepareStatement(sql, generatedColumns);
            stmt.setString(1, this.name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        } else {

        }
    }
}
