package cn.edu.shu.intelldesk.entity;

public class RawStorage {
    private Integer id;
    private Integer material;

    private Integer state;

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

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "RawStorage [id=" + id + ", material=" + material + ", state=" + state + "]";
    }
}
