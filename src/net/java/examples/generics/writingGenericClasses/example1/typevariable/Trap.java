package net.java.examples.generics.writingGenericClasses.example1.typevariable;

import java.util.ArrayList;
import java.util.List;

public class Trap<T> {

	T trapped;
	List<T> allTrappedByThisInstance;

	public Trap(T trapped) {
		System.out.println("Trap constructor, caught a "
				+ trapped.getClass().getSimpleName());
		this.trapped = trapped;
		allTrappedByThisInstance.add(trapped);
	}

	static {
		System.out.println("Trap static initialiser 1");
		// NOTE: We cannot refer to a the generic variable 'trapped' within a
		// 'static' method because there is only ONE version of Trap class at
		// runtime. Hence it makes no sense to be able to refer to an instance's
		// type version. i.e. if we try to change "trapped" and
		// "allTrappedByThisInstance" would get compile error
		
		// If there were different classes at runtime per generic instantiation
		// then this would be possible. e.g. like C++'s Templates ( I assume,
		// though I couldn't find any statements that say so specifically).

		// System.out.println("Trap the static init 2 : "
		// + trapped.getClass().getSimpleName());

		// NOTE: For the same reason as above we cannot refer to the Type
		// Variable 'T' - i.e. don't know what 'T' is at runtime so can't be
		// used
		// To create the array list

		// allTrappedByThisInstance = new ArrayList<T>();
	}

	{
		System.out.println("Trap instance initialiser 1");
		if (trapped != null) {
			// NOTE: 'trapped' is impossible to initialise by the point that
			// this
			// instance initialiser gets
			// called because instance initialisers are called AFTER super()
			// ones, but
			// BEFORE any constructors
			// in the same class. So I'm pretty certain that 'trapped' will
			// always be
			// null at this point
			// meaning the following code can never be called.

			System.out.println("Trap instance initialiser 2: "
					+ trapped.getClass().getSimpleName());
		}
		allTrappedByThisInstance = new ArrayList<T>();
		System.out
				.println("Trap instance initialiser 3 : Created list to hold all trapped");
	}

	public void snare(T trapped) {
		this.trapped = trapped;
		allTrappedByThisInstance.add(trapped);
	}

	public T release() {
		return trapped;
	}

	public List<T> allBeenTrappedSoFar() {
		return allTrappedByThisInstance;
	}
}
