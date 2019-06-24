import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Gym {
	
	//attributes
	private ArrayList<Member> members; //holds all the members
	
	private String gymName;
	private String managerName;
	private String phoneNumber;
	
	
	//constructor
	
	public Gym(String gymName, String managerName, String phoneNumber)
	{
		this.gymName = gymName;
	    this.managerName = managerName;
		this.phoneNumber = phoneNumber;
		members = new ArrayList<Member>();
	}
	    
	public ArrayList<Member> getMembers()
	{
	   return members;
	} 
	    
	public String toString() 
	{
		return "Gym Name: " + gymName + " Manager Name: " + managerName +  "Phone Number: " + phoneNumber ;
		
		
	}
	
	//Add a member to the gym
	public void add (Member member)
	{
	    members.add (member); 
    }
		
	//removes a member from the gym
   public void remove(int index)
   {
	    members.remove(index);
   }
   
   /*
   public String listBySpecificBMICatergory()
   {
	   return
   }
   */
   
   public String listImpericallyAndMetrically() {
		
		for(int i=0;i<numberOfMembers();i++) {
	    System.out.println(getMembers().get(i).getName() 
			            + ":		" + getMembers().get(i).getWeight() +" kg " + "(" + getMembers().get(i).convertWeightKGToPounds() + "lbs)		" 
			 			+  getMembers().get(i).getHeight() + " metres " + "(" + getMembers().get(i).calculateHeightMetresToInches() + " inches)");
		}
		
		return "Number of members in gym: " + members.size();
   }

   //lists the members in the gym
   
   public String listMembers()
   {
	         if (members.size() > 0){
	        	 
	             String listOfMembers = "";
	             
	             for (int i = 0; i < numberOfMembers(); i++){
	                 listOfMembers += i + ": " + members.get(i) + "\n"; 
	                 
	             }
	             
	             return listOfMembers;  
	         }
	         else{
	        	 
	             return "There are no members in the gym";
	         }
	     } 
   
   /*
   public String ListMembersWithIdealWeight()
   {
	   return*
   }
   */
    
   //prints out the number of members in the gym 
   public int numberOfMembers()
   {
       return members.size();
   } 
   
   //loads members from lib to console
   @SuppressWarnings("unchecked")
   public void load() throws Exception
   {
       XStream xstream = new XStream(new DomDriver());
       ObjectInputStream is = xstream.createObjectInputStream(new FileReader("members.xml"));
      members = (ArrayList<Member>) is.readObject();
       is.close();
   }
   //saves members to lib
   public void save() throws Exception
   {
       XStream xstream = new XStream(new DomDriver());
       ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("members.xml"));
       out.writeObject(members);
       out.close();    
   }
	
	
	//getters
    //methods to read the attributes
	
	public String getGymName()
	{
		return gymName;
	}
		
	public String getManagerName()
	{
		return managerName;
	}
		
	public String getPhoneNumber()
	{			
		return phoneNumber;
	}
	
	//setters
	//methods to assign new values individually to the attributes
		
    public void setGymName(String gymName)
	{
		this.gymName = gymName;
	}

	public void setManagerName(String managerName)
	{
		this.managerName = managerName;
	}
		
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}	

}
