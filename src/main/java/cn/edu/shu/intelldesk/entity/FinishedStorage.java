package cn.edu.shu.intelldesk.entity;

public class FinishedStorage {
    private Integer id;
    private String name;
    private OrderList order;
    private User user;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderList getOrder() {
        return order;
    }

    public void setOrder(OrderList order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "FinishedStorage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
