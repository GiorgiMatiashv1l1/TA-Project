package model;

public class Category {
    private UserType usertype;
    private String category;

    public Category() {
    }

    // Parameterized Constructor
    public Category(UserType usertype, String category) {
        this.usertype = usertype;
        this.category = category;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "usertype=" + usertype +
                ", category='" + category + '\'' +
                '}';
    }
}