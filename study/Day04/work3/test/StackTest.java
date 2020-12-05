import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
        for(int i=0 ; i<10 ; i++) {
            stack.push(i+1);
        }
    }

    @Test
    void testPush() {
        //stack 범위 초과 시도
        assertDoesNotThrow(() -> {
            for(int i=10 ; i<50 ; i++) stack.push(i+1);
        });
        stack.printCurrentStack();
    }

    @Test
    void testPop() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            while(true){
                int data = stack.pop();
                System.out.println(data);
            }
        });
        stack.printCurrentStack();
    }
}