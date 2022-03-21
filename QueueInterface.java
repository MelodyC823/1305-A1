public interface QueueInterface<T> {

    public void insert (T a) throws PushingError;

    public T remove() throws EmptyError;
    public T peek() throws EmptyError;

    public boolean isEmpty();

    public int size();

    public void clear();
}
