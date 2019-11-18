package model;


import java.util.List;
import java.util.stream.Collectors;

public class OrderModel {

    public final static int separator = 10;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;



    public List<Integer> getAtWhatCostWereProductsSold() {
        return atWhatCostWereProductsSold;
    }

    public void setAtWhatCostWereProductsSold(List<Integer> aatWhatCostWereProductsSold) {
        atWhatCostWereProductsSold = aatWhatCostWereProductsSold.stream()
                .filter(o -> o > 0)
                .collect(Collectors.toList())
                ;
    }

    public List<Integer> getWhatProductsWereSold() {
        return whatProductsWereSold;
    }

    public void setWhatProductsWereSold(List<Integer> whatProductsWereSold) {
    }

    public List<Integer> getHowManyProductsWereSold() {
        return howManyProductsWereSold;
    }

    public void setHowManyProductsWereSold(List<Integer> howManyProductsWereSold) {
    }

    private List<Integer> whatProductsWereSold;
    private List<Integer> howManyProductsWereSold;
    private List<Integer> atWhatCostWereProductsSold;

    public OrderModel(List<Integer> paidItemsFromTheBasket)
    {
        int allIndexMoreThanThat = 0;
        whatProductsWereSold = paidItemsFromTheBasket.stream()
               .filter(o -> o > allIndexMoreThanThat)
                .map(o -> o / separator)
                .collect(Collectors.toList());

        howManyProductsWereSold = paidItemsFromTheBasket.stream()
                .filter(o -> o > allIndexMoreThanThat)
                .map(o -> o % separator)
                .collect(Collectors.toList());

    }


}
