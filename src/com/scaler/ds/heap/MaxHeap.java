package com.scaler.ds.heap;

public class MaxHeap {

	private long[] H;
	private int size;
	private int maxSize;

	public MaxHeap(int size) {
		this.maxSize =size;
		this.size = -1;
		H = new long[this.maxSize];
	}

	// Function to return the index of the
	// parent node of a given node
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// Function to return the index of the
	// left child of the given node
	private int leftChild(int i) {
		return ((2 * i) + 1);
	}

	// Function to return the index of the
	// right child of the given node
	private int rightChild(int i) {
		return ((2 * i) + 2);
	}

	// Function to shift up the
	// node in order to maintain
	// the heap property
	public void shiftUp(int i) {
		while (i > 0 && H[parent(i)] < H[i]) {
			// Swap parent and current node
			swap(parent(i), i);

			// Update i to parent of i
			i = parent(i);
		}
	}

	// Function to shift down the node in
	// order to malongain the heap property
	public void shiftDown(int i) {
		int maxIndex = i;

		// Left Child
		int l = leftChild(i);

		if (l <= size && H[l] > H[maxIndex]) {
			maxIndex = l;
		}

		// Right Child
		int r = rightChild(i);

		if (r <= size && H[r] > H[maxIndex]) {
			maxIndex = r;
		}

		// If i not same as maxIndex
		if (i != maxIndex) {
			swap(i, maxIndex);
			shiftDown(maxIndex);
		}
	}

	// Function to insert a
	// new element in
	// the Binary Heap
	public void insert(long p) {
		size = size + 1;
		H[size] = p;

		// Shift Up to maintain
		// heap property
		shiftUp(size);
	}

	// Function to extract
	// the element with
	// maximum priority
	public long extractMax() {
		long result = H[0];

		// Replace the value
		// at the root with
		// the last leaf
		H[0] = H[size];
		size = size - 1;

		// Shift down the replaced
		// element to malongain the
		// heap property
		shiftDown(0);
		return result;
	}

	// Function to change the priority
	// of an element
	public void changePriority(int i, long p) {
		long oldp = H[i];
		H[i] = p;

		if (p > oldp) {
			shiftUp(i);
		} else {
			shiftDown(i);
		}
	}

	// Function to get value of
	// the current maximum element
	public long getMax() {
		return H[0];
	}

	// Function to remove the element
	// located at given index
	public void remove(int i) {
		H[i] = getMax() + 1;

		// Shift the node to the root
		// of the heap
		shiftUp(i);

		// Extract the node
		extractMax();
	}

	public void swap(int i, int j) {
		long temp = H[i];
		H[i] = H[j];
		H[j] = temp;
	}

}
