import java.util.Scanner;

public class GymApp {
	
		//Attributes 
	    private Scanner input;						
	     Gym gym1;									
	     Member member;

	   
	    public static void main (String args[])
	    {
	    		GymApp app = new GymApp();  
	        	app.runMenu();
	    }
	    
	    public GymApp()
	    {
	    	input = new Scanner(System.in);
	    	
	    	System.out.println("Please enter your Gym Details");
	        System.out.print("\tGym Name: ");
	        String gymName = input.nextLine();
	      //If over 30 characters are entered it will ask for an input again and give and error message
	        while (gymName.length() > 30)
			{
		        	gymName = gymName.substring(0,30);
		        	System.out.println("Error: Please enter a name with less than 30 characters.");		
					System.out.print("\tName (max 30 chars): ");
			        gymName = input.nextLine();
			}
		        	
	        System.out.print("\tManger Name: ");
	        String managerName = input.nextLine();
	        
	        System.out.print("\tPhone Number(10 digits): ");
	        String phoneNumber = input.nextLine();
	        
	        /*if user enters a phone number with less than 10 digits and more then 10 digits 
	        //the user will be prompted to enter another number containing 10 digits
	        
	        while (phoneNumber.length() < 10 || phoneNumber.length() > 10)
	        {
	        	 System.out.print("\tError: Please enter a 10 digit phone number: ");
	        	 System.out.print("\tPhone Number: ");
	        }
	        */
	        
	        gym1 = new Gym( gymName, managerName, phoneNumber);
	        runMenu();
	        
	    }
	    
	    //menu thats is displayed on the console
	    private int mainMenu()
	    {
	        System.out.println("Gym Menu");
	        System.out.println("---------");     
	        System.out.println("  1) Add a member");    
	        System.out.println("  2) List all members");
	        System.out.println("  3) Remove/Delete a member (by index)");
	        System.out.println("  4) Number of members in the gym");
	        System.out.println("---------"); 
	        System.out.println("  5) List gym details");
	        System.out.println("  6) list members with ideal starting weight");
	        System.out.println("  7) List members with a specific BMI category");
	        System.out.println("  8) List all members stats imperically and metrically");
	        System.out.println("---------"); 
	        System.out.println("  9) save Members");    
	        System.out.println("  10) load Members");
	        System.out.println("  0) Exit");
	        System.out.print("==>> ");
	        int option = input.nextInt();
	        return option;	
	    }
	    
	     //uses a switch statement to run the menu for user
	    private void runMenu()
	    {
	        int option = mainMenu();
	        while (option != 0)
	        {
	            switch (option)
	            {
	                //call up the add Member method
	                case 1:     addMember();
	                            break;
	            
	                //prints list of members that is stored in the array gym1             
	                case 2:     System.out.println(gym1.listMembers()  /*+ member.calculateBMI() + member.determineBMICatergory()*/ ); 
	                           
	                            break;
	                 
	                //call up the delete member method             
	                case 3:     deleteMember();
	     		   			    break;
	     		   	
	     		   	//prints the method number of members that is stored in the array gym1    
	                case 4:     System.out.println("Number of members: " + gym1.numberOfMembers());
	                		    break;
	               
	                //call up the gym details method 		    
	                case 5:		gymDetails();
	                			break;
	                
	                			//if user enters 6 console outputs the following text
	                case 6:		System.out.println("sorry we cannot carry out this method");
	                			break;
	                			
	                			//if user enters 7 console outputs the following text
	                case 7:		System.out.println("sorry we cannot carry out this method");
	                			break;
	                			
	                			
	                case 8:     System.out.println(gym1.listImpericallyAndMetrically());
	                			break;
	                			
	                case 9: 	try{
						
	                			gym1.save();
	                			System.out.println("Saved");
								}
								catch(Exception e){
								System.out.println("Error writing to file:  " + e);
								}
								break;
                    case 10:	try{
								gym1.load();
								System.out.println("loaded");
								}
								catch(Exception e)
								{
								System.out.println("Error reading from file: " + e);
								}
								break;
                    default:   	System.out.println("Invalid option entered: " + option);
                    			break;
	            				}

                    //gives time for reader to read the console, 
	                //when finish press any key to display main menu again
                    System.out.println("\nPress any key to return to main menu");
                    input.nextLine();
                    //input.nextLine(); 
	            
                    //display the main menu again
	            option = mainMenu();
	        }

	        //the user chose option 0, so exit the program
	        System.out.println("Exiting the Gym... bye bye");
	        System.exit(0);
	    }

