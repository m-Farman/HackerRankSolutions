/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    

Node InsertNth(Node head, int data, int position) {
	Node node=new Node();
    node.data=data;
    node.next=null;
    
    if(head==null){
        return node;
    }
    if(position==0){
        node.next=head;
        return node;
    }
   
    Node temp=head;
    for(int i=1; i < position; i++){
        temp=temp.next;
    }
    node.next=temp.next;
    temp.next=node;
    
    return head;
}
