package codes.shubham.aop.products.items;

public class IPhone14Max implements IProduct {

  String name;
  int quantity;
  int price;

  public IPhone14Max( int quantity, int price) {
    this.name = "IPhone14Max";
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
