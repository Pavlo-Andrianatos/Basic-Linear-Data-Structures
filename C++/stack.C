//Provide the implementation for the Stack class in this file.

#include "stack.h"

using namespace std;

template<class T>
Stack<T>::Stack(LinearStructure<T>* c) : OrderedContainer<T>(c){
        cout << "QQQQQQQQQQQQQQQQQQQQQ";

    }

    /*
		Copy constructor
     */
template<class T>
Stack<T>::Stack(const Stack<T>& other) : OrderedContainer<T>(other){
        
    }

    /*
		Overloaded assignment operator.
     */
template<class T>
Stack<T>& Stack<T>::operator=(const Stack<T>& other){
        return new Stack<T>(other);
    }

    /*
		This function pops and returns the element 
		on the top of the Stack.
     */
template<class T>
Stack<T>::~Stack(){
    delete this->dataStructure;
}

template<class T>
T Stack<T>::remove() {
        this->dataStructure->remove(0);
    }

    /*
		This function returns, but does NOT remove, the
		element at the top of the stack.
     */
template<class T>
T Stack<T>::next() {
        T returnThis = this->dataStructure->remove(0);
	this->dataStructure->insert(0, returnThis);
	return returnThis;
    }

    /*
		This function pushes the element sent in as a 
		parameter onto the top of the Stack.
     */
template<class T>
void Stack<T>::insert(T el) {
        this->dataStructure->insert((0), el);
    }
