/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {

    HashSet<Node> detect= new HashSet<Node>();
    
    while(head != null){
        if(!detect.add(head)){
            return true;
        }
        
        head=head.next;
    }
    return false;
}
