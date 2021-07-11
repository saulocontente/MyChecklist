package model;

public class Item {
    private String description;
    private Boolean checkbox;

    public Item() { }

    public Item(String description) {
        this.description = description;
        this.checkbox = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }
}
