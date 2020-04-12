package cn.edu.shu.intelldesk.entity;

public class FinishedStorage {
    private Integer id;
    private Integer material;
    private Integer image;
    private Integer state;
    private Integer orderid;

    public Integer getOrderid() {
        return orderid;
    }
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMaterial() {
        return material;
    }
    public void setMaterial(Integer material) {
        this.material = material;
    }
    public Integer getImage() {
        return image;
    }
    public void setImage(Integer image) {
        this.image = image;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
}
