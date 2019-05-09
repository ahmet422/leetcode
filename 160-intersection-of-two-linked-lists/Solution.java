/*-*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA, currB = headB;
        int lenA = getLength(headA), lenB = getLength(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; ++i, currA = currA.next);
        } else if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; ++i, currB = currB.next);
        }
        for (; currA != currB; currA = currA.next, currB = currB.next);
        return currA;
    }

    public int getLength(ListNode head) {
        int len = 0;
        for (ListNode curr = head; curr != null; len++, curr = curr.next);
        return len;
    }
}
