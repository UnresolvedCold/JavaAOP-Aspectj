package codes.shubham.aop.db;

import java.util.HashMap;
import java.util.Map;

public class TestDB {
  private static TestDB instance;
  private final Map<String, Object> map = new HashMap<>();

  private TestDB() {
    // Private constructor to enforce singleton pattern
  }

  public static TestDB getInstance() {
    if (instance == null) {
      instance = new TestDB();
    }
    return instance;
  }

  public Map<String, Object> getMap() {
    return map;
  }
}