
public class ListNodeStack {
    ListNode stack;

    void push(int data){
        if(stack == null){
            stack = new ListNode();
            stack.setNumber(data);
        }
        else{
            ListNode nodeToAdd = new ListNode(data);
            stack = stack.add(stack, nodeToAdd, 1);
        }
    }

    int pop() {
        stack = stack.remove(stack, 1);
        if(stack == null){
            System.out.println("Error: Stack has no data");
            throw new IndexOutOfBoundsException();
        }
        return stack.getNumber();
    }

    void printCurrentStack(){
        System.out.println("Current Stack Status");
        ListNode element = stack;
        while(element != null){
            System.out.println(element.getNumber());
            element = element.getNext();
        }
        System.out.println();
    }
}
