
public class Node {
	private int datum;
	private Node next;

	public Node(int datum) {
		this(datum, null);
	}

	public Node(int datum, Node next) {
		this.datum = datum;
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node n) {
		this.next = n;
	}

	public int getDatum() {
		return this.datum;
	}
}