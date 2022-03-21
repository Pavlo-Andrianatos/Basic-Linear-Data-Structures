//Provide the implementation for the LinkedList class in this file.

#include "linkedList.h"

using namespace std;

/*
   The constructor initializes an empty list.
 */
template<class T>
LinkedList<T>::LinkedList() {
    head = nullptr;
}

//Returns a clone of this object.

template<class T>
LinkedList<T>& LinkedList<T>::clone() {
    LinkedList<T>* ll;

    Node<T>*nodePtr;
    Node<T>*nodePtrOther;

    nodePtrOther = ll->head;
    nodePtr = head;
    if (nodePtr != nullptr) {
        while (nodePtr != nullptr) {
            if (nodePtrOther == nullptr) {
                Node<T>* newNode = new Node<T>(nodePtr->element, nullptr);

                ll->head = newNode;
                nodePtrOther = ll->head;
            } else {
                Node<T>* newNode = new Node<T>(nodePtr->element, nullptr);

                nodePtrOther->next = newNode;
                nodePtrOther = nodePtrOther->next;
            }

            nodePtr = nodePtr->next;
        }
    }

    return *ll;
}

/*
   The copy constructor.
 */
template<class T>
LinkedList<T>::LinkedList(const LinkedList<T>&other) {
    Node<T>*nodePtr;
    Node<T>*nodePtrOther;

    nodePtrOther = other.head;
    nodePtr = head;
    if (nodePtrOther != nullptr) {
        while (nodePtrOther != nullptr) {
            if (nodePtr == nullptr) {
                Node<T>* newNode = new Node<T>(nodePtrOther.element, nullptr);

                head = newNode;
                nodePtr = head;
            } else {
                Node<T>* newNode = new Node<T>(nodePtrOther.element, nullptr);

                nodePtr->next = newNode;
                nodePtr = nodePtr.next;
            }

            nodePtrOther = nodePtrOther.next;
        }
    }
}

/*
   The overloaded assignment operator.  You will have to replace this
   operator with an appropriate equivalent in your Java code
 */
template<class T>
LinkedList<T>& LinkedList<T>::operator=(const LinkedList<T>&other) {
    Node<T>*nodePtr;
    Node<T>*nodePtrOther;

    nodePtrOther = other.head;
    nodePtr = head;
    if (nodePtr != nullptr) {
        while (nodePtr != nullptr) {
            if (nodePtrOther == nullptr) {
                Node<T>* newNode = new Node<T>(nodePtr.element, nullptr);

                other->head = newNode;
                nodePtrOther = other.head;
            } else {
                Node<T>* newNode = new Node<T>(nodePtr.element, nullptr);

                nodePtrOther->next = newNode;
                nodePtrOther = nodePtrOther.next;
            }

            nodePtr = nodePtr.next;
        }
    }
}

/*
   The destructor.
 */
template<class T>
LinkedList<T>::~LinkedList() {
    if (head != nullptr) {
        Node<T>* nodePtr = head;
        for (int i = 0; i <= size(); i++) {
            head = head->next;
            delete nodePtr;
            nodePtr = head;
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
template<class T>
void LinkedList<T>::insert(int index, T element) {
    Node<T>*nodePtr;
    nodePtr = head;
    Node<T>*newNode = new Node<T>(element);

    if (index >= 0 && index <= size()) {
        if (index == 0 && isEmpty() == true) {
            head = newNode;
            head->next = nullptr;
        } else if (index == size()) {
            if (isEmpty() == true) {
                head = newNode;
                head->next = nullptr;
            } else {
                while (nodePtr->next != nullptr) {
                    nodePtr = nodePtr->next;
                }
                nodePtr->next = newNode;
                newNode->next = nullptr;
            }
        } else if (isEmpty() == true) {
            head = newNode;
            head->next = nullptr;
        } else {
            Node<T>* n = new Node<T>(element, nullptr);
            int i = 0;
            if (i == index && nodePtr->next == nullptr) {
                newNode->next = nodePtr;
                head = newNode;
            } else if (i == index && nodePtr->next != nullptr) {
                newNode->next = nodePtr;
                head = newNode;
            } else {
                while (i != index) {
                    n = nodePtr;
                    nodePtr = nodePtr->next;
                    i++;
                }

                n->next = newNode;
                newNode->next = nodePtr;
            }
        }
    }
}

/*
   Removes and returns the element at the index passed in
   as a parameter.   If an invalid delete is attempted
   throw the string "empty structure".
 */
template<class T>
T LinkedList<T>::remove(int index) {
    T temp;
    Node<T>*nodePtr;
    Node<T>*n;
    nodePtr = head;
    if (index < 0 || index >= size()) {
        throw new RemoveException("empty structure");
    } else {
        Node<T>* n = new Node<T>(0, nullptr);
        if (index == 0) {
            if (isEmpty() == false) {
                if (nodePtr->next != nullptr) {
                    temp = (T) nodePtr->element;
                    head = head->next;
                } else {
                    temp = (T) nodePtr->element;
                    head = nullptr;
                }
            } else {
                throw new RemoveException("empty structure");
            }
        } else if (index == size() - 1) {
            while (nodePtr->next != nullptr) {
                n = nodePtr;
                nodePtr = nodePtr->next;
            }

            temp = (T) nodePtr->element;
            n->next = nullptr;
        } else {
            int i = 0;
            while (i != index) {
                if (nodePtr->next != nullptr) {
                    n = nodePtr;
                    nodePtr = nodePtr->next;
                }
                i++;
            }
            temp = (T) nodePtr->element;
            n->next = nodePtr->next;
        }
    }
    return temp;
}

/*
   Returns true if the list is empty, and false
   otherwise.
 */
template<class T>
bool LinkedList<T>::isEmpty() {
    return head == nullptr;
}

/*
   Removes all of the nodes from the list.  After this function has
   been called on a LinkedList object, the list must be empty.
 */
template<class T>
void LinkedList<T>::clear() {
    if (isEmpty() == false) {
        head = nullptr;
    }
}

/*
   Returns the head, not the element at the head.
 */
template<class T>
Node<T>* LinkedList<T>::getLeader() {
    return head;
}

/*The overloaded stream operator for the List class.  If
                a List object is printed and contains the elements a,c,b and m, with
                element 'a' at index 0 and element 'm' at index 3 (first to last), the 
                output MUST be in the following format:
                [a,c,b,m] with no additional white space.  You will have to replace 
                this operator with a suitable equivalent in your Java implementation.
 */

template<class T>
ostream& LinkedList<T>::print(ostream& os) {
    os << "[";
    if (head == nullptr) {
        os << "]";
    } else {
        Node<T>* nodePtr;
        nodePtr = head;
        for (int i = 0; i < size(); i++) {
            os << nodePtr->element;

            if (i < size() - 1) {
                os << ",";
            }
            nodePtr = nodePtr->next;
        }

        os << "]";
    }

    return os;
}

template<class T>
ostream& operator<<(ostream& os, LinkedList<T>& ll) {
    return ll.print(os);
}

template<class T>
int LinkedList<T>::size() {
    Node<T>* nodePtr;
    nodePtr = head;
    if (head == nullptr) {
        return 0;
    }

    int i = 1;
    while (nodePtr->next != head) {
        nodePtr = nodePtr->next;
        i++;
    }

    return i;
}