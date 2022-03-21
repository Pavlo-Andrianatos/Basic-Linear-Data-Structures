//Provide the implementation for the PriorityQueue class in this file.

#include "priorityQueue.h"

using namespace std;

template<class T>
PriorityQueue<T>::PriorityQueue(LinearStructure<T>* c) : OrderedContainer<T>(c){
        
    }

    /*
    Copy constructor
     */
template<class T>
PriorityQueue<T>::PriorityQueue(const PriorityQueue<T>& other) : OrderedContainer<T>(other){
        
    }

    /*
    The overloaded assignment operator.  You will have to replace this 
    operator with an appropriate equivalent in your Java code
     */
template<class T>
PriorityQueue<T>& PriorityQueue<T>::operator=(const PriorityQueue<T>& other){
        PriorityQueue<T> * p = new PriorityQueue<T>(other);
	return *p;
    }

template<class T>
PriorityQueue<T>::~PriorityQueue(){
    delete this->dataStructure;
}

    /*
    
    This function removes and returns the element
    with the highest priority in the PriorityQueue.
    For this implementation that would be the largest
    element in the queue
     */
template<class T>
T PriorityQueue<T>::remove() {
        T highest;
	PriorityQueue<T> p = *this;
	int count = 0;
	if(!(p.dataStructure->isEmpty()))
		highest = p.dataStructure->remove(0);
	
	while(!(p.dataStructure->isEmpty()))
	{
		T  temp = p.dataStructure->remove(0);
		if(temp > highest)
		{
			
			highest = temp;
			count++;
		}
	}
	
	this->dataStructure->remove(count);
	
	return highest;
    }

    /*
    This function returns, but does NOT remove, the
    element with the higest priority.
     */
template<class T>
T PriorityQueue<T>::next() {
        T highest;
	PriorityQueue<T> p = *this;
	if(!(p.dataStructure->isEmpty()))
		highest = p.dataStructure->remove(0);
	
	while(!(p.dataStructure->isEmpty()))
	{
		T  temp = p.dataStructure->remove(0);
		if(temp > highest)
		{
			
			highest = temp;
		}
	}
	
	
	return highest;
    }

    /*
    This function inserts an element in the PriorityQueue.
     */
template<class T>
void PriorityQueue<T>::insert(T el) {
        this->dataStructure->insert((0), el);
    }
