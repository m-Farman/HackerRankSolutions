/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
Node Reverse(Node head) {
    
    if(head == null)
        return head;
    
    Node prev,next,current;
    current=head;
    prev=null;
    next=head.next;
    
    while(current.next != null){
        current.next=prev;
        prev=current;
        current=next;
        next=next.next;
    }
    
    current.next=prev;
    
    return current;
    
}
