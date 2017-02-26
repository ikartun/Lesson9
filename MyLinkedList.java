package by.epam.tr.lesson9;

import java.util.NoSuchElementException;

public class MyLinkedList<E>  {
	private int size;
	private Node<E> first;
	private Node<E> last;
	
	public MyLinkedList() {
	}
	
	public void addFirst(E e) {
		linkFirst(e);
	}
	
	public void addLast(E e) {
        linkLast(e);
    }
	
	public void add(int index, E element) {
        if (!(index >= 0 && index <= size)) {
			throw new IndexOutOfBoundsException();
		}

        if (index == size)
            linkLast(element);
        else
            linkBeforeAfter(element, node(index - 1), node(index));
    }
	
	public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
	
	public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }
	
	public E remove(int index) {
		if (!(index >= 0 && index < size)) {
			throw new IndexOutOfBoundsException();
		}
		
        return unlink(node(index - 1), node(index));
    }
	
	public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }
	
	public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }
	
	public E get(int index) {
		if (!(index >= 0 && index < size)) {
			throw new IndexOutOfBoundsException();
		}
        return node(index).item;
    }
	
	public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
	
	public int lastIndexOf(Object o) {
		int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null && !isExistNextIndexOf(x.next, o))
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item) && !isExistNextIndexOf(x.next, o))
                    return index;
                index++;
            }
        }
        return -1;
    }
	
	/**
     * Returns true if exists the next occurrence of the specified element
     */
	private boolean isExistNextIndexOf(Node<E> node, Object o) {
		if (o == null) {
            for (Node<E> x = node; x != null; x = x.next) {
                if (x.item == null)
                    return true;
            }
        } else {
            for (Node<E> x = node; x != null; x = x.next) {
                if (o.equals(x.item))
                    return true;
            }
        }
        return false;
	}
	
	/**
     * Returns the (non-null) Node at the specified element index.
     */
	private Node<E> node(int index) {
		if (index == -1) {			
			return null;
		}
        Node<E> x = first;
           
        for (int i = 0; i < index; i++) {        	
            x = x.next;
        }           
        return x;
    }
	
	/**
     * Inserts element e after non-null Node bef and before non-null Node succ.
     */
	private void linkBeforeAfter(E e, Node<E> bef, Node<E> succ) {
        final Node<E> newNode = new Node<>(e, succ);
        
        if (succ == first)
            first = newNode;
        else
            bef.next = newNode;
        size++;
    }

	/**
     * Links e as first element.
     */
	private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, f);
        first = newNode;
        
        if (f == null)
            last = newNode;
        
        size++;
    }
	
	 /**
     * Links e as last element.
     */
	private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null);
        last = newNode;
        
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        
        size++;
    }
	
	/**
     * Unlinks non-null first node f.
     */
	private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        
        if (next == null)
            last = null;
        
        size--;
        return element;
    }
	
	/**
     * Unlinks non-null last node l.
     */
	private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = node(size - 2);
        l.item = null;
        last = prev;
        
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }
	
	/**
     * Unlinks non-null node x.
     */
    private E unlink(Node<E> prev, Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }
	
	private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

		@Override
		public String toString() {
			return "Node [item=" + item + ", next=" + next + "]";
		}
    }

	@Override
	public String toString() {
		return "MyLinkedList [size=" + size + ", first=" + first + ", last=" + last + "]";
	}
}

