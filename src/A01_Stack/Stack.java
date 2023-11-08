package A01_Stack;

public class Stack<T> {

    private Node<T> first;
    private int count;

    /**
     * Oberstes Element entfernen und zur�ckliefern.
     * Existiert kein Element, wird eine Exception ausgel�st.
     * @throws StackEmptyException
     */
    public T pop() throws StackEmptyException {
        if (first == null) {
            throw new StackEmptyException();
        }

        T topData = first.getData();
        first = first.getNext();
        count--;

        return topData;
    }

    /**
     * �bergebenen T auf Stack (als oberstes Element) speichern.
     * @param data
     */
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(first);
        first = newNode;
        count++;
    }

    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
        return count;
    }
}
