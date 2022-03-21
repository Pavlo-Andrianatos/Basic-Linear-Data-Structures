//Provide the implementation for the DynamicArray class in this file.

#include "dynamicArray.h"

using namespace std;

/*
 The constructor accepts the initial size of the array.
 All elements in the array are initialized to null.
 */
template<class T>
DynamicArray<T>::DynamicArray(int s) {
    if (s > 0) {
        size = s;

        elements = new T*[size];

        for (int i = 0; i < size; i++) {
            elements[i] = NULL;
        }

        numElements = size;
    }
}

/*
The copy constructor.
 */
template<class T>
DynamicArray<T>::DynamicArray(const DynamicArray<T>& other) {
    size = other.size;

    elements = new T*[size];

    for (int i = 0; i < size; i++) {
        elements[i] = NULL;
    }

    numElements = size;

    for (int i = 0; i < other.size; i++) {
        elements[i] = other.elements[i];
    }
}

//Returns a clone of this object.

template<class T>
DynamicArray<T>& DynamicArray<T>::clone() {
    DynamicArray<T> da(size);

    for (int i = 0; i < da.size; i++) {
        da.elements[i] = elements[i];
    }

    return da;
}

/*
The overloaded assignment operator.
 */
template<class T>
DynamicArray<T>& DynamicArray<T>::operator=(const DynamicArray<T>& other) {
    resize(other.size);

    elements = new T*[size];

    for (int i = 0; i < size; i++) {
        elements[i] = NULL;
    }

    numElements = size;

    for (int i = 0; i < other.size; i++) {
        if (other.elements[i] != NULL) {
            elements[i] = other.elements[i];
        } else {
            elements[i] = NULL;
        }
    }
}

/*
The destructor.
 */
template<class T>
DynamicArray<T>::~DynamicArray() {
    for (int i = 0; i < size; i++)
	{
		delete elements[i];
	}
	
	delete [] elements;
}

/*
Inserts an element at the given index in the array.  If
the index is larger than the size of the array, grow
the array to accomodate the index.
 */
template<class T>
void DynamicArray<T>::insert(int index, T element) {
    if (index >= 0) {
        if (index >= size) {
            resize(index + 1);
            numElements = index;
            elements[index] = new T(element);
        } else {
            if (elements[index] != NULL) {
                resize(size + 1);

                for (int i = size - 1; i >= index; i--) {
                    elements[i] = elements[i - 1];
                }

                elements[index] = new T(element);
                numElements++;
            } else {
                elements[index] = new T(element);
            }
        }
    }
}

/*
Removes and returns the element at the index passed in 
as a parameter.  All elements from the removed index onwards
are shifted one position forward.  If an element is null,
throw an object of RemoveException with an appropriate message.
 */
template<class T>
T DynamicArray<T>::remove(int index) {
    if(index == 0 || index == 1)
		index = 0;
	if(elements[index] == nullptr || index > size-1)
	{
		throw new RemoveException("empty structure");
	}
	else
	{
		
		delete elements[index];
		for (int i = index; i < size-1; i++)
		{
			elements[i] = elements[i+1];
		}
		elements[size-1] = nullptr;
		numElements--;
	}
}

/*
Returns true if the array contains no elements and 
false otherwise.
 */
template <class T>
bool DynamicArray<T>::isEmpty() {
    bool allNull = true;

    for (int i = 0; i < size; i++) {
        if (elements[i] != NULL) {
            allNull = false;
        }
    }

    return allNull;
}

/*
Removes all of the elements from the array.  After this function has
been called on a DynamicArray object, the the array must be empty (i.e. all elements in the array must be null).  The array's current
size remains unchanged.
 */
template <class T>
void DynamicArray<T>::clear() {
    for (int i = 0; i < size; i++) {
        elements[i] = NULL;
    }
}

/*
Use this function to resize the array.
 */
template <class T>
void DynamicArray<T>::resize(int howMuch) {
    DynamicArray<T> da = this->clone();

    size = howMuch;

    elements = new T*[size];
    for (int i = 0; i < size; i++) {
        elements[i] = NULL;
    }

    for (int i = 0; i < da.size; i++) {
        elements[i] = da.elements[i];
    }
}

/*The overloaded stream operator for the DynamicArray class.  If
a the array object is printed and contains the elements a,c,b and m,
with element 'a' at index 0 and element 'm' at index 3 (first to last),
the 
output MUST be in the following format:
[a,c,b,m]
with no additional white space.
		
It is possible that some of the elements might be null.  If this is the
case then the null elements should be indicated with asterisks.
If the array contains the elements a and m,
with element 'a' at index 0 and element 'm' at index 3 (first to last),
the 
output MUST be in the following format:
[a,*,*,m]
 */
template <class T>
ostream& operator<<(ostream& os, DynamicArray<T>& da) {
    return da.print(os);
}

template <class T>
ostream& DynamicArray<T>::print(ostream& os) {
    os << "[";
    for (int i = 0; i < size; i++) {
        if (elements[i] != NULL) {
            os << *elements[i];
        } else {
            os << "*";
        }

        if (i < size - 1) {
            os << ",";
        }
    }

    os << "]";

    return os;
}