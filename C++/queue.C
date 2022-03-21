//Provide the implementation for the Queue class in this file.

#include "queue.h"

using namespace std;

/*
    The constructor initializes the queue with 
    the structure which will contain the elements.
 */
template<class T>
Queue<T>::Queue(LinearStructure<T>* c) : OrderedContainer<T>(c){
    
}

/*
Copy constructor
 */
template<class T>
Queue<T>::Queue(const Queue<T>& other) : OrderedContainer<T>(other){

}

/*
The overloaded assignment operator.  You will have to replace this 
operator with an appropriate equivalent in your Java code
 */
template<class T>
Queue<T>& Queue<T>::operator=(const Queue<T>& other) {
    this->dataStructure = &other.queue->dataStructure->clone();
}

template<class T>
Queue<T>::~Queue() {
	delete this->dataStructure;
}

/*
This function removes and returns the element
at the front of the queue.
 */
template<class T>
T Queue<T>::remove() {
    return this->dataStructure->remove(0);
}

/*
This function returns, but does NOT remove, the
element at the front of the queue.
 */
template<class T>
T Queue<T>::next() {
    int count = 0;
	

	LinearStructure<T>* clone = &(this->dataStructure->clone());

	while(clone->isEmpty())
	{
		count++;
		clone->remove(0);
	}
	T el = this->dataStructure->remove((count-1));
	this->dataStructure->insert(count-1,el);
	return el;
}

/*
This function places the element sent in as a 
parameter at the back of the queue.
 */
template<class T>
void Queue<T>::insert(T el) {
    int count = 0;
	

	LinearStructure<T>* clone = &(this->dataStructure->clone());

	while(!(clone->isEmpty()))
	{
		count++;
		clone->remove(0);
	}
	this->dataStructure->insert((count-1), el);
}
