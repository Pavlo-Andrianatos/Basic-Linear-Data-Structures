
public class priorityQueue<T extends Comparable<T>> implements orderedContainer<T> {

    node front = null;
    node back = null;

    /*
    The constructor initializes the PriorityQueue with 
    the structure which will contain the elements.
     */
    public priorityQueue(linearStructure c) {
        if (front == null || back == null) {
            back = front = new node((T) c.remove(0), null);
        }
        if (back == front) {
            node newNode = new node((T) c.remove(0), null);
            back = newNode;
            back.next = front;
        }

        linearStructure ls = c.clone();

        int maxIndex = 0;

        while (!ls.isEmpty()) {
            ls.remove(0);
            maxIndex++;
        }

        for (int i = 0; i < maxIndex; i++) {
            node newNode = new node((T) c.remove(0), back);
            back = newNode;
        }
    }

    /*
    Copy constructor
     */
    public priorityQueue(priorityQueue other) {
        if (other != null) {
            priorityQueue q = new priorityQueue(null);
            node nodePtr = other.back;
            node newNode = new node(nodePtr.element, null);
            q.back = q.front = newNode;
            while (nodePtr.next != null) {
                nodePtr = nodePtr.next;

                newNode = new node(nodePtr.element, q.back);
                q.back = newNode;
            }

            nodePtr = q.back;
            newNode = new node(nodePtr.element, null);
            back = front = newNode;
            while (nodePtr.next != null) {
                nodePtr = nodePtr.next;

                newNode = new node(nodePtr.element, back);
                back = newNode;
            }
        }
    }

    /*
    The overloaded assignment operator.  You will have to replace this 
    operator with an appropriate equivalent in your Java code
     */
    @Override
    public priorityQueue clone() {
        priorityQueue pq = new priorityQueue(null);

        node nodePtr;

        nodePtr = back;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (pq.back == null || pq.front == null) {
                    pq.back = pq.front = new node(nodePtr.element, null);
                } else if (pq.back == pq.front) {
                    pq.back = new node(nodePtr.element, pq.front);
                } else {
                    node newNode = new node(nodePtr.element, pq.back);
                    pq.back = newNode;
                }

                nodePtr = nodePtr.next;
            }
        }

        priorityQueue pq2 = new priorityQueue(null);

        nodePtr = pq.back;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (pq2.back == null || pq2.front == null) {
                    pq2.back = pq2.front = new node(nodePtr.element, null);
                } else if (pq2.back == pq2.front) {
                    pq2.back = new node(nodePtr.element, pq2.front);
                } else {
                    node newNode = new node(nodePtr.element, pq2.back);
                    pq2.back = newNode;
                }

                nodePtr = nodePtr.next;
            }
        }
        return pq2;
    }

    /*
    
    This function removes and returns the element
    with the highest priority in the PriorityQueue.
    For this implementation that would be the largest
    element in the queue
     */
    @Override
    public T remove() {
        node nodePtr = back;
        node n = nodePtr;
        T largest = (T) nodePtr.element;
        int compareResult;
        while (nodePtr.next != null) {
            compareResult = n.element.compareTo(nodePtr.element);
            if (compareResult < 0) {
                largest = (T) nodePtr.element;
            }

            n = nodePtr;
            nodePtr = nodePtr.next;
        }

        nodePtr = back;
        n = nodePtr;
        if (largest == nodePtr.element) {
            back = back.next;
        } else {
            while (largest != nodePtr.element) {
                nodePtr = nodePtr.next;
            }
            
            while(n.next != nodePtr){
                n = n.next;
            }
            n.next = nodePtr.next;
        }

        return largest;
    }

    /*
    This function returns, but does NOT remove, the
    element with the higest priority.
     */
    @Override
    public T next() {
        node nodePtr = back;
        node n = nodePtr;
        T largest = (T) nodePtr.element;
        int compareResult;
        while (nodePtr.next != null) {
            compareResult = n.element.compareTo(nodePtr.element);
            if (compareResult < 0) {
                largest = (T) nodePtr.element;
            }

            n = nodePtr;
            nodePtr = nodePtr.next;
        }

        return largest;
    }

    /*
    This function inserts an element in the PriorityQueue.
     */
    @Override
    public void insert(T el) {
        if (front == null || back == null) {
            back = front = new node(el, null);
        } else if (back == front) {
            node newNode = new node(el, null);
            back = newNode;
            back.next = front;
        } else {
            node newNode = new node(el, back);
            back = newNode;
        }
    }

    @Override
    public void OrderedContainer(linearStructure c) {
        priorityQueue priorityQueue = new priorityQueue(c);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void OrderedContainer(orderedContainer other) {
        priorityQueue priorityQueue = new priorityQueue(other);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return back == null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(int index, T element) {
        insert(element);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        return remove();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        back = front = null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String s = "[";
        if (back == null) {
            s += "]";
        } else {
            node nodePtr;
            nodePtr = back;
            while (nodePtr.next != null) {
                s += nodePtr.element;

                s += ",";

                nodePtr = nodePtr.next;
            }
            s += nodePtr.element;
            s += "]";
        }

        return s;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
