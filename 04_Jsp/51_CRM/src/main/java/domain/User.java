package domain;

import java.util.Date;

/**
 * 用户
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private Integer role;
    private Integer deleted;
    private String img;
    private Date createTime;
    private Date updateTime;
    private Date deletedTime;

    public User(Integer id, String username, String password, String realName, Integer role, Integer deleted, String img, Date createTime, Date updateTime, Date deletedTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.role = role;
        this.deleted = deleted;
        this.img = img;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedTime = deletedTime;
    }

    public User(String username, String password, String realName, Integer role, Integer deleted, String img, Date createTime, Date updateTime, Date deletedTime) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.role = role;
        this.deleted = deleted;
        this.img = img;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedTime = deletedTime;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }


}
