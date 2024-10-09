package codes.shubham.aop.boxset;

public class Boxset {
  String name;
  Boxset(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    Boxset boxset = new Boxset("Boxset");
    boxset.setName("Boxset 2");
    System.out.println(boxset.getName());
  }
}
