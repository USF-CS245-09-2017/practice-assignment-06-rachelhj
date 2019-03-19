
public class ArrayStack<T> implements Stack<T> {
    int size = 10;
    Object[] tempArray = new Object[size];
    T[] arr = (T[]) tempArray;
    int top=-1;
    
    @Override
    public void push(T item){
        if(top==arr.length-1){
            grow_array();
        }
	   arr[++top] = item;
    }
    @Override
    public T pop(){
        if(empty()){
            throw new NullPointerException();
	    }
	    else{
            return arr[top--];
	    }
    }
    @Override
    public T peek(){
        if(empty()){
            throw new NullPointerException();
        }
	    else{
            return arr[top];
	    }
    }
    @Override
    public boolean empty(){
        return top == -1;
    }
    protected void grow_array(){	
        Object[] tempArray = new Object[arr.length*2];
        T[] temp = (T[]) tempArray;    
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        arr=temp;

    }   
}
