package cn.edu.shu.intelldesk.entity;

import java.util.Date;

public class OrderList {
    private Integer id;
    private Date orderTime;
    private Date finishedTime;
    private String  image;
    private String material;
    private String state;
    private Integer customer_id;
    private User user;
    private FinishedStorage finishedStorage;

    public FinishedStorage getFinishedStorage() {
        return finishedStorage;
    }

    public void setFinishedStorage(FinishedStorage finishedStorage) {
        this.finishedStorage = finishedStorage;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", finishedTime=" + finishedTime +
                ", image='" + image + '\'' +
                ", material='" + material + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
