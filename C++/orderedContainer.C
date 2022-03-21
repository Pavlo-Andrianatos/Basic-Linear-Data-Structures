//Provide the implementation for the OrderedQueue class in this file.

#include "orderedContainer.h"

using namespace std;

/*
		The constructor initializes the Container
		with the structure passed in as a parameter.
		You will have to make a copy of the LinearStructure
		as parties outside of this class may have pointers
		to it still.
		The elements added to the container must be
		stored in the object to which dataStructure
		points.
		*/
		template<class T>
		OrderedContainer<T>::OrderedContainer(LinearStructure<T>* c){
			dataStructure = c;
			cout << "HERERERE";
		}		
		/*
		Copy constructor
		*/
		template<class T>
		OrderedContainer<T>::OrderedContainer(const OrderedContainer<T>& other){
			dataStructure = &other.dataStructure->clone();
		}
		
		/*
		The overloaded assignment operator.  You will have to replace this 
		operator with an appropriate equivalent in your Java code
		*/
		template<class T>
		OrderedContainer<T>& OrderedContainer<T>::operator=(const OrderedContainer<T>& other){
			dataStructure = other.dataStructure;
		}
		
		template <class T>
		OrderedContainer<T>::~OrderedContainer()
		{
			delete dataStructure;
		}
		
		/*
		Returns true if the container is empty, and false
		if the container contains elements.
		*/
		template<class T>
		bool OrderedContainer<T>::isEmpty(){
			return this == nullptr;
		}
		
		/*
		Returns a pointer to the linear structure in which the elements
		are contained.
		*/
		template<class T>
		LinearStructure<T>* OrderedContainer<T>::getImplementation(){
			return dataStructure;
		}
