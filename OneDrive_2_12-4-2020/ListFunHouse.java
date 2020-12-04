//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class ListFunHouse {
	// this method will print the entire list on the screen
	public static void print(ListNode list) {
		while (list != null) {
			System.out.print(list.getValue() + " ");
			list = list.getNext();
		}
	}

	// this method will return the number of nodes present in list
	public static int nodeCount(ListNode list) {
		// iterative approach
		int cnt = 0;
		while (list != null) {
			cnt++;
			list = list.getNext();
		}
		return cnt;

	}

	// this method will create a new node with the same value as the first node and
	// add this
	// new node to the list. Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list) {
		list.setNext(new ListNode(list.getValue(), list.getNext()));

	}

	// this method will create a new node with the same value as the last node and
	// add this
	// new node at the end. Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list) {
		while (list != null && list.getNext() != null) {
			list = list.getNext();
		}
		ListNode add = new ListNode(list.getValue(), null);
		list.setNext(add);
	}

	// method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list) {
		while (list != null && list.getNext() != null) {
			list.setNext(list.getNext().getNext());
			list = list.getNext();
		}
	}

	// this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value) {
		int count = 1;
		while (list != null) {
			if (x == count) {
				list.setValue(value);
				count = 1;
			} else {
				count++;
			}
			list = list.getNext();
		}
	}

	// this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x) {
		int count = 1;
		ListNode prev = list;
		while (list != null) {
			if (x == count) {
				prev.setNext(list.getNext());
				count = 1;
			} else {
				count++;
			}
			prev = list;
			list = list.getNext();
		}
	}
}