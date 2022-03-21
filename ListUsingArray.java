public abstract class ListUsingArray<T> implements ListInterface<T> {
    int size;
    T[] arr;
    int index;
    public ListUsingArray(){
        index = -1;
        size = 0;
        Object arr1 = new Object[6];
        arr = (T[])arr1;
    }

    public void add (T a) throws PushingError{
        if(isEmpty()){
            index = 0;
        }
        if(size == 5){
            throw new PushingError("The limit of array has been reached.");
        }
        index++;
        arr[index] = a;
        size++;
    }

    public void add (int position, T a) throws PushingError{
        if(isEmpty()){
            index = 0;
        }
        if(size == 5){
            throw new PushingError("The limit of array has been reached.");
        }
        if(position < index) {
            for (int i = index; i >= position; i--) {
                arr[i + 1] = arr[i];
            }
        }

        arr[position] = a;
        index++;
        size++;
    }

    public void remove(int position) throws EmptyError{
        if(isEmpty()){
            throw new EmptyError("The array is empty.");
        }
        if(position < index) {
            for (int i = position ; i < index; i++) {
                arr[i] = arr[i + 1];
            }
        }
        index--;
        size--;
    }
    public T peek() throws EmptyError{
        if(isEmpty()){
            throw new EmptyError("The array is empty.");
        }
        return arr[index];
    }


    public boolean isEmpty(){
        if(index == -1 || size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public Object get (int position) {
        return arr[position];
    }


    public void clear(){
        size = 0;
        index = -1;
    }

    public static void main(String[] args) {
        ListUsingArray<Integer> list = new ListUsingArray<Integer>() {
            @Override
            public Object get() {
                return null;
            }
        };
        try{
            list.add(1);
            list.add(2);
            list.add(3);                       // add 1,2,3 to the array, the peek is 3
            System.out.println(list.peek());
            list.remove(2);            // remove the position 2
            System.out.println(list.peek());   //the peek is 3
            System.out.println(list.size());   // size is 2
            list.clear();
            System.out.println(list.size());    // after clear, size return 0

            list.add(1);                       // add 1,2,3
            list.add(2);
            list.add(3);
            System.out.println(list.peek());
            list.add(2,4);                 // insert 4 to position 2
            System.out.println(list.get(2));
            System.out.println(list.size());          //size is 4

            list.add(5);        //adding over the collection's capacity resulting an exception
//            list.add(6);
//


            list.remove(1);
            list.remove(2);
            list.remove(3);
            list.remove(4);
            list.remove(5);
            System.out.println(list.peek());  //remove 5 items, exception raised.



        }catch (PushingError e){
            System.out.println(e.getMessage());
        }catch (EmptyError e){
            System.out.println(e.getMessage());
        }
    }
}
