/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
int GetNode(Node head,int n) {
  	Node tmpNode=head;
    
    for(int i=1;i <= n;i++){
        tmpNode=tmpNode.next;
    }

    while(tmpNode.next !=null){
        head=head.next;
        tmpNode=tmpNode.next;
    }
    
    return head.data;
}
