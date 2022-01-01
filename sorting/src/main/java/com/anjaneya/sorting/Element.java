package com.anjaneya.sorting;

public class Element {
	private Integer value;
	private Integer occurances = 0;

	public Element(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer increaseOccurances() {
		return occurances++;
	}

	public Integer decreaseOccurances() {
		return occurances--;
	}

	public Integer getOccurances() {
		return occurances;
	}
}