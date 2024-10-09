package codes.shubham.aop.play;

import codes.shubham.aop.db.TestDB;

import java.util.List;

public class Play {
  public static void helloWorld() {
    System.out.println("Hello World");
  }

  public static void helloWorld(String name) {
    System.out.println("Hello World "+name);
  }

  public static int getAge() {
    return 25;
  }

  public static List<List<String>> getNames() {
    return List.of(List.of("Shubham", "Kumar"), List.of("John", "Doe"));
  }

  public static void main(String[] args) {
    helloWorld();
    helloWorld("Shubham");
    System.out.println(getAge());
    System.out.println(getNames());
    System.out.println(TestDB.getInstance().getMap());
  }
}
