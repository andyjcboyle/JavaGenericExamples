package net.java.examples.generics;

import java.util.Date;
import java.util.List;

import net.java.examples.generics.example1.typevariable.Mouse;
import net.java.examples.generics.example1.typevariable.Trap;
import net.java.examples.generics.example2.subclassingGenerics.DateList;
import net.java.examples.generics.example2.subclassingGenerics.RawList;

public class GenericExamplesExecutorUtil
{
  public static void example1_theTypeVariable() {
    Trap<Mouse> mouseTrap = new Trap<Mouse>(new Mouse("Mickey"));
    mouseTrap.snare(new Mouse("Minnie"));
    Mouse aMouse = mouseTrap.release();
    System.out.println("Trapped a Mouse: " + aMouse);
    mouseTrap.snare(new Mouse("Mighty"));
    
    System.out.println("\n\n--- A list of all things caught.\n");
    for ( Mouse mouse : mouseTrap.allBeenTrappedSoFar()) {
      System.out.println(mouse);
    }
  }
  
  public static void example2_subclassingGenerics() {
    usingNonGenerifiedExtendedDateList();
    usingRawExtendedList();
  }

  private static void usingRawExtendedList() {
    RawList myRawDateList = new RawList();
    myRawDateList.add("hello there!");
  }

  private static void usingNonGenerifiedExtendedDateList() {
    DateList myDateList = new DateList();
//    myDateList.add("hello");   // as expected can only add Date's
    myDateList.add(new Date());
    
    // NOTE: Can assign the generified list to List<Date> superclass
    List<Date> superDateList = myDateList;
    superDateList.add(new Date());
  }

}
