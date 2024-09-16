package in.raj.dao;

import in.raj.connection.ConnectionFtry;
import in.raj.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String INSERT_SQL =
            "insert into user_tbl(user_name,user_email,user_phono) values (?,?,?)";
    private static final String SELECT_SQL =
            "select * from user_tbl";

    public boolean saveUser(UserDto dto) {
        boolean isSaved = false;
        try {
            Connection con = ConnectionFtry.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_SQL);
            ps.setString(1, dto.getUserName());
            ps.setString(2, dto.getUserEmail());
            ps.setInt(3, dto.getUserPhono());
            int count = ps.executeUpdate();
            if (count > 0) {
                isSaved = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public List<UserDto> getUsers(){
        List<UserDto> users= new ArrayList<UserDto>();

        try {
            Connection con = ConnectionFtry.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SELECT_SQL);
            while (rs.next()){
                UserDto user = new UserDto();
                user.setUserId(rs.getInt("USER_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setUserEmail(rs.getString("USER_EMAIL"));
                user.setUserPhono(rs.getInt("USER_PHONO"));
                //TODO-> Adding each user obj to collection
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }
}
