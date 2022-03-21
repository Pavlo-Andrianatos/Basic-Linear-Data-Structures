
public interface orderedContainer<T> extends linearStructure<T>
{

    /*
		The constructor initializes the Container
		with the structure passed in as a parameter.
		You will have to make a copy of the linearStructure
		as parties outside of this class may have pointers
		to it still.
		The elements added to the container must be
		stored in the object to which dataStructure
		points.
     */
    public void OrderedContainer(linearStructure c);

    /*
		Copy constructor
     */
    public void OrderedContainer(orderedContainer other);

    /*
		The overloaded assignment operator.  You will have to replace this 
		operator with an appropriate equivalent in your Java code
     */

    @Override
    public orderedContainer clone();

    /*
		Removes an element from the container.  See subclasses 
		for more details.
     */
    public T remove();

    /*
		Returns an element from the container.  See subclasses
		for more details.
     */
    public T next();

    /*
		Inserts an element into the container.  See subclasses
		for more details.
     */
    public void insert(T el);

    /*
		Returns true if the container is empty, and false
		if the container contains elements.
     */
    @Override
    public boolean isEmpty();
}
