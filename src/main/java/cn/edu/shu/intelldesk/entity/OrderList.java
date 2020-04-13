package cn.edu.shu.intelldesk.entity;

public class OrderList {
    private Integer id;
    private Integer material;
    private Integer image;
    private Integer state;
    private Integer storageid;

    public Integer getStorageid() {
        return storageid;
    }
    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
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
    @Override
    public String toString() {
        return "OrderList [id=" + id + ", material=" + material + ", image=" + image + ", state=" + state + "]";
    }
}
