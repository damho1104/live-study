import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    private ListNodeStack stack;

    @BeforeEach
    void setUp() {
        stack = new ListNodeStack();
        for(int i=0 ; i<10 ; i++){
            stack.push(i);
        }
        stack.printCurrentStack();
    }

    @Test
    void testPush() {
        assertDoesNotThrow(() -> {
            for(int i = 10 ; i < 50 ; i++){
                stack.push(i+1);
            }
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