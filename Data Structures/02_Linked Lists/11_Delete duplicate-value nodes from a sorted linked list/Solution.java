/*
Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

Node RemoveDuplicates(Node head) {
  
    if(head == null)
        return head;
    
    Node tmp=head,node=head;
    while(tmp != null){
     
        if(node.data != tmp.data){
           node.next=tmp;
           node=tmp;
        }
       tmp=tmp.next;
    }
    node.next=null;
    
    return head;
}
