// NOTE: Not good package place. here :-), but keeping the valid examples together rather than class arrangement
package net.java.examples.generics.example2.subclassingGenerics;

import net.java.examples.generics.example1.typevariable.Trap;

// NOTE: THis is an example of a Generic class extending another Generic class and passing along
// the type parameter to the base class
public class AdjustableTrap<T> extends Trap<T> {

	public AdjustableTrap(T trapped) {
		super(trapped);
	}

	// NOTE:
	public void setSize(int i) {
		// set array size etc ...
	}
}
