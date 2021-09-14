package com.test.day12.nighthomework.work2.code04;

/**
 * 构造方法与重载：定义一个网络用户类，要处理的信息有用户 ID、用户密码、 email 地址。
 * 在建立类的实例时把以上三个信息都作为构造函数的参数输入，
 * 其中用户 ID 和用户密码时必须缺省时 email地址是用户 ID 加上字符串"@gameschool.com"。
 */
public class Users {
   private String userId;
   private String passWord;
   private String email;

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Users(String userId, String passWord, String email) {
        this.userId = userId;
        this.passWord = passWord;
        if (email == null){
            this.email = "@gameschool.com";
        }else {
            this.email = email;
        }
    }

    public Users() {
    }


}
