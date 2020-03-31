
public class Control 
{
	public static Account account;
	
    public static void main(String[] args) 
    {
    	account = new Account("Wesley", "1234", "1234");
        new LoginView();
    }
}
