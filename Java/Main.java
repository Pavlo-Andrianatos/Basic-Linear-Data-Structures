/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavlo
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Linked List");
        linkedList ll = new linkedList();
        ll.insert(0,0);
        ll.insert(1,1);
        ll.insert(2,2);
        ll.insert(3,3);
        //ll.insert(100, 100);
        //ll.remove(0);
        //ll.remove(100);
        //ll.remove(-1);
        //ll.clear();
        //System.out.println(ll.getLeader());
        //linkedList ll2 = ll.clone();
        //linkedList ll2 = new linkedList(ll);
        System.out.println(ll.toString());
        
        System.out.println("Dynamic Array");
        dynamicArray da = new dynamicArray(4);
        da.insert(0,0);
        da.insert(1,1);
        da.insert(2,2);
        da.insert(3,3);
        //da.insert(100,100);
        //da.remove(0);
        //da.remove(-1);
        //da.remove(100);
        //da.clear();
        //dynamicArray da2 = da.clone();
        //dynamicArray da2 = new dynamicArray(da);
        System.out.println(da.toString());
        
        System.out.println("Circular List");
        circularList cl = new circularList();
        cl.insert(0,0);
        cl.insert(1,1);
        cl.insert(2,2);
        cl.insert(3,3);
        //cl.insert(100,100);
        //cl.remove(0);
        //cl.remove(-1);
        //cl.remove(100);
        //cl.clear();
        //System.out.println(cl.getLeader());
        //circularList cl2 = cl.clone();
        //circularList cl2 = new circularList(cl);
        System.out.println(cl.toString());
        
        System.out.println("Queue");
        queue q = new queue(ll);
        //q.insert(4);
        //q.insert(5);
        //q.insert(6);
        //q.insert(7);
        //q.remove(0);
        //q.remove(0);
        //System.out.println(q.next());
        //queue q2 = q.clone();
        //queue q2 = new queue(q);
        System.out.println(q.toString());
        
        linkedList ll2 = new linkedList();
        ll2.insert(0,0);
        ll2.insert(1,1);
        ll2.insert(2,2);
        ll2.insert(3,3);
        
        System.out.println("Stack");
        stack s = new stack(ll2);
        //s.insert(0);
        //s.insert(1);
        //s.insert(2);
        //s.insert(3);
        //s.remove();
        //System.out.println(s.next());
        //stack s2 = s.clone();
        //stack s2 = new stack(s);
        System.out.println(s.toString());
        
        linkedList ll3 = new linkedList();
        ll3.insert(0,0);
        ll3.insert(1,1);
        ll3.insert(2,2);
        ll3.insert(3,3);
        
        System.out.println("PriorityQueue");
        priorityQueue pq = new priorityQueue(ll3);
        //pq.insert(0);
        //pq.insert(1);
        //pq.insert(2);
        //pq.insert(3);
        //System.out.println(pq.remove());
        //System.out.println(pq.next());
        //priorityQueue pq2 = pq.clone();
        //priorityQueue pq2 = new priorityQueue(pq);
        System.out.println(pq.toString());
    }
}