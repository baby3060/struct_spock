package struct.struct.common;

public class Node {
    private Object value;
    private Node next;

    public Node() {}

    public Node(Object value) {
        this.value = value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return "value is " + value;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null ) {
            return false;
        }

        if( obj instanceof Node ) {
            if( obj == this ) {
                return true;
            }

            if( obj.equals(this.value) ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 31 + this.value.hashCode();
    }
}