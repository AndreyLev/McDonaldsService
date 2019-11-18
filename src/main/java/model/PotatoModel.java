package model;

import repository.CategoryRepository;

public class PotatoModel extends  ProductModel{
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String size;

    public PotatoModel(int price, String name, String about, CategoryRepository categoryName, String size) {
        super(price, name + " " + size, about, categoryName);
        this.size = size;
    }
}
