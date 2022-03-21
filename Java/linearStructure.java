
public interface linearStructure<T>
{

    public linearStructure clone();

    /*
    Inserts an element at the given index.
    See subclasses for more details.
     */
    public void insert(int index, T element);

    /*
    Removes and returns an element from the index passed
    as a parameter.  See subclasses for more details.
     */
    public T remove(int index);

    /*
    Returns true if the list is empty, and false
    otherwise.
     */
    public boolean isEmpty();

    /*
    Empties out the structure.  See subclasses for more details.
     */
    public void clear();
}
