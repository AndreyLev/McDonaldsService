package model;

import repository.CategoryRepository;

public class ProductModel {

    private int id;
    private int price;
    private String name;
    private String about;
    private CategoryRepository categoryName;

    public ProductModel(int price, String name, String about, CategoryRepository categoryName) {
        this.price = price;
        this.name = name;
        this.about = about;
        this.categoryName = categoryName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public CategoryRepository getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryRepository categoryName) {
        this.categoryName = categoryName;
    }

    public ProductModel withId(int id) {
        return new ProductModel(
                price,
                name,
                about,
                categoryName
        );
    }

}
