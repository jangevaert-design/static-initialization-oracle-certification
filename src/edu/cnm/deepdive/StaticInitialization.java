package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.List;

public class StaticInitialization {

  private static final int SIZE;
  private static int one;
  private static final int two;
  private static final int three = 3;

  private static final List<String> NAMES = new ArrayList<>();
//  private static final int four; doesn't compile because we didn't initialize it in the static blocks.


//We use three static blocks below to initialize the fields above but better would be to work with
//one static block.
  static {
    System.out.println("first static init");
    int rows = 5;
    int columns = 4;
    SIZE = rows * columns;
  }

  static {
    System.out.println("second static init");
    one = 1;
    two = 2;
    one = 3;//since one is not final we can assign it multiple times.
    //three = 4; does not compile because three is final and has been initialized already on line 11.
    //two = 2; does not compile because two is final and has been initialized already on line 26.
    one = 2;
    one = three;
  }

  static {
    System.out.println("third static init");
    NAMES.add("Jimmy");
    NAMES.add("Timmy");
  }

  public static void main(String[] args) {
    System.out.println(NAMES);//prints first static init - second static init - third static init -
// and only then [Jimmy, Timmy]
//static initialization happens first because static fields and methods belong to the class.
  }

}
