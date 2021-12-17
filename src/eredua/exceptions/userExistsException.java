package eredua.exceptions;

public class userExistsException extends Exception {
	 public userExistsException()
	  {
	    super();
	  }
	  /**This exception is triggered if the question already exists 
	  *@param s String of the exception
	  */
	  public userExistsException(String s)
	  {
	    super(s);
	  }

}
