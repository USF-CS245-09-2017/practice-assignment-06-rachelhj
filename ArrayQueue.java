
import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T>{
    private static int DEFAULT_SIZE = 10;
    
    int size = 0;
    int head;
    int tail;
    Object[] tempArray = new Object[DEFAULT_SIZE];
    T[] arr = (T[]) tempArray;
    @Override
    public T dequeue(){
        if(empty()){
            throw new RuntimeException();
        }  
	T temp = arr[head];
	head = (head+1)%arr.length;
        size--;
	return temp;
    }
    @Override
    public void enqueue(T item){
        if((tail+1)%arr.length == head){
            grow_array();
        }
	    arr[tail++] = item; 
        size++;
	    tail = tail % arr.length;
    }
    @Override
    public boolean empty(){
        return head == tail;
    }
    protected void grow_array(){	
        size = arr.length*2;
        Object[] tempArray = new Object[size];
        T[] temp = (T[]) tempArray; 
        int tmpHead = head;
        int index = -1;
        while(tmpHead != tail){
            temp[++index] = arr[tmpHead];
            tmpHead++;
            if(tmpHead == arr.length){
                tmpHead = 0;
            }
        }
        arr = temp;
        head = 0;
        tail = index + 1;        
    }
}

