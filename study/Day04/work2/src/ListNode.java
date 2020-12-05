public class ListNode {
    private int number;
    private ListNode next;

    public ListNode(){
        number = -1;
        next = null;
    }

    public ListNode(int _number){
        setNumber(_number);
        next = null;
    }

    public ListNode getListNode(ListNode head, int position){
        int originalPosition = position;
        ListNode currentNode = head;
        while(--position > 0){
            if(currentNode == null){
                System.out.printf("Error: Cannot find this position(Out of range, position: %d)\n", originalPosition);
                return null;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position){
        if(position <= 0){
            System.out.println("Error: 'position' variable should have the value more than 0.");
            return null;
        }
        if(position == 1){
            nodeToAdd.setNext(head);
        }
        else {
            ListNode previousNode = getListNode(head, position - 1);
            if(previousNode == null){
                return null;
            }
            ListNode nextNode = getListNode(head, position);

            nodeToAdd.setNext(nextNode);
            previousNode.setNext(nodeToAdd);
        }
        return nodeToAdd;
    }

    public ListNode remove(ListNode head, int positionToRemove){
        if(positionToRemove <= 0) {
            System.out.println("Error: 'positionToRemove' variable should have the value more than 0.");
            return null;
        }
        if(positionToRemove == 1){
            return head.getNext();
        }
        else {
            ListNode previousRemoveNode = getListNode(head, positionToRemove - 1);
            if(previousRemoveNode == null){
                return null;
            }
            ListNode removeNode = getListNode(head, positionToRemove);
            if(removeNode == null){
                return null;
            }

            previousRemoveNode.setNext(removeNode.getNext());
            return previousRemoveNode;
        }
    }

    public void removeAll(){
        this.setNext(null);
    }

    public boolean contains(ListNode head, ListNode nodeTocheck){
        ListNode currentNode = head;
        int position = 1;
        while(currentNode != null){
            if(currentNode.getNumber() == nodeTocheck.getNumber()){
                return true;
            }
            else{
                currentNode = getListNode(head, ++position);
            }
        }
        return false;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int _number){
        number = _number;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode _next){
        next = _next;
    }

    public void printLinkedList(){
        ListNode current = this;
        while(current != null){
            System.out.print(current.getNumber());
            current = current.getNext();
            if(current != null){
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
