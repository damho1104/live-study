import java.nio.BufferUnderflowException;

public class ListNodeQueue {
    private ListNode head;
    private ListNode tail;

    public ListNodeQueue(){
        head = tail = null;
    }

    public boolean isEmpty()
    {
        return head == tail;
    }

    public void enqueue(int data){
        if(isEmpty()){
            head = tail = new ListNode(data);
            tail = new ListNode();
            head.setNext(tail);
        }
        else{
            tail.setNumber(data);
            tail.setNext(new ListNode());
            tail = tail.getNext();
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Error: Queue is empty");
            throw new BufferUnderflowException();
        }
        int returnValue = head.getNumber();
        head = head.getNext();
        return returnValue;
    }

    public void printCurrentQueue(){
        System.out.println("Current Queue Status");
        ListNode element = head;
        while(element != null){
            if(element.isDataInserted() == false){
                break;
            }
            System.out.println(element.getNumber());
            element = element.getNext();
        }
        System.out.println();
    }
}
