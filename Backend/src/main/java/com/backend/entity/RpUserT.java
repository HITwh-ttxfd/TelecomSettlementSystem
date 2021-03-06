package com.backend.entity;
/**
 * author:万宇成
 * data：2020/7/30
 * purpose:用户管理表
 */
public class RpUserT {
    private String userID;//编号
    private String userName;//用户名
    private String passWord;//密码
    private String trueName;//姓名
    private String sex;//性别
    private double age;//年龄
    private int roleRight;//角色权限
    private String locationNo;//所属地区编号
    private String dept;//所属部门
    private String email;//邮箱
    private String vipRight;//查询特权

    public RpUserT() {
    }

    public RpUserT(String userID, String userName, String passWord, String tureName, String sex, double age, int roleRight, String locationNo, String dept, String email, String vipRight) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.trueName = tureName;
        this.sex = sex;
        this.age = age;
        this.roleRight = roleRight;
        this.locationNo = locationNo;
        this.dept = dept;
        this.email = email;
        this.vipRight = vipRight;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTureName() {
        return trueName;
    }

    public void setTureName(String tureName) {
        this.trueName = tureName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getRoleRight() {
        return roleRight;
    }

    public void setRoleRight(int roleRight) {
        this.roleRight = roleRight;
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVipRight() {
        return vipRight;
    }

    public void setVipRight(String vipRight) {
        this.vipRight = vipRight;
    }

    @Override
    public String toString() {
        return "RpUserT{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", tureName='" + trueName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", roleRight=" + roleRight +
                ", locationNo='" + locationNo + '\'' +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", vipRight='" + vipRight + '\'' +
                '}';
    }
}
