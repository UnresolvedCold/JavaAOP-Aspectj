package codes.shubham.aop.play;

public class Play {
  public static void helloWorld() {
    System.out.println("Hello World");
  }

  public static void helloWorld(String name) {
    System.out.println("Hello World "+name);
  }

  public static void main(String[] args) {
    helloWorld();
    helloWorld("Shubham");
  }
}
