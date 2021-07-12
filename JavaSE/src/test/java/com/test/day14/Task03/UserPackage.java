package com.test.day14.Task03;

public class UserPackage {
    private String userName;
    private Integer age;
    private String technologyDirection = "数据库维护";
    private Integer workExperience;
    private String worksIn;
    private String carrer;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age >= 15){
            this.age = age;
        }else {
            System.out.println("无效的信息");
            this.age = 15;
        }
    }

    public String getTechnologyDirection() {
        return technologyDirection;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorksIn() {
        return worksIn;
    }

    public void setWorksIn(String worksIn) {
        this.worksIn = worksIn;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

}
