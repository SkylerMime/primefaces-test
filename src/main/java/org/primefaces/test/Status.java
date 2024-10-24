package org.primefaces.test;

enum Status {
	MY_SUCCESS("My Success"), FAILURE("Failure"), UNRESOLVED("Unresolved");

	private final String label;

	Status(String label) {
		this.label = label;
	}

	@Override
	  public String toString() {
	    return label;
	  }
}