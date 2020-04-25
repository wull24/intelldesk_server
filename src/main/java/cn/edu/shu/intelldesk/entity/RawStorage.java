package cn.edu.shu.intelldesk.entity;

public class RawStorage {
    private Integer id;
    private String name;
    private Material material;

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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "RawStorage{" +
                "id=" + id +
                ", name=" + name +
                ", material=" + material +
                '}';
    }
}
