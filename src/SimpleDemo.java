/* File: SimpleDemo.java
 * Author: Alfredo Kylle Navarro
 * Date: 2023
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
import businesslayer.ReceipientsBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.ReceipientsDTO;

import java.util.List;
public class SimpleDemo {

	public void demo(){
		try{
                    
                    
			ReceipientsBusinessLogic logic = new ReceipientsBusinessLogic();
			List<ReceipientsDTO> list = null;
			ReceipientsDTO receipient = null;
                        
			System.out.println("Printing Meta Data");
                        logic.printMetaData();
                        
			System.out.println("Printing Receipients");
			list = logic.getAllReceipients();
			printReceipients(list);
			
			System.out.println("Printing One Receipient");
			receipient = logic.getReceipientById(1);
			printReceipient(receipient);
			System.out.println();
			
			System.out.println("Inserting One Receipient");
			receipient = new ReceipientsDTO();
			receipient.setCity("Ottawa");
                        receipient.setCategory("Education");
			receipient.setName("Mohammed");
                        receipient.setYear(2004);
			logic.addReceipient(receipient);
			list = logic.getAllReceipients();
			printReceipients(list);

			System.out.println("Updating last author");
			Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
			receipient = new ReceipientsDTO();
                        receipient.setAwardID(updatePrimaryKey);
			receipient.setCity("Ottawa");
                        receipient.setCategory("Healthcare");
			receipient.setName("Navarro");
                        receipient.setYear(2002);
			logic.updateReceipient(receipient);
                        list = logic.getAllReceipients();
			printReceipients(list);
			
			System.out.println("Deleting last author");
			receipient = list.get(list.size() - 1);
			logic.deleteReceipient(receipient);
			list = logic.getAllReceipients();
			printReceipients(list);
                } catch(ValidationException e){
			System.err.println(e.getMessage());
		}
	}
        
        private static void printReceipient(ReceipientsDTO receipient){
	    	String output = String.format("%-10s %-30s %-40s %-20s %-10s",
                                receipient.getAwardID().toString(),
                                receipient.getName(),
	    			receipient.getCategory(),
                                receipient.getYear().toString(),
                                receipient.getCity());
	    	System.out.println(output);
	}
	
	private static void printReceipients(List<ReceipientsDTO> receipients){
            System.out.format("%-10s %-30s %-40s %-20s %-10s %n",
                                "ID",
                                "Name",
                                "Category",
                                    "Year",
                                    "City");
            
	    for(ReceipientsDTO receipient : receipients){
	    	printReceipient(receipient);
	    }
	    System.out.println();
	}
	

        
}
