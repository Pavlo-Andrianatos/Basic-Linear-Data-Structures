#include "stack.h"
#include "queue.h"
#include "priorityQueue.h"
#include "linkedList.h"
#include "dynamicArray.h"
#include "circularList.h"

#include <iostream>

using namespace std;



int main()
{
	RemoveException r("dddd");

	//A stack with a dynamic array implementation
	cout << "TTTTTTTTTTTTTTTTTTTTTt";
	Stack<int> s(new DynamicArray<int>(6));

	//A queue with a linked list implementation
	//Queue<double> q(new LinkedList<double>());

	//A queue with a dynamic array implementation
	//Queue<int> q2(new DynamicArray<int>(10));

	//A priority queue with a circular list implementation
	//PriorityQueue<double> p(new CircularList<double>());

	//Write code to test your implementation.
	return 0;
}
