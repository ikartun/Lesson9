package by.epam.tr.lesson9;

public class MyLinkedListExecutor {

	public static void main(String[] args) {
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
		
		System.out.println(myLinkedList);		
		
		myLinkedList.addFirst(2);
		myLinkedList.addFirst(1);
		myLinkedList.addLast(4);
		myLinkedList.addLast(5);
		myLinkedList.add(2, 3);
		myLinkedList.add(0, 0);
		
		System.out.println(myLinkedList);
		
		myLinkedList.removeFirst();
		myLinkedList.removeLast();
		myLinkedList.remove(1);
		myLinkedList.remove(0);
		
		System.out.println(myLinkedList);
		
		myLinkedList.addLast(5);
		myLinkedList.addLast(3);
		
		System.out.println(myLinkedList);
		
		System.out.println(myLinkedList.getFirst());
		System.out.println(myLinkedList.getLast());
		System.out.println(myLinkedList.get(1));

		System.out.println(myLinkedList.indexOf(4));
		System.out.println(myLinkedList.lastIndexOf(3));
	}
}


