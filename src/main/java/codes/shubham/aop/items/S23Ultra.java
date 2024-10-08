package codes.shubham.aop.items;

import codes.shubham.aop.logging.PriceLogger;

public class S23Ultra implements IProduct{

  String name;
  int quantity;
  int price;

  public S23Ultra(int quantity, int price) {
    this.name = "S23Ultra";
    this.quantity = quantity;
    this.price = price;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public void setPrice(int price) {
    this.price = price;
    PriceLogger.getInstance().log(name, price);
  }
}
