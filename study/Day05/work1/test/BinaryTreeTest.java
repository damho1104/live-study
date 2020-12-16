import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
    }

    @Test
    void insertTest() {
        for(int i=1 ; i<=10 ; i++) {
            int value = (int)(Math.random() *(10*i));
            System.out.println(value);
            assertDoesNotThrow(() ->{
                tree.insert(value);
            });
        }
    }

    @Test
    void bfsTest() {
        tree.insert(10);
        tree.insert(2);
        tree.insert(420);
        tree.insert(1);
        tree.insert(12);
        tree.insert(89);
        tree.insert(42);
        tree.insert(6);
        tree.insert(36);

        tree.bfs(tree.getRoot());
        assertEquals(tree.getTraverseResult(), "10 2 420 1 6 12 89 42 36 ");
    }

    @Test
    void dfsTest() {
        tree.insert(10);
        tree.insert(2);
        tree.insert(420);
        tree.insert(1);
        tree.insert(12);
        tree.insert(89);
        tree.insert(42);
        tree.insert(6);
        tree.insert(36);

        tree.dfs(tree.getRoot());
        assertEquals(tree.getTraverseResult(), "1 2 6 10 12 36 42 89 420 ");
    }
}