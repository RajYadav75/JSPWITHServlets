package in.raj.dto;

public class UserDto {
    private Integer userId;
    private String userName;
    private String userEmail;
    private Integer userPhono;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserPhono() {
        return userPhono;
    }

    public void setUserPhono(Integer userPhono) {
        this.userPhono = userPhono;
    }
}
