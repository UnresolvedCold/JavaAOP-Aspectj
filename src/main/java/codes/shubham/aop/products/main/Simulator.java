package codes.shubham.aop.products.main;

import codes.shubham.aop.products.items.IPhone14Max;
import codes.shubham.aop.products.items.IProduct;
import codes.shubham.aop.products.items.S23Ultra;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
  public static void main(String[] args) {
    List<IProduct> products = new ArrayList<>();
    products.add(new S23Ultra(10, 1_00_000));
    products.add(new IPhone14Max(5, 1_50_000));

    int nDays = 10;
    for (int i = 0; i < nDays; i++) {
      int chooseProduct = (int) (Math.random() * products.size());
      products.get(chooseProduct).setPrice((int) (Math.random() * 1_00_000) + 50_000);
    }
  }
}
