
public class QueueUsingLinkedList<T> implements QueueInterface<T> {
    NodeGeneric<T> front;
    NodeGeneric<T> rear;
    int size;
    public QueueUsingLinkedList(){
        
        front = null;
        rear = null;
        size = 0;
    }
    public void insert (T a) throws PushingError{
        NodeGeneric<T> temp = new NodeGeneric<T>();
        temp.data = a;
        temp.next = null;
        if(isEmpty()){
            this.rear = this.front = temp;
        }
        if(size == 5){
            throw new PushingError("The limit of queue has reached.");

        } this.rear.next = temp;
          this.rear = temp;
          size++;
    }

    public T remove() throws EmptyError{
        if(isEmpty()) {
            throw new EmptyError("The queue is empty.");
        }

        NodeGeneric<T> temp = new NodeGeneric<T>();
        temp = this.front;
        this.front = front.next;
        size--;
        return temp.data;
    }

    public T peek() throws EmptyError{
        if(isEmpty()){
            throw new EmptyError("The queue is empty.");
        }
        return front.data;
    }


    public boolean isEmpty(){
        if(front == null ){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }


    public void clear(){
        front = null;
        rear = null;
        size = 0;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<Integer>();
        try{
            //in Queue, after inserting A,B, C. And serving twice the front should C
            queue.insert(1);
            queue.insert(2);
            queue.insert(3);
            System.out.println(queue.peek());    //Inserting 1,2,3, peek is 1.
            queue.remove();
            queue.remove();
            System.out.println(queue.peek());    // serving twice the front should 3
            System.out.println(queue.size());

            queue.insert(4);
            queue.insert(5);
            queue.insert(6);
            queue.insert(7);
//            queue.insert(4);     //adding over the collection's capacity resulting an exception


           queue.remove();
           queue.remove();
           queue.remove();
           queue.remove();
           queue.remove();
           queue.peek();           //remove 5, should get an empty queue, raise the exception



        }catch (PushingError e){
            System.out.println(e.getMessage());
        }catch (EmptyError e){
            System.out.println(e.getMessage());
        }
    }
}
