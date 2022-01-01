package com.anjaneya.sorting;

/**
 * List of number must contain whole numbers(Integer,int) only Limitation: This
 * will work if and only if: maxValue <= minValue + n Time complexity is O(3n)
 * 
 * This algorithm works based on difference between minimum value and currant
 * value.
 *
 * @author Niravdas
 * @since 2021-12-31
 * 
 */

public class Sorting {
	static final Integer N = 11;
	static Element[] elementsToSort = new Element[N];

	public static void main(String[] args) throws Exception {
		int[] val = { 4, 4, 4, 3, 3, 3, 2, 6, 7, 12, 10 };
		for (int i = 0; i < N; i++) {
			elementsToSort[i] = new Element(val[i]);
		}
		printElements(elementsToSort);
		try {
			Element[] sortedElements = sort(elementsToSort);
			printElements(sortedElements);
		} catch (Exception e) {
			throw e;
		}
	}

	private static Element[] sort(Element[] unsortedElements) throws NotSortableException {
		Integer min = unsortedElements[0].getValue(), max = unsortedElements[0].getValue(); 
		Element[] elementSortHelper = new Element[unsortedElements.length];
		// Find minimum value in list
		for (int i = 0; i < unsortedElements.length; i++) {
			if (min > unsortedElements[i].getValue()) {
				min = unsortedElements[i].getValue();
			}
			if (max < unsortedElements[i].getValue()) {
				max = unsortedElements[i].getValue();
			}
		}
		if(max - min > unsortedElements.length) {
			throw new NotSortableException("");
		}
		// Subtract minimum value from each element and
		// put value in temporary list at index (elementValue - minimumValue) increase
		// count for that number
		for (int i = 0; i < unsortedElements.length; i++) {
			if (elementSortHelper[unsortedElements[i].getValue() - min] == null) {
				elementSortHelper[unsortedElements[i].getValue() - min] = unsortedElements[i];
			}
			elementSortHelper[unsortedElements[i].getValue() - min].increaseOccurances();
//			traceElements(i, elementsTempSorted); // uncomment for code debug
		}

		Element[] sortedElements = new Element[unsortedElements.length];
		int tempIndex = 0, i = 0;
		while (i < sortedElements.length) {
			while (elementSortHelper[tempIndex] != null && elementSortHelper[tempIndex].getOccurances() > 0 && i < sortedElements.length) {
				elementSortHelper[tempIndex].decreaseOccurances();
				sortedElements[i++] = elementSortHelper[tempIndex];
			}
			tempIndex++;
		}
		return sortedElements;
	}

	private static void printElements(Element[] elementsToPrint) {
		for (int i = 0; i < elementsToPrint.length; i++) {
			System.out.printf("%3s", (elementsToPrint[i] != null ? elementsToPrint[i].getValue() + "" : "null") + ", ");
		}
		System.out.println();
	}

	private static void traceElements(int el, Element[] elementsToPrint) {
		System.out.printf("%3d : ", el);
		for (int i = 0; i < elementsToPrint.length; i++) {
			System.out.printf("[%5s], ",
					(elementsToPrint[i] != null ? elementsToPrint[i].getValue() + ", " + elementsToPrint[i].getOccurances()
							: "null"));
		}
		System.out.println();
	}
}
