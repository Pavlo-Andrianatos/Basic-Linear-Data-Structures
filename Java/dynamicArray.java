
import java.util.logging.Level;
import java.util.logging.Logger;

//Provide the implementation for the dynamicArray class in this file.
public class dynamicArray<T extends Comparable<T>> implements linearStructure<T> {

    /*
 The constructor accepts the initial size of the array.
 All elements in the array are initialized to null.
     */
    int size;
    T[] elements;
    int numElements;

    public dynamicArray(int s) {
        if (s > 0) {
            size = s;

            elements = (T[]) new Comparable[size];

            for (int i = 0; i < size; i++) {
                elements[i] = null;
            }

            numElements = size;
        }
    }

    /*
The copy constructor.
     */
    public dynamicArray(dynamicArray other) {
        size = other.size;

        elements = (T[]) new Comparable[size];

        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        numElements = size;

        for (int i = 0; i < other.size; i++) {
            elements[i] = (T) other.elements[i];
        }
    }

//Returns a clone of this object.
    @Override
    public dynamicArray clone() {
        dynamicArray da = new dynamicArray(size);

        for (int i = 0; i < da.size; i++) {
            da.elements[i] = elements[i];
        }

        return da;
    }

    /*
Inserts an element at the given index in the array.  If
the index is larger than the size of the array, grow
the array to accomodate the index.
     */
    @Override
    public void insert(int index, T element) {
        if (index >= 0) {
            if (index >= size) {
                resize(index + 1);
                numElements = index;
                elements[index] = element;
            } else if (elements[index] != null) {
                resize(size + 1);

                for (int i = size - 1; i >= index; i--) {
                    elements[i] = elements[i - 1];
                }

                elements[index] = element;
                numElements++;
            } else {
                elements[index] = element;
            }
        }
    }

    /*
Removes and returns the element at the index passed in 
as a parameter.  All elements from the removed index onwards
are shifted one position forward.  If an element is null,
throw an object of RemoveException with an appropriate message.
     */
    @Override
    public T remove(int index) {
        if (index >= 0 && index <= size) {
            T temp = elements[index];
            if (elements[index] != null) {
                for (int i = index; i < size; i++) {
                    if (i + 1 == size) {
                        elements[i] = null;
                    } else {
                        elements[i] = elements[i + 1];
                    }
                }

                size--;
                elements = elements.clone();
            } else {
                try {
                    throw new RemoveException("empty structure");
                } catch (RemoveException ex) {
                    Logger.getLogger(dynamicArray.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return temp;
        } else {
            try {
                throw new RemoveException("empty structure");
            } catch (RemoveException ex) {
                Logger.getLogger(dynamicArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /*
Returns true if the array contains no elements and 
false otherwise.
     */
    @Override
    public boolean isEmpty() {
        boolean allNull = true;

        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                allNull = false;
            }
        }

        return allNull;
    }

    /*
Removes all of the elements from the array.  After this function has
been called on a dynamicArray object, the the array must be empty (i.e. all elements in the array must be null).  The array's current
size remains unchanged.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    /*
Use this function to resize the array.
     */
    private void resize(int howMuch) {
        dynamicArray da = this.clone();

        size = howMuch;

        elements = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        for (int i = 0; i < da.size; i++) {
            elements[i] = (T) da.elements[i];
        }
    }

    /*The overloaded stream operator for the dynamicArray class.  If
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
    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                s += elements[i];
            } else {
                s += "*";
            }

            if (i < size - 1) {
                s += ",";
            }
        }

        s += "]";

        return s;
    }
}
