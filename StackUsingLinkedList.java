public class StackUsingLinkedList<T> implements StackInterface<T> {
    NodeGeneric<T> top;

    public StackUsingLinkedList() {
        top = null;
    }

    int size = 0;

    public void push(T a) throws PushingError {
        if (size == 5)
            throw new PushingError("the limit of stack has been reached");
        NodeGeneric<T> temp = new NodeGeneric<T>();
        temp.data = a;
        temp.next = null;

        // check whether the stack is empty or not
        if (top == null) {
            top = temp;
        } else {
            // the stack is not empty
            temp.next = top;
            top = temp;
        }
        size++;
    }

    public T pop() throws EmptyError {
        if (size == 0)
            throw new EmptyError("The stack is empty.");
        T temp = (T) top.data;
        top = top.next;

        size--;
        return temp;
    }

    public T peek() throws EmptyError {
        if(isEmpty()){
            throw new EmptyError("The stack is empty.");
        }
        return (T) top.data;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        return size;

    }

    public void clear(){
        top = null;
        size = 0;

    }

    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();
        try{
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println(stack.peek()); //AFTER PUSHING 1,2,3, THE PEEK IS 3.
            stack.pop();
            stack.pop();
            System.out.println(stack.peek()); //POP TWICE, THE TOP IS 1.

            stack.push(4);
            stack.push(5);
            stack.push(6);
            stack.push(7);
//            stack.push(8);
//            System.out.println(stack.peek());  //adding over the collection's capacity resulting an exception

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();                      // ADD 5,REMOVE 5, EXCEPTION RAISED.
            System.out.println(stack.peek()); //EXCEPTION RAISED IN AN EMPTY ARRAY.


        }catch (PushingError e){
            System.out.println(e.getMessage());
        }catch (EmptyError e){
            System.out.println(e.getMessage());
        }
    }

}

