
public class queue<T extends Comparable<T>> implements orderedContainer<T> {

    node front = null;
    node back = null;

    /*
    The constructor initializes the queue with 
    the structure which will contain the elements.
     */
    public queue(linearStructure c) {
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
    public queue(queue other) {
        if (other != null) {
            queue q = new queue(null);
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
    public queue clone() {
        queue q = new queue(null);

        node nodePtr;

        nodePtr = back;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (q.back == null || q.front == null) {
                    q.back = q.front = new node(nodePtr.element, null);
                } else if (q.back == q.front) {
                    q.back = new node(nodePtr.element, q.front);
                } else {
                    node newNode = new node(nodePtr.element, q.back);
                    q.back = newNode;
                }

                nodePtr = nodePtr.next;
            }
        }

        queue q2 = new queue(null);

        nodePtr = q.back;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (q2.back == null || q2.front == null) {
                    q2.back = q2.front = new node(nodePtr.element, null);
                } else if (q2.back == q2.front) {
                    q2.back = new node(nodePtr.element, q2.front);
                } else {
                    node newNode = new node(nodePtr.element, q2.back);
                    q2.back = newNode;
                }

                nodePtr = nodePtr.next;
            }
        }
        return q2;
    }

    /*
    This function removes and returns the element
    at the front of the queue.
     */
    @Override
    public T remove() {
        node nodePtr = back;

        while (nodePtr.next != front) {
            nodePtr = nodePtr.next;
        }
        T temp = (T) front.element;

        nodePtr.next = null;
        front = nodePtr;

        return temp;
    }

    /*
    This function returns, but does NOT remove, the
    element at the front of the queue.
     */
    @Override
    public T next() {
        return (T) front.element;
    }

    /*
    This function places the element sent in as a 
    parameter at the back of the queue.
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

    @Override
    public void OrderedContainer(linearStructure c) {
        queue queue = new queue(c);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void OrderedContainer(orderedContainer other) {
        queue queue = new queue(other);
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
}
