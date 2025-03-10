package solutions.task_2095;

/**
 * 2095. Delete the Middle Node of a Linked List
 * You are given the head of a linked list. Delete the middle node, and return the head
 * of the modified linked list.
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start
 * using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode last = head.next;
        ListNode middle = head;
        while (last.next != null && last.next.next != null) {
            middle = middle.next;
            last = last.next.next;
        }
        middle.next = middle.next.next;
        return head;
    }
}