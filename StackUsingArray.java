public class StackUsingArray<T> implements StackInterface<T> {
    T[] arr;

    public StackUsingArray(){
        Object arr1 = new Object[5];
        arr = (T[])arr1;

    }
    int top = -1;
    int size = 0;

    public void push (T a) throws PushingError{
        if(size == 5){
            throw new PushingError("the limit of stack has been reached.");
        }
        top++;
        arr[top] = a;
        size++;

    }

    public T pop() throws EmptyError{
        if(size == 0){
            throw new EmptyError("The stack is empty.");
        }
        else{
            T temp = arr[top];
            top--;
            size--;
            return temp;
        }
    }
    public T peek() throws EmptyError{
        if(size == 0){
            throw new EmptyError("The stack is empty.");
        }
        return arr[top];

    }


    public boolean isEmpty(){
        return (top < 0);

    }

    public int size(){
        return size;

    }

    public void clear(){
        top = -1;
        size = 0;
    }

    public static void main(String[] args) {
        StackUsingArray<Integer> stack = new StackUsingArray<Integer>();
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
