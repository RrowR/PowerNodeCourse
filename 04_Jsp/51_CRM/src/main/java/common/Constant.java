package common;

/**
 * 所有的相关业务常量
 */
public interface Constant {
    //用户角色--管理员
    Integer USER_ROLE_ADMIN=1;
    //用户角色--普通员工
    Integer USER_ROLE_NORMAL=0;
    //session中当前登录的用户的key
    String SESSION_CURRENT_USER_KEY = "user";
    //用户删除状态  1  有效
    Integer USER_DELETE_VALID = 1;
    //用户删除状态  2  无效
    Integer USER_DELETE_INVALID = 2;
}
