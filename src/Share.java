
public class Share {
	int numShare;
	String username;
	
	public Share(int numShare, String username) {
		this.numShare = numShare;
		this.username = username;
	}
	
	public static boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
		    return true;
		} catch(NumberFormatException e){  
		    return false;  
		}  
	}
}
