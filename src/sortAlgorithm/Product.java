package sortAlgorithm;

import java.util.Comparator;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-13 21:49
 */

public class Product implements Comparable<Product> {
    private int price;
    private int sale;

    public Product(int price, int sale) {
        this.price = price;
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public int getSale() {
        return sale;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public int compareTo(Product o) {
        if (this.sale == o.sale) {
            return this.price - o.price;
        } else {
            return this.sale - o.sale;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sale=" + sale +
                '}';
    }
}

class ProductCompare implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getSale() - o2.getSale();
    }
}