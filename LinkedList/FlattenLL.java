
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

    class GfG {
   
        // Merges two linked lists in a particular
        // order based on the data value
        public static Node merge(Node list1, Node list2) {
            // Create a dummy node as a
            // placeholder for the result
            Node dummyNode = new Node(-1);
            Node res = dummyNode;
    
            // Merge the lists based on data values
            while (list1 != null && list2 != null) {
                if (list1.data < list2.data) {
                    res.bottom = list1;
                    res = list1;
                    list1 = list1.bottom;
                } else {
                    res.bottom = list2;
                    res = list2;
                    list2 = list2.bottom;
                }
                res.next = null;
            }
    
            
            if (list1 != null) {
                res.bottom = list1;
            } else {
                res.bottom = list2;
            }
    
           
            return dummyNode.bottom;
        }
    
        // Flattens a linked list with child pointers
        public static Node flatten(Node head) {
            // If head is null or there
            // is no next node, return head
            if (head == null || head.next == null) {
                return head;
            }
    
            
            Node mergedHead = flatten(head.next);
            head = merge(head, mergedHead);
            return head;
        }
    
        
    }