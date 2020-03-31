import javax.swing.JOptionPane;

public class LoginView 
{	
	public LoginView()
	{
		String numberAccount, passwd;
		byte error = 0;
		
		do
		{
			numberAccount = JOptionPane.showInputDialog("Number Account: ");
			passwd = JOptionPane.showInputDialog("Passwd: ");
			
			if(Control.account.isValid(numberAccount, passwd) == true)
			{
				JOptionPane.showMessageDialog(null, "Access allowed.");
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Access denied.");
				error++;
			}
		}while(error < 3);
		
		if(error == 3)
		{
			JOptionPane.showMessageDialog(null, "Account blocked.");
		}
		else
		{
			new MenuView();
		}
	}
}