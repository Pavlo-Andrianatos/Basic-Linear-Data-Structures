
import java.util.logging.Level;
import java.util.logging.Logger;

//Provide the implementation for the circularList class in this file.
public class circularList<T extends Comparable<T>> implements linearStructure<T> {

    /*
The constructor initializes an empty list.
     */
    node tail;

    public circularList() {
        tail = null;
    }

    /*
The copy constructor.
     */
    public circularList(circularList other) {
        node nodePtr;
        node nodePtrOther;

        nodePtrOther = other.tail;
        nodePtr = tail;
        if (nodePtrOther != null) {
            while (nodePtrOther.next != other.tail) {
                if (tail == null) {
                    node newNode = new node(nodePtrOther.element, null);

                    tail = newNode;
                    nodePtr = tail;
                } else {
                    node newNode = new node(nodePtrOther.element, null);

                    nodePtr.next = newNode;
                    nodePtr = nodePtr.next;
                }

                nodePtrOther = nodePtrOther.next;
            }
            node newNode = new node(nodePtrOther.element, tail);

            nodePtr.next = newNode;
        }
    }

//Returns a clone of this object.
    @Override
    public circularList clone() {
        circularList cl = new circularList();

        node nodePtr;
        node nodePtrOther;

        nodePtrOther = cl.tail;
        nodePtr = tail;
        if (nodePtr != null) {
            while (nodePtr.next != tail) {
                if (nodePtrOther == null) {
                    node newNode = new node(nodePtr.element, null);

                    cl.tail = newNode;
                    cl.tail.next = cl.tail;
                    nodePtrOther = cl.tail;
                } else if (nodePtrOther.next == cl.tail) {
                    node newNode = new node(nodePtr.element, null);

                    nodePtrOther.next = newNode;
                    nodePtrOther = nodePtrOther.next;
                } else {
                    node newNode = new node(nodePtr.element, null);

                    nodePtrOther.next = newNode;
                    nodePtrOther = nodePtrOther.next;
                }

                nodePtr = nodePtr.next;
            }
            node newNode = new node(nodePtr.element, cl.tail);

            nodePtrOther.next = newNode;
        }
        return cl;
    }

    /*The following holds for this function:
		
1.) It is valid to insert at index 0 into an empty list
		
2.) If the index supplied is the size of the list, then append the element to the back of the list.
		
3.) Any index that is smaller than the size of the list, except for negative numbers, is valid.*/
    @Override
    public void insert(int index, T element) {
        node nodePtr;
        nodePtr = tail;
        node newNode = new node(element, null);
        if (index >= 0 && index <= size()) {
            if (index == 0 && isEmpty() == true) {
                tail = newNode;
                tail.next = tail;
            } else if (index == size()) {
                if (isEmpty() == true) {
                    tail = newNode;
                    tail.next = tail;
                } else {
                    while (nodePtr.next != tail) {
                        nodePtr = nodePtr.next;
                    }
                    newNode.next = tail.next;
                    tail.next = newNode;
                    tail = newNode;
                }
            } else if (isEmpty() == true) {
                tail = newNode;
                tail.next = tail;
            } else {
                node n = new node(element, null);
                int i = 0;
                while (i != index && nodePtr.next == tail) {
                    n = nodePtr;
                    nodePtr = nodePtr.next;
                    i++;
                }

                n.next = newNode;
                newNode.next = nodePtr;
            }
        }
    }

    /*
Removes and returns the element at the index passed in 
as a parameter.    If an invalid delete is attempted
throw an object of RemoveException with an appropriate message.
     */
    @Override
    public T remove(int index) {
        node nodePtr;
        node n = new node(0, null);

        nodePtr = tail.next;

        node n2 = nodePtr.next;
        T temp = null;
        if (index < 0 || index > size()) {
            try {
                throw new RemoveException("empty structure");
            } catch (RemoveException ex) {
                Logger.getLogger(circularList.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (index == 0) {
            if (isEmpty() == false) {
                if (nodePtr.next == tail && nodePtr.element != tail.element) {

                    temp = (T) nodePtr.element;
                    tail.next = tail;
                } else if (nodePtr.next == tail) {

                    temp = (T) nodePtr.element;
                    tail = null;
                } else {

                    temp = (T) nodePtr.element;
                    tail.next = n2;
                }

            } else {
                try {
                    throw new RemoveException("empty structure");
                } catch (RemoveException ex) {
                    Logger.getLogger(circularList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (index == size()) {
            while (nodePtr.next != tail) {
                n = nodePtr;
                nodePtr = nodePtr.next;
            }

            temp = (T) nodePtr.element;
            tail = n;
        } else {
            int i = 0;
            while (i != index) {
                if (nodePtr.next != tail.next) {
                    n = nodePtr;
                    nodePtr = nodePtr.next;
                }
                i++;
            }
            if (nodePtr == tail) {
                temp = (T) nodePtr.element;
                n.next = nodePtr.next;
                tail = n;
            } else {
                temp = (T) nodePtr.element;
                n.next = nodePtr.next;
            }
        }
        return temp;
    }

    /*
Returns true if the list is empty and false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    /*
Removes all of the nodes from the list.  After this function has
been called on a circularList object, the list must be empty.
     */
    @Override
    public void clear() {
        if (isEmpty() == false) {
            tail = null;
        }
    }

    /*
Returns the tail, not the element at the tail.
     */
    node getLeader() {
        return tail;
    }

    /*
The overloaded stream operator.  This function should return a string representation of the list.  Elements should be comma separated and appear between square brackets.  If the list contains the elements x, y, and z, then the string returned should be [x,y,z] with no additional whitespace.
     */
    @Override
    public String toString() {
        String s = "[";
        if (tail == null) {
            s += "]";
        } else {
            node nodePtr;
            nodePtr = tail.next;
            for (int i = 0; i < size(); i++) {
                s += nodePtr.element;

                if (i < size() - 1) {
                    s += ",";
                }
                nodePtr = nodePtr.next;
            }

            s += "]";
        }

        return s;
    }

    public int size() {
        node nodePtr;
        if (tail == null) {
            return 0;
        }
        nodePtr = tail;
        int i = 1;
        while (nodePtr.next != tail) {
            nodePtr = nodePtr.next;
            i++;
        }
        return i;
    }
}
