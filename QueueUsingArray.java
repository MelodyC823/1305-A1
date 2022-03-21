public class QueueUsingArray<T> implements QueueInterface<T> {
    int front;
    int rear;
    int size;
    T arr[];
    public QueueUsingArray(){
        Object arr1 = new Object[6];
        arr = (T[]) arr1;
        size = 0;
        front = -1;
        rear = -1;
    }

    public void insert (T a) throws PushingError{
        if(isEmpty()){
            front = 0;
            rear = 0;
        } if(size == 5){
            throw new PushingError("The limit of queue has reached.");
        }   arr[rear] = a;
            rear++;
            size++;
    }

    public T remove() throws EmptyError{
        if(isEmpty()){
            throw new EmptyError("The queue is empty.");
        }else{
            T temp = arr[front];
            front++;
            size--;
            return temp;
        }
    }
    public T peek() throws EmptyError{
        if(isEmpty() || arr[front] == null){
            throw new EmptyError("The queue is empty.");
        }
        return arr[front];
    }


    public boolean isEmpty(){
        if (front == -1){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void clear(){
        front = -1;
        rear = -1;
        size = 0;
    }

    public static void main(String[] args) {
        QueueUsingArray<Integer> queue = new QueueUsingArray<Integer>();
        try{
            queue.insert(1);
            queue.insert(2);
            queue.insert(3);
            System.out.println(queue.peek()); //Inserting 1,2,3, peek is 1.
            queue.remove();
            queue.remove();
            System.out.println(queue.peek()); // serving twice the front should 3
            System.out.println(queue.size());  //size is 1.

            queue.insert(4);
            queue.insert(5);
            queue.insert(6);
            queue.insert(7);
            queue.insert(8);              //adding over the collection's capacity resulting an exception
//            System.out.println(queue.peek());

//           queue.remove();
//           queue.remove();
//           queue.remove();
//           queue.remove();
//           queue.remove();
//           System.out.println(queue.peek());     //remove 5, should get an empty queue, raise the exception



        }catch (PushingError e){
            System.out.println(e.getMessage());
        }catch (EmptyError e){
            System.out.println(e.getMessage());
        }

    }
}
