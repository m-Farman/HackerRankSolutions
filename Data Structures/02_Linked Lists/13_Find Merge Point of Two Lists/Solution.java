/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
   
    HashMap<Node, Integer> list=new HashMap<>();
    while(headA.next!=null){
        list.put(headA.next,1);
        headA=headA.next;
    }

    while(headB != null){
        if(list.containsKey(headB))
            return headB.data;
        headB=headB.next;
    }
    
    return 0;
}
