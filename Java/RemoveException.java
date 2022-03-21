/*
A simple class that you can use to indicate errors
in removing from structures.  In Java, this class
will have to conform to the Throwable interface.
 */

public class RemoveException extends RuntimeException
{

    public RemoveException(String s)
    {
        message = s;
    }

    public String getMessage()
    {
        return message;
    }

    private String message;
}
