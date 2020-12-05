import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.BufferUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

    private ListNodeQueue queue;

    @BeforeEach
    void setUp() {
        queue = new ListNodeQueue();
        for(int i=0 ; i<10 ; i++){
            queue.enqueue(i+1);
        }
    }

    @Test
    void enqueue() {
        assertDoesNotThrow(() -> {
            for(int i=10 ; i<100 ; i++){
                queue.enqueue(i+1);
            }
        });
    }

    @Test
    void dequeue() {
        assertDoesNotThrow(() -> {
            for(int i=0 ; i<10 ; i++){
                queue.dequeue();
            }
        });
        assertThrows(BufferUnderflowException.class, () -> queue.dequeue());
    }
}