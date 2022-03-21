
import java.util.logging.Level;
import java.util.logging.Logger;

//Provide the implementation for the linkedList class in this file.
public class linkedList<T extends Comparable<T>> implements linearStructure<T> {

    /*
   The constructor initializes an empty list.
     */
    node head;

    public linkedList() {
        head = null;
    }

//Returns a clone of this object.
    @Override
    public linkedList clone() {
        linkedList ll = new linkedList();

        node nodePtr;
        node nodePtrOther;

        nodePtrOther = ll.head;
        nodePtr = head;
        if (nodePtr != null) {
            while (nodePtr != null) {
                if (nodePtrOther == null) {
                    node newNode = new node(nodePtr.element, null);

                    ll.head = newNode;
                    nodePtrOther = ll.head;
                } else {
                    node newNode = new node(nodePtr.element, null);

                    nodePtrOther.next = newNode;
                    nodePtrOther = nodePtrOther.next;
                }

                nodePtr = nodePtr.next;
            }
        }
        return ll;
    }

    /*
   The copy constructor.
     */
    public linkedList(linkedList other) {
        node nodePtr;
        node nodePtrOther;

        nodePtrOther = other.head;
        nodePtr = head;
        if (nodePtrOther != null) {
            while (nodePtrOther != null) {
                if (nodePtr == null) {
                    node newNode = new node(nodePtrOther.element, null);

                    head = newNode;
                    nodePtr = head;
                } else {
                    node newNode = new node(nodePtrOther.element, null);

                    nodePtr.next = newNode;
                    nodePtr = nodePtr.next;
                }

                nodePtrOther = nodePtrOther.next;
            }
        }
    }

    /*
   Inserts an element at the given index.  The following holds
   for this function:

   1.) It is valid to insert at index 0 of an empty list.

   2.) It is valid to insert at the index returned by size().  Simply
    append the element to the back of the list.

   3.) Only indices between 0 and size() are valid.
     */
    @Override
    public void insert(int index, T element) {
        node nodePtr;
        nodePtr = head;
        node newNode = new node(element, null);
        if (index >= 0 && index <= size()) {
            if (index == 0 && isEmpty() == true) {
                head = newNode;
                head.next = null;
            } else if (index == size()) {
                if (isEmpty() == true) {
                    head = newNode;
                    head.next = null;
                } else {
                    while (nodePtr.next != null) {
                        nodePtr = nodePtr.next;
                    }
                    nodePtr.next = newNode;
                    newNode.next = null;
                }
            } else if (isEmpty() == true) {
                head = newNode;
                head.next = null;
            } else {
                node n = new node(element, null);
                int i = 0;
                if (i == index && nodePtr.next == null) {
                    newNode.next = nodePtr;
                    head = newNode;
                } else if (i == index && nodePtr.next != null) {
                    newNode.next = nodePtr;
                    head = newNode;
                } else {
                    while (i != index) {
                        n = nodePtr;
                        nodePtr = nodePtr.next;
                        i++;
                    }

                    n.next = newNode;
                    newNode.next = nodePtr;
                }
            }
        }
    }

    /*
   Removes and returns the element at the index passed in
   as a parameter.   If an invalid delete is attempted
   throw the string "empty structure".
     */
    @Override
    public T remove(int index) {
        T temp = null;
        node nodePtr = head;
        if (index < 0 || index >= size()) {
            try {
                throw new RemoveException("empty structure");
            } catch (RemoveException ex) {
                Logger.getLogger(linkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            node n = new node(0, null);
            if (index == 0) {
                if (isEmpty() == false) {
                    if (nodePtr.next != null) {
                        temp = (T) nodePtr.element;
                        head = head.next;
                    } else {
                        temp = (T) nodePtr.element;
                        head = null;
                    }
                } else {
                    try {
                        throw new RemoveException("empty structure");
                    } catch (RemoveException ex) {
                        Logger.getLogger(linkedList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (index == size() - 1) {
                while (nodePtr.next != null) {
                    n = nodePtr;
                    nodePtr = nodePtr.next;
                }

                temp = (T) nodePtr.element;
                n.next = null;
            } else {
                int i = 0;
                while (i != index) {
                    if (nodePtr.next != null) {
                        n = nodePtr;
                        nodePtr = nodePtr.next;
                    }
                    i++;
                }
                temp = (T) nodePtr.element;
                n.next = nodePtr.next;
            }
        }
        return temp;
    }

    /*
   Returns true if the list is empty, and false
   otherwise.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /*
   Removes all of the nodes from the list.  After this function has
   been called on a linkedList object, the list must be empty.
     */
    @Override
    public void clear() {
        if (isEmpty() == false) {
            head = null;
        }
    }

    /*
   Returns the head, not the element at the head.
     */
    node getLeader() {
        return head;
    }

    /*The overloaded stream operator for the List class.  If
                a List object is printed and contains the elements a,c,b and m, with
                element 'a' at index 0 and element 'm' at index 3 (first to last), the 
                output MUST be in the following format:
                [a,c,b,m] with no additional white space.  You will have to replace 
                this operator with a suitable equivalent in your Java implementation.
     */
    @Override
    public String toString() {
        String s = "[";
        if (head == null) {
            s += "]";
        } else {
            node nodePtr;
            nodePtr = head;
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
        nodePtr = head;
        if (head == null) {
            return 0;
        }

        int i = 1;
        while (nodePtr.next != null) {
            nodePtr = nodePtr.next;
            i++;
        }

        return i;
    }
}
