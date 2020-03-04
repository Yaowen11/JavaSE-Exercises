package ee.jdbc;

import java.sql.*;

/**
 * @author zhangyaowen
 */
public class CityCurd {
    private Connection connection;
    private PreparedStatement preparedStatement;

    CityCurd() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "root", "secret");
    }

    int insert() throws SQLException {
        preparedStatement = connection.prepareStatement("insert into city values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setNull(1, Types.INTEGER);
        preparedStatement.setString(2, "NanChong");
        preparedStatement.setString(3, "CHN");
        preparedStatement.setString(4, "SiChuan");
        preparedStatement.setInt(5, 14000000);
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    ResultSet select(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from city where id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    int update(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("update city set name = ? where id = ?");
        preparedStatement.setString(1, "wuhan");
        preparedStatement.setInt(2, id);
        return preparedStatement.executeUpdate();
    }

    int delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("delete from city where id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ClassLoader classLoader = CityCurd.class.getClassLoader();
        //classLoader.loadClass("com.mysql.cj.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        CityCurd cityCurd = new CityCurd();
        int insertId = cityCurd.insert();
        if (insertId == 0) {
            System.out.println("insert fail");
        }
        ResultSet chengdu = cityCurd.select(insertId);
        if (chengdu.next()) {
            System.out.println("insert id: " + chengdu.getInt("id") + ", name: " + chengdu.getString("Name"));
        }
        int updateCity = cityCurd.update(insertId);
        System.out.println("update: " + updateCity);
        ResultSet wh = cityCurd.select(insertId);
        if (chengdu.next()) {
            System.out.println("id: " + wh.getInt("id") + ", name: " + wh.getString("Name"));
        }
        System.out.println("delete: " + cityCurd.delete(insertId));
    }
}
