/*-*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode newNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNext;
        }
        return prev;
    }
}
