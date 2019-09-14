package sortAlgorithm;


/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-13 21:48
 */

public class SortStable {
    private static void bubbleSort1(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].getPrice() < products[j - 1].getPrice()) {
                    swap(j, j - 1, products);
                }
            }
        }
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].getSale() < products[j - 1].getSale()) {
                    swap(j, j - 1, products);
                }
            }
        }
    }

    private static void bubbleSort2(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].getPrice() <= products[j - 1].getPrice()) {
                    swap(j, j - 1, products);
                }
            }
        }
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].getSale() <= products[j - 1].getSale()) {
                    swap(j, j - 1, products);
                }
            }
        }
    }

    private static Product[] swap(int i, int j, Product[] products) {
        Product temp = products[i];
        products[i] = products[j];
        products[j] = temp;
        return products;
    }

    private static void bubbleSort3(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].compareTo(products[j - 1]) < 0) {
                    swap(j, j - 1, products);
                }
            }
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(3, 10);
        Product product2 = new Product(1, 9);
        Product product3 = new Product(2, 9);
        Product product4 = new Product(0, 9);
        Product[] products = new Product[] {product1, product2, product3, product4};
        bubbleSort3(products);
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

}
