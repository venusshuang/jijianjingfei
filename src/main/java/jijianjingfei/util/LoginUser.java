package jijianjingfei.util;

public class LoginUser {

    private String UserType;
    private String UserID;
    private String TrueName;
    private String DeptID;
    private String DeptName;

    public String getUserType() {
        return UserType;
    }
    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getUserID() {
        return UserID;
    }
    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getTrueName() {
        return TrueName;
    }
    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public String getDeptID() {
        return DeptID;
    }
    public void setDeptID(String deptID) {
        DeptID = deptID;
    }

    public String getDeptName() {
        return DeptName;
    }
    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
}
