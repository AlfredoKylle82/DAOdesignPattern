/* File: AuthorsBusinessLogic.java
 * Author: Alfredo Kylle Navarro III
 * Date: 2023
 * Description: Lab 02 DAO design pattern
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.ReceipientsDaoImpl;
import transferobjects.ReceipientsDTO;
import dataaccesslayer.ReceipientsDao;

public class ReceipientsBusinessLogic {
	private static final int CATEGORY_MAX_LENGTH = 40;
	private static final int CITY_MAX_LENGTH = 30;
        private static final int NAME_MAX_LENGTH = 40;
        private static final int Year_MAX_LENGTH = 40;
	
	private ReceipientsDao receipientsDao = null;
	
	public ReceipientsBusinessLogic(){
		receipientsDao = new ReceipientsDaoImpl();
                
	}
	
	public List<ReceipientsDTO> getAllReceipients(){
		return receipientsDao.getAllReceipients();
	}
	
	public ReceipientsDTO getReceipientById(Integer awardID){
		return receipientsDao.getReceipientById(awardID);
	}
	
	public void addReceipient(ReceipientsDTO receipient) throws ValidationException{
		cleanReceipient(receipient);
		validateReceipient(receipient);
		receipientsDao.addReceipient(receipient);
	}
	
	public void updateReceipient(ReceipientsDTO receipient) throws ValidationException{
		cleanReceipient(receipient);
		validateReceipient(receipient);
		receipientsDao.updateReceipient(receipient);
	}
	
	public void deleteReceipient(ReceipientsDTO receipient){
		receipientsDao.deleteReceipient(receipient);
	}
        
        public void printMetaData() {
                receipientsDao.printMetaData();
        }
	
	private void cleanReceipient(ReceipientsDTO receipient){
		
		if(receipient.getName() != null){ 
			receipient.setName(receipient.getName().trim());
		}
                if(receipient.getCategory() != null){ 
			receipient.setCategory(receipient.getCategory().trim());
		}
		if(receipient.getCity() != null){ 
			receipient.setCity(receipient.getCity().trim());
		}
	}
	
	private void validateReceipient(ReceipientsDTO receipient) throws ValidationException{
		validateString(receipient.getName(), "Name", NAME_MAX_LENGTH, true);
                validateString(receipient.getCity(), "City", CITY_MAX_LENGTH, true);
		validateString(receipient.getCategory(), "Category", CATEGORY_MAX_LENGTH, true);
                validateInt(receipient.getYear(), "Year");

	}
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}

	private void validateInt(int value, String fieldName)throws ValidationException{
	    if(value <= 0){
			throw new ValidationException(String.format("%s cannot be a negative number", 
					fieldName));
            }
        }
}
