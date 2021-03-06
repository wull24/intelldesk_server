package cn.edu.shu.intelldesk.entity;

/**
 * 用于登录之后返回状态
 */
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private RespBean() {
    }

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj,null);
    }

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null,null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj,null);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null,null);
    }

    public static RespBean ok(String msg,Object obj, String token){return new RespBean(200,msg,obj,token);}

    private RespBean(Integer status, String msg, Object obj,String token) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
        this.token = token;
    }

    public Integer getStatus() {

        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
