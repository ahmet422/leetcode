public class Solution {
    public boolean hasCycle(ListNode head) {
        while (head != null && head.next != null) {
            if (head.next == head) {
                return true;
            }
            ListNode nextNode = head.next;
            head.next = head;
            head = nextNode;
        }
        return false;
    }
}
