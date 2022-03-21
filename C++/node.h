#ifndef NODE_H
#define NODE_H

/*
The Node class for the linked lists.
*/
template<class T>
class Node
{
	public:
		Node(T data, Node<T>* n = 0)
		{
			element = data;
			next = n;
		}
		
		~Node()
		{
			next = 0;
		}
		
		//The element stored in the node
		T element;
		//The next node in the list
		Node<T>* next;
};

#endif
