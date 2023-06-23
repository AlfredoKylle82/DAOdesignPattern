/* File: AuthorsBusinessLogic.java
 * Author: Alfredo Kylle Navarro III
 * Date: 2023
 * Description: Lab 02 DAO design pattern
 */
package businesslayer;

public class ValidationException extends Exception {
	
	public ValidationException(){
		super("Data not in valid format");
	}
	
	public ValidationException(String message){
		super(message);
	}
	
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
