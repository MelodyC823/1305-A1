public interface ListInterface<T> {
    public void add (T a) throws PushingError;

    public void add (int position, T a) throws PushingError;

    public void remove(int position) throws EmptyError;
    public T peek() throws EmptyError;

    public boolean isEmpty();

    public int size();

    public Object get();

    public void clear();
}
