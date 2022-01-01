package com.anjaneya.sorting;

public class NotSortableException extends Exception {
	private static final long serialVersionUID = 1L;
	public NotSortableException() {
		super();
	}
	public NotSortableException(String message, Throwable cause) {
		super(message, cause);
	}
	public NotSortableException(String message) {
		super(message);
	}
}
