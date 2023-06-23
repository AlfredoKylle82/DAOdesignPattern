/* File: AuthorsBusinessLogic.java
 * Author: Alfredo Kylle Navarro III
 * Date: 2023
 * Description: Lab 02 DAO design pattern
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.ReceipientsDTO;

public interface ReceipientsDao {
	List<ReceipientsDTO> getAllReceipients();
	
	ReceipientsDTO getReceipientById(Integer awardID);
        
        
	void addReceipient(ReceipientsDTO receipient);
	void updateReceipient(ReceipientsDTO receipient);
	void deleteReceipient(ReceipientsDTO receipient);
        void printMetaData();
        
}
