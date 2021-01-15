import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap {
	private ArrayList<Integer> list;

	public Heap() {
		list = new ArrayList<Integer>();
	}

	public void add(int value) {
		list.add(value);
		swapUp(list.size() - 1);
	}

	public void swapUp(int bot) {
		while (bot > 0) {
			int parentNode = (bot - 1) / 2;
			if (list.get(parentNode) < list.get(bot)) {
				swap(parentNode, bot);
				bot = parentNode;
			} else {
				break;
			}
		}
	}

	public void remove() {
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		swapDown(list.size());
	}

	public void swapDown(int top) {
		int parentNode = 0;
		while (parentNode < top) {
			int maximum = 0;
			int L = parentNode * 2 + 1;
			int R = parentNode * 2 + 2;

			if (L < top) {
				if (R < top) {
					if (list.get(L) <= list.get(R)) {
						maximum = R;
					} else {
						maximum = L;
					}
				} else
					maximum = L;
			} else
				break;

			if (list.get(parentNode) < list.get(maximum)) {
				swap(parentNode, maximum);
				parentNode = maximum;
			} else
				break;
		}
	}

	private void swap(int start, int finish) {
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	public void print() {
		out.println("\n\nPRINTING THE HEAP!\n\n");
		int y = 0;
		for (int i = 1; i < list.size(); i *= 2) {
			for (int s = 1; s < list.size() - i; s++) {
				out.print(" ");
			}
			for (int k = 0; k<= i - 1 && y < list.size(); k++) {
				out.print(list.get(y++) + "  ");
			}
			out.println();
			if (y == list.size() - 1) {
				out.print(list.get(y++) + "  ");
			}
		}
		out.println();
	}

	public String toString() {
		return list.toString();
	}
}