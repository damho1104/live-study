public class Stack {
    private int[] stackData;
    private int stackSize;
    private final int incrementSize = 10;
    private int currentIndex;

    public Stack(){
        stackSize = incrementSize;
        stackData = new int[stackSize];
        currentIndex = 0;
    }

    void push(int data){
        if(currentIndex == stackSize-1){
            reAllocStack();
        }
        stackData[currentIndex++] = data;
    }

    int pop()
    {
        if(currentIndex == 0){
            System.out.println("Error: Stack has no data");
            return -1;
        }
        return stackData[--currentIndex];
    }

    void reAllocStack(){
        int[] previousStack = stackData;
        stackSize += incrementSize;
        stackData = new int[stackSize];

        for(int i=0 ; i<stackSize-incrementSize ; i++){
            stackData[i] = previousStack[i];
        }
    }

    void printCurrentStack(){
        System.out.println("Current Stack Status");
        if(currentIndex == 0){
            System.out.println("No Data\n");
            return;
        }
        for(int inx=currentIndex-1 ; inx>=0 ; inx--){
            System.out.println(stackData[inx]);
        }
        System.out.println("");
    }
}
