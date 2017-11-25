package q1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		for (int i = list1.size() - 1; i >= 0; --i) {
			list2.add(list1.get(i));
		}
		
		System.out.println("List 1:");
		System.out.println(list1);
		System.out.println("List 2:");
		System.out.println(list2);
	}
}
