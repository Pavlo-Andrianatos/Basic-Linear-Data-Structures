
public class stack<T extends Comparable<T>> implements orderedContainer<T> {

    node top = null;

    /*
		The constructor initializes the stack with 
		the structure which will contain the elements.
     */
    public stack(linearStructure c) {
        if (top == null) {
            top = new node((T) c.remove(0), null);
        }
        if (top.next == null) {
            node newNode = new node((T) c.remove(0), top);
            top = newNode;
        }

        linearStructure ls = c.clone();

        int maxIndex = 0;

        while (!ls.isEmpty()) {
            ls.remove(0);
            maxIndex++;
        }

        for (int i = 0; i < maxIndex; i++) {
            node newNode = new node((T) c.remove(0), top);
            top = newNode;
        }

    }

    /*
		Copy constructor
     */
    public stack(stack other) {
        if (other != null) {
            stack s = new stack(null);
            node nodePtr = other.top;
            node newNode = new node(nodePtr.element, null);
            s.top = newNode;
            while (nodePtr.next != null) {
                nodePtr = nodePtr.next;

                newNode = new node(nodePtr.element, s.top);
                s.top = newNode;
            }

            nodePtr = s.top;
            newNode = new node(nodePtr.element, null);
            top = newNode;
            while (nodePtr.next != null) {
                nodePtr = nodePtr.next;

                newNode = new node(nodePtr.element, top);
                top = newNode;
            }
        }
    }

    /*
		Overloaded assignment operator.
     */
    @Override
    public stack clone() {
        stack s = new stack(null);

        node nodePtr;

        nodePtr = top;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (s.top == null) {
                    s.top = new node(nodePtr.element, null);
                } else if (s.top.next == null) {
                    s.top = new node(nodePtr.element, s.top);
                } else {
                    node newNode = new node(nodePtr.element, s.top);
                    s.top = newNode;
                }

                nodePtr = nodePtr.next;
            }
        }

        stack s2 = new stack(null);

        nodePtr = s.top;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (s2.top == null) {
                    s2.top = new node(nodePtr.element, null);
                } else if (s2.top.next == null) {
                    s2.top = new node(nodePtr.element, s2.top);
                } else {
                    node newNode = new node(nodePtr.element, s2.top);
                    s2.top = newNode;
                }

                nodePtr = nodePtr.next;
            }
        }
        return s2;
    }

    /*
		This function pops and returns the element 
		on the top of the Stack.
     */
    @Override
    public T remove() {
        T temp = (T) top.element;

        top = top.next;

        return temp;
    }

    /*
		This function returns, but does NOT remove, the
		element at the top of the stack.
     */
    @Override
    public T next() {
        return (T) top.element;
    }

    /*
		This function pushes the element sent in as a 
		parameter onto the top of the Stack.
     */
    @Override
    public void insert(T el) {
        if (top == null) {
            top = new node(el, null);
        } else {
            node newNode = new node(el, top);
            top = newNode;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        if (top == null) {
            s += "]";
        } else {
            node nodePtr;
            nodePtr = top;
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
        stack stack = new stack(c);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void OrderedContainer(orderedContainer other) {
        stack stack = new stack(other);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return top == null;
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
        top = null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
