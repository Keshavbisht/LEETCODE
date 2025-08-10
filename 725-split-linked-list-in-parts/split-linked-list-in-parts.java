class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int n = 0;
        ListNode temp = head;

        
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int baseSize = n / k;
        int extra = n % k;

        temp = head;
        for (int i = 0; i < k; i++) {
            ans[i] = temp;
            int size = baseSize;
            if (i < extra) {
                size++;
            }

            
            for (int j = 0; j < size - 1 && temp != null; j++) {
                temp = temp.next;
            }

            if (temp != null) {
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }
        }
        return ans;
    }
}
