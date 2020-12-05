import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
        for(int i=0 ; i<9 ; i++){
            queue.enqueue(i+1);
        }
        queue.printCurrentQueue();
    }

    @Test
    void testPut() {
        assertDoesNotThrow(() -> queue.enqueue(10));
        assertThrows(BufferOverflowException.class, () -> queue.enqueue(12));
    }

    @Test
    void testGet() {
        for(int i = 0 ; i<9 ; i++){
            assertDoesNotThrow(() -> queue.dequeue());
        }
        assertThrows(BufferUnderflowException.class, () -> queue.dequeue());
    }
}