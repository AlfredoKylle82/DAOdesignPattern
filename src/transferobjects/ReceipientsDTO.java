/* File: AuthorsBusinessLogic.java
 * Author: Alfredo Kylle Navarro III
 * Date: 2023
 * Description: Lab 02 DAO design pattern
 */
package transferobjects;

public class ReceipientsDTO {
    private Integer awardID;
    private String category;
    private String city;
    private String name;
    private Integer year;

    public Integer getAwardID() {
        return awardID;
    }

    public void setAwardID(Integer awardID) {
        this.awardID = awardID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
  
}
