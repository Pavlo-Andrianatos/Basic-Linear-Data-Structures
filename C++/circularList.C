//Provide the implementation for the CircularList class in this file.

#include "circularList.h"

using namespace std;

/*
The constructor initializes an empty list.
 */
template<class T>
CircularList<T>::CircularList() {
    tail = nullptr;
}

/*
The copy constructor.
 */
template<class T>
CircularList<T>::CircularList(const CircularList<T>& other) {
    Node<T>*nodePtr;
    Node<T>*nodePtrOther;

    nodePtrOther = other.tail;
    nodePtr = tail;
    if (nodePtrOther != nullptr) {
        while (nodePtrOther.next != other.tail) {
            if (tail == nullptr) {
                Node<T>* newNode = new Node<T>(nodePtrOther.element, nullptr);

                tail = newNode;
                nodePtr = tail;
            } else {
                Node<T>* newNode = new Node<T>(nodePtrOther.element, nullptr);

                nodePtr.next = newNode;
                nodePtr = nodePtr.next;
            }

            nodePtrOther = nodePtrOther.next;
        }
        Node<T>* newNode = new Node<T>(nodePtrOther.element, tail);

        nodePtr.next = newNode;
    }
}

/*
The overloaded assignment operator.  You will have to replace this 
operator with an appropriate equivalent in your Java code
 */
template<class T>
CircularList<T>& CircularList<T>::operator=(const CircularList<T>& other) {
    Node<T>*nodePtr;
    Node<T>*nodePtrOther;

    nodePtrOther = other.tail;
    nodePtr = tail;
    while (nodePtrOther->next != other.tail) {
        if (nodePtr->next == nullptr) {
            //Node<T>*newNode;

            nodePtr->next = nodePtr;
            nodePtr->element = nodePtrOther->element;
        } else {
            nodePtr->element = nodePtrOther->element;
        }

        nodePtr = nodePtr->next;
        nodePtrOther = nodePtrOther->next;
    }
}

//Returns a clone of this object.

template<class T>
CircularList<T>& CircularList<T>::clone() {
    CircularList<T>* cl;

    Node<T>*nodePtr;
    Node<T>*nodePtrOther;

    nodePtrOther = cl->tail;
    nodePtr = tail;
    if (nodePtr != nullptr) {
        while (nodePtr->next != tail) {
            if (nodePtrOther == nullptr) {
                Node<T>* newNode = new Node<T>(nodePtr->element, nullptr);

                cl->tail = newNode;
                cl->tail->next = cl->tail;
                nodePtrOther = cl->tail;
            } else if (nodePtrOther->next == cl->tail) {
                Node<T>* newNode = new Node<T>(nodePtr->element, nullptr);

                nodePtrOther->next = newNode;
                nodePtrOther = nodePtrOther->next;
            } else {
                Node<T>* newNode = new Node<T>(nodePtr->element, nullptr);

                nodePtrOther->next = newNode;
                nodePtrOther = nodePtrOther->next;
            }

            nodePtr = nodePtr->next;
        }
        Node<T>* newNode = new Node<T>(nodePtr->element, cl->tail);

        nodePtrOther->next = newNode;
    }
    return *cl;
}

/*
The destructor.
 */
template<class T>
CircularList<T>::~CircularList() {
    if (tail != nullptr) {
        Node<T>* nodePtr = tail;
        for (int i = 0; i <= size(); i++) {
            tail = tail->next;
            delete nodePtr;
            nodePtr = tail;
        }
    }
}

/*The following holds for this function:
		
1.) It is valid to insert at index 0 into an empty list
		
2.) If the index supplied is the size of the list, then append the element to the back of the list.
		
3.) Any index that is smaller than the size of the list, except for negative numbers, is valid.*/
template<class T>
void CircularList<T>::insert(int index, T element) {
    Node<T>* nodePtr;
    nodePtr = tail;
    Node<T>* newNode = new Node<T>(element);
    if (index >= 0 && index <= size()) {
        if (index == 0 && isEmpty() == true) {
            tail = newNode;
            tail->next = tail;
        } else if (index == size()) {
            if (isEmpty() == true) {
                tail = newNode;
                tail->next = tail;
            } else {
                while (nodePtr->next != tail) {
                    nodePtr = nodePtr->next;
                }
                newNode->next = tail->next;
                tail->next = newNode;
                tail = newNode;
            }
        } else if (isEmpty() == true) {
            tail = newNode;
            tail->next = tail;
        } else {
            Node<T>* n = new Node<T>(element, nullptr);
            int i = 0;
            while (i != index && nodePtr->next == tail) {
                n = nodePtr;
                nodePtr = nodePtr->next;
                i++;
            }

            n->next = newNode;
            newNode->next = nodePtr;
        }
    }
}

/*
Removes and returns the element at the index passed in 
as a parameter.    If an invalid delete is attempted
throw an object of RemoveException with an appropriate message.
 */
template<class T>
T CircularList<T>::remove(int index) {
    T temp;
    Node<T>* nodePtr;
    Node<T>* n = new Node<T>(0, nullptr);
    nodePtr = tail;
    Node<T>* n2 = nodePtr->next;
    if (index < 0 || index > size()) {

        throw new RemoveException("empty structure");

    } else if (index == 0) {
        if (isEmpty() == false) {
            if (nodePtr->next == tail && nodePtr->element != tail->element) {

                temp = (T) nodePtr->element;
                tail->next = tail;
            } else if (nodePtr->next == tail) {

                temp = (T) nodePtr->element;
                tail = nullptr;
            } else {

                temp = (T) nodePtr->element;
                tail->next = n2;
            }

        } else {
            throw new RemoveException("empty structure");
        }
    } else if (index == size()) {
        while (nodePtr->next != tail) {
            n = nodePtr;
            nodePtr = nodePtr->next;
        }

        temp = (T) nodePtr->element;
        tail = n;
    } else {
        int i = 0;
        while (i != index) {
            if (nodePtr->next != tail->next) {
                n = nodePtr;
                nodePtr = nodePtr->next;
            }
            i++;
        }
        if (nodePtr == tail) {
            temp = (T) nodePtr->element;
            n->next = nodePtr->next;
            tail = n;
        } else {
            temp = (T) nodePtr->element;
            n->next = nodePtr->next;
        }
    }
    return temp;
}

/*
Returns true if the list is empty and false otherwise.
 */
template<class T>
bool CircularList<T>::isEmpty() {
    return tail == nullptr;
}

/*
Removes all of the nodes from the list.  After this function has
been called on a CircularList object, the list must be empty.
 */
template<class T>
void CircularList<T>::clear() {
    if (isEmpty() == false) {
        tail = nullptr;
    }
}

/*
Returns the tail, not the element at the tail.
 */
template<class T>
Node<T>* CircularList<T>::getLeader() {
    return tail;
}

/*
The overloaded stream operator.  This function should return a string representation of the list.  Elements should be comma separated and appear between square brackets.  If the list contains the elements x, y, and z, then the string returned should be [x,y,z] with no additional whitespace.
 */
template<class T>
ostream& operator<<(ostream& os, CircularList<T>& cl) {
    return cl.print(os);
}

template<class T>
ostream& CircularList<T>::print(ostream& os) {
    os << "[";
    if (tail == nullptr) {
        os << "]";
    } else {
        Node<T>* nodePtr;
        nodePtr = tail;
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
int CircularList<T>::size() {
    Node<T>* nodePtr;
    nodePtr = tail;
    if (tail == nullptr) {
        return 0;
    }

    int i = 1;
    while (nodePtr->next != tail) {
        nodePtr = nodePtr->next;
        i++;
    }

    return i;
}