package codes.shubham.aop.products.items;

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
  }

  @Override
  public String getName() {
    return this.name;
  }
}
