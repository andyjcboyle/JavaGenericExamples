package net.java.examples.generics;

import net.java.examples.generics.example1.typevariable.Mouse;
import net.java.examples.generics.example1.typevariable.Trap;

public class GenericExamplesExecutor {

	public static void main(String[] args) {
		example1_theTypeVariable();
	}

	private static void example1_theTypeVariable() {
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
	
}
