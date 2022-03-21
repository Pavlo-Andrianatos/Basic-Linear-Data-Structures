#ifndef REMOVEEXCEPT
#define REMOVEEXCEPT

#include <iostream>

using namespace std;

/*
A simple class that you can use to indicate errors
in removing from structures.  In Java, this class
will have to conform to the Throwable interface.
*/

class RemoveException
{
	public:
		RemoveException(string s)
		{
			message = s;
		}
		
		string getMessage()
		{
			return message;
		}
	
	private:
		string message;
};

#endif