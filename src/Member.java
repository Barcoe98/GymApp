
public class Member {

	//attributes 
	
	int memberId;
	String memberName;
	String memberAddress;
	double height;
	double startingWeight;
	String gender;
	
	//constructors
	
	public Member(int memberId, String memberName, String memberAddress, double height, double startingWeight, String gender)
	{
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.height = height;
		this.startingWeight = startingWeight;
		this.gender = gender;
		
	}
	
	//methods
	
	public String toString() 
	{
		return "ID: " + memberId  + "  Name: " + memberName + "  Address: " + memberAddress + "  Starting Weight: " + startingWeight + "  Height: " + height + "  Gender: " + gender + "  BMI of " + calculateBMI() + "  Catergory: \n" + determineBMICatergory() ;
	}
	
	public double calculateBMI()
	{
	//Weight divided by the height squared
		
	return toTwoDecimalPlaces(startingWeight/height/height);
	
	}
	
	public double calculateHeightMetresToInches()
	{
		//39 inches in a meter
		return toTwoDecimalPlaces(height*39);
	}
	
	public double convertWeightKGToPounds() 
	{
		//1 Kilogram = 2.20462262 Pounds
		return toTwoDecimalPlaces(startingWeight*2.20462262);
		
	}
	
	public String determineBMICatergory()
	{
		//
		double x = calculateBMI();
		
		if(x < 15)
		{
			System.out.println("VERY SEVERLY UNDERWEIGHT");
		}
		
		else if (x >= 15 && x <= 16)
		{
			System.out.println("SEVERLY UNDERWEIGHT");
		}
		
		else if(x >= 16 && x <= 18.5 )
		{
			System.out.println("underweight");
		}
		
		else if (x >= 18.5 && x <= 25)
		{
			System.out.println("NORMAL");
		}
		
		else if (x >= 25 && x <= 30)
		{
			System.out.println("OVERWEIGHT");
		}
		
		else if (x >= 30 && x <= 35)
		{
			System.out.println("MODERATELY OBESE");
		}
		
		else if (x >= 35 && x <= 40)
		{
			System.out.println("SEVERLY OBESE");
		}
		
		else if (x >= 40)
		{
			System.out.println("VERY SEVERLY OBESE");
		}
		
		else 
		{
			System.out.println("error");
		}
		
		return"";	
	}
	
	/*
	public boolean isIdealBodyWeight()
	{
		
	for (
		
		return	
	}
	*/
	
	
    private double toTwoDecimalPlaces(double num){
        return (int) (num *100 ) /100.0; 
    }

	//getters
	
	public int getID()
	{
		return memberId;
	}
	
	public String getName()
	{
		return memberName;
	}
	
	public String getAddress()
	{
		return memberAddress;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWeight()
	{
		return startingWeight;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	
	//setters
	
	public void setID(int memberId)
	{
		this.memberId = memberId;
	}
	
	public void setName(String memberName)
	{
		this.memberName = memberName;
	}
	
	public void setAddress(String memberAddress)
	{
		this.memberAddress = memberAddress;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public void setStartingWeight(double startingWeight)
	{
		this.startingWeight = startingWeight;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
}
	