public class ListUsingLinkedList<T> implements ListInterface<T> {
    NodeGeneric<T> first;
    NodeGeneric<T> last;
    int size;

    public ListUsingLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(T a) throws PushingError {
        NodeGeneric<T> temp = new NodeGeneric<T>();
        temp.data = a;
        temp.next = null;
        if (size == 5) {
            throw new PushingError("The limit of list has been reached.");
        }
        if (isEmpty()) {
            this.first = this.last = temp;
        } else {
            last.next = temp;
            last = temp;
        }
        size++;
    }

    public void add(int position, T a) throws PushingError {
        if (size == 5) {
            throw new PushingError("The limit of list has been reached.");
        }
        NodeGeneric<T> temp = new NodeGeneric<T>();
        temp.data = a;
//        temp.next = null;

        NodeGeneric<T> y = first;
        NodeGeneric<T> x = first.next;

        while (position - 2 > 0) {
            y = x;
            x = y.next;

            position--;
        }
        temp.next = x;
        y.next = temp;

        size++;
    }

    public void remove(int position) throws EmptyError {
        if (isEmpty()) {
            throw new EmptyError("The list is empty.");
        }

        NodeGeneric<T> temp;

        NodeGeneric<T> y = first;
        NodeGeneric<T> x = first.next;

        while (position - 2 > 0) {
            y = x;
            x = y.next;

            position--;
        }
        temp = x.next;
        y.next = temp;

        size--;
    }

    public T peek() throws EmptyError {
        if (isEmpty()) {
            throw new EmptyError("The array is empty.");
        }
        return last.data;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Object get() {
        return null;
    }


    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public static void main(String[] args) {
        ListUsingLinkedList<Integer> list = new ListUsingLinkedList<>();
        try {
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list.peek());  // add 1,2,3 to the list, the peek is 3
            list.remove(2);    // remove the position 2
            System.out.println(list.peek());   //the peek is 3
            System.out.println(list.size());   // size is 2

            list.clear();
            System.out.println(list.size());    // after clear, size return 0

            list.add(1);                       // add 1,2,3
            list.add(2);
            list.add(3);
            System.out.println(list.peek());
            list.add(2, 4);                 // insert 4 to position 2
            System.out.println(list.size());          //size is 4

            list.add(5);        //adding over the collection's capacity resulting an exception
//            list.add(6);

            list.remove(1);
            list.remove(2);
            list.remove(3);
            list.remove(4);
            list.remove(5);
            System.out.println(list.peek());  //remove 5 items, exception raised.


        } catch (PushingError e) {
            System.out.println(e.getMessage());
        } catch (EmptyError e) {
            System.out.println(e.getMessage());
        }
    }
};

