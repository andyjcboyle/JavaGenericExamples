package net.java.examples.generics;

import java.util.Date;
import java.util.List;

import net.java.examples.generics.writingGenericClasses.example1.typevariable.Mouse;
import net.java.examples.generics.writingGenericClasses.example1.typevariable.Trap;
import net.java.examples.generics.writingGenericClasses.example2.subclassingGenerics.DateList;
import net.java.examples.generics.writingGenericClasses.example2.subclassingGenerics.RawList;
import net.java.examples.generics.writingGenericClasses.example3.exceptionsAndGenerics.ExceptionTester;
import net.java.examples.generics.writingGenericClasses.example4.parameterTypeLimitations.CreateGenericInstanceWithClass;

public class GenericExamplesExecutorUtil {
	public static void example1_theTypeVariable() {
		Trap<Mouse> mouseTrap = new Trap<Mouse>(new Mouse("Mickey"));
		
		mouseTrap.snare(new Mouse("Minnie"));
		Mouse aMouse = mouseTrap.release();
		System.out.println("Trapped a Mouse: " + aMouse);
		
		mouseTrap.snare(new Mouse("Mighty"));
		aMouse = mouseTrap.release();
		System.out.println("Trapped a Mouse: " + aMouse);
		
		System.out.println("\n\n--- A list of all things caught.\n");
		for (Mouse mouse : mouseTrap.allBeenTrappedSoFar()) {
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
//		 myDateList.add("hello"); // as expected can only add Date's
		myDateList.add(new Date());

		// NOTE: Can assign the generified list to List<Date> superclass
		List<Date> superDateList = myDateList;
		superDateList.add(new Date());
	}

	public static void example3_exceptionsAndGenerics() {
		// NOTE: Compiler still aware of checked exception, as usual i.e.
		// try,catch needed etc
		try {
			new ExceptionTester<ClassNotFoundException>()
					.test(new ClassNotFoundException());
		} catch (Throwable e) {
			System.out.println("Got our exception");
			e.printStackTrace();
		}

		// NOTE: and as expected runtime exception doesn't need try,catch
		new ExceptionTester<NullPointerException>()
				.test(new NullPointerException());
	}

	public static void example4_parameterTypeLimitations() {
		CreateGenericInstanceWithClass<String> myNewClass = new CreateGenericInstanceWithClass<String>();
		myNewClass.testInstantiateRawClassType(Date.class);
//		myNewClass.testInstantiateGenericClassType(Date.class); // This is a compile error
		myNewClass.testInstantiateGenericClassType(String.class);
	}
}
