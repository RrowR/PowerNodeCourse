package common;

/**
 * 封装页面需要的数据模型
 */
public class Result {
    private Integer code=0;//业务码
    private String msg="";// 业务消息
    private Integer count=0;//数据总条数[对layui的table分页有效果]
    private Object data;// 业务数据

    public Result() {
    }
    public Result(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Result(String msg, Integer count, Object data) {
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