	    //Main Menu (1)
	    // adds a member to the gym
	    private void addMember() 
		{
	    	
			System.out.println("Please enter the following member details...");
			System.out.print("\tID (between 100001 and 999999): ");
			int memberId = input.nextInt();
			
	        while (memberId < 100000  || memberId > 999999)
	        {
				System.out.println("Error: Please Enter a valid number");
				System.out.print("\tID (between 100001 and 999999): ");
				memberId = input.nextInt();
			}
			
	        //
			System.out.print("\tName (max 30 chars): ");
			String memberName = input.next();
			
			while (memberName.length() > 30 )
			{
				
		        	memberName = memberName.substring(0,30);
		        	System.out.println("Error: Please enter a name with less than 30 characters.");		
					System.out.print("\tName (max 30 chars): ");
			        memberName = input.nextLine();
			}
		        	
			
			System.out.print("\tAddress: ");
			String memberAddress = input.next();
			
			//If the user enters a incorrect for height, he user will be prompted to enter another value within the parameters
			System.out.print("\tHeight (between 1 and 3 metres): ");
			double height = input.nextDouble();
			
			while(height < 1 || height > 3)
			{
				
    			System.out.println("Error: Please enter a height between 1 and 3 metres.");
    			System.out.print("\tHeight (between 1 and 3 metres): ");
    	        height = input.nextDouble();
			}
			
			//if the user enters an incorrect value for weight, he user will be prompted to enter another value within the parameters
			System.out.print("\tStarting Weight (between 35kg and 250kg): ");
			double startingWeight = input.nextDouble();
	        
			 
			while (startingWeight < 35 || startingWeight > 250)
			{
				System.out.println("Error: Please enter a Weight between 35kg-250kg.");
				System.out.print("\tStarting Weight (between 35kg and 250kg): ");
		        startingWeight = input.nextDouble();
			}
			
			System.out.print("\tGender (M/F): ");
			String gender = input.next();
			
			
		        if (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f"))		
				{
					gender = "Unknown Gender";
				}
		        else if (gender.equalsIgnoreCase("m")) {
		        	
		        	gender = "Male";
		        	
		        }
		        
		        else if (gender.equalsIgnoreCase("f"))
		        {
		        	gender = "Female";
		        	
		        }

			gym1.add(new Member(memberId, memberName, memberAddress, height, startingWeight, gender));
			
			}
		
	    //Main Menu (3)
	    //deletes a member from the gym
	    private void deleteMember()
        {
           
            System.out.println(gym1.listMembers());

            if (gym1.numberOfMembers() != 0){   
                
                System.out.print("Index of account to delete ==>");
                int index = input.nextInt();

                if (index < gym1.numberOfMembers() ){    
                    
                    gym1.remove(index);
                    System.out.println("Member deleted.");
                }
                else
                {
                    System.out.println("There is no Member for this index number");
                }
            }
        }
	    
	    //Main Menu (5)
	    //gets variables from gym class and write them to the console as described
	    private void gymDetails() 
	    {
			 System.out.println("Gym Name: " + gym1.getGymName()  + ", Manager Name: " +  gym1.getManagerName() + ", Phone Number: " + gym1.getPhoneNumber() );
			 System.out.println("List of members in the gym: ");
			 System.out.println(gym1.listMembers());  
		 } 
	 }


	        
	  
       

