package A03_DoubleLinkedList;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;

    public void add(T a) {
        Node<T> newNode = new Node<>(a);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    public void reset() {
        current = head;
    }

    public void resetToLast() {
        current = tail;
    }

    public Node<T> getFirst() {
        return head;
    }

    public Node<T> getLast() {
        return tail;
    }

    public T next() {
        if (current == null) return null;
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    public T previous() {
        if (current == null) return null;
        T data = current.getData();
        current = current.getPrevious();
        return data;
    }

    public void moveNext() {
        if (current != null) {
            current = current.getNext();
        }
    }

    public void movePrevious() {
        if (current != null) {
            current = current.getPrevious();
        }
    }

    public T getCurrent() throws CurrentNotSetException {
        if (current == null) throw new CurrentNotSetException();
        return current.getData();
    }

    public T get(int pos) {
        Node<T> temp = head;
        for (int i = 1; temp != null && i < pos; i++) {
            temp = temp.getNext();
        }
        return temp == null ? null : temp.getData();
    }

    public void remove(int pos) {
        Node<T> temp = head;
        for (int i = 1; temp != null && i < pos; i++) {
            temp = temp.getNext();
        }
        if (temp == null) return;
        if (temp.getPrevious() != null) {
            temp.getPrevious().setNext(temp.getNext());
        } else {
            head = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.getNext().setPrevious(temp.getPrevious());
        } else {
            tail = temp.getPrevious();
        }
        if (current == temp) current = null;
    }

    public void removeCurrent() throws CurrentNotSetException {
        if (current == null) throw new CurrentNotSetException();
        removeCurrentHelper();
    }

    private void removeCurrentHelper() {
        if (current.getPrevious() != null) {
            current.getPrevious().setNext(current.getNext());
        } else {
            head = current.getNext();
        }
        if (current.getNext() != null) {
            current.getNext().setPrevious(current.getPrevious());
            current = current.getNext();
        } else {
            tail = current.getPrevious();
            current = tail;
        }
    }

    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {
        if (current == null) throw new CurrentNotSetException();
        Node<T> newNode = new Node<>(a);
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        if (current.getNext() != null) {
            current.getNext().setPrevious(newNode);
        } else {
            tail = newNode;
        }
        current.setNext(newNode);
        current = newNode;
    }
}
