import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    ListNode linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new ListNode(1);
        for(int i = 2 ; i<=10 ; i++) {
            ListNode element = new ListNode(i);
            linkedList.add(linkedList, element, i);
        }
        linkedList.printLinkedList();
    }

    @AfterEach
    void tearDown(){
        linkedList.removeAll();
    }

    @Test
    void testGetListNode() {
        ListNode element = linkedList.getListNode(linkedList, 9);
        assertNotNull(element);
        assertEquals(element.getNumber(), 9);

        element = linkedList.getListNode(linkedList, 4);
        assertNotNull(element);
        assertEquals(element.getNumber(), 4);
    }

    @Test
    void testAdd() {
        for(int i = 11 ; i < 20 ; i++) {
            ListNode element = new ListNode(i);
            element.add(linkedList, element, i);
            assertEquals(linkedList.getListNode(linkedList, i).getNumber(), i);
        }
    }

    @Test
    void testRemove() {
        ListNode elementFirst = linkedList.getListNode(linkedList, 8);
        linkedList.remove(linkedList, 8);
        ListNode elementSecond = linkedList.getListNode(linkedList, 8);
        assertNotEquals(elementFirst.getNumber(), elementSecond.getNumber());
        linkedList.printLinkedList();
        assertNull(linkedList.remove(linkedList, 20));
    }

    @Test
    void testContains() {
        ListNode element = new ListNode(8);
        assertTrue(linkedList.contains(linkedList, element));
        element = new ListNode(12);
        assertFalse(linkedList.contains(linkedList, element));
    }
}