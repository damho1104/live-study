import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

// Circular Queue
public class Queue {
    private int[] queue;
    private final int queueSize = 11;
    private int head;
    private int tail;

    public Queue(){

        queue = new int[queueSize];
        head = tail = 0;
    }

    boolean isEmpty(){
        return head == tail;
    }

    boolean isFull(){
        return (tail+1) % queueSize == head;
    }

    void enqueue(int data){
        if(isFull()){
            System.out.println("Error: Queue is full");
            throw new BufferOverflowException();
        }
        queue[tail = (tail + 1) % queueSize] = data;
    }

    int dequeue(){
        if(isEmpty()){
            System.out.println("Error: Queue has no data");
            throw new BufferUnderflowException();
        }
        return queue[head = (head + 1) % queueSize];
    }

    void printCurrentQueue(){
        System.out.println("Current Queue Status");
        int currentIndex = head;
        while(true){
            if(currentIndex == 10){
                currentIndex = 0;
            }
            System.out.println(queue[currentIndex++]);
            if(currentIndex == tail){
                break;
            }
        }
        System.out.println("head: " + Integer.toString(head));
        System.out.println("tail: " + Integer.toString(tail));
        System.out.println();
    }
}
