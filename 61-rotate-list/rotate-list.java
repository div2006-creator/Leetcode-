class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int n = 1;

        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        temp.next = head;
        k = k % n;

        int steps = n - k;

        while (steps > 0) {
            temp = temp.next;
            steps--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}