public interface StackInterface<T> {
    public void push (T a) throws PushingError;

    public T pop() throws EmptyError;
    public T peek() throws EmptyError;


    public boolean isEmpty();

    public int size();

    public void clear();
}


