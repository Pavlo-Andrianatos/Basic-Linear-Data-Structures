/*
The node class for the linked lists.
*/
public class node<T extends Comparable <T>>
{
	node(T data, node n)
	{
		element = data;
		next = n;
	}
		
	//The element stored in the node
	T element;
	//The next node in the list
	node next;
}