import javax.swing.JOptionPane;

public class MenuView 
{
    public MenuView()
    {
    	byte option;
    	float valor;
    	boolean status;
    	
    	do
    	{
    		String msgMenu = "";
			
    		msgMenu += "Hello " + Control.account.getOwner() + "\n\n";
			msgMenu += "[1] Consult balance.\n";
			msgMenu += "[2] Make deposit\n";
			msgMenu += "[3] Make withdrawal \n";
			msgMenu += "[4] Apply in PP\n";
			msgMenu += "[5] Redeen\n";
			msgMenu += "[6] Show extract.\n";
			msgMenu += "[7] Exit.\n\n";
			
			option = Byte.parseByte(JOptionPane.showInputDialog(msgMenu));
			
			switch(option)
			{
			case 1:
				byte type = Byte.parseByte(JOptionPane.showInputDialog("[1] Balance CC. \n[2] Balance PP."));
				float balance = Control.account.searchBalance(type);
				
				JOptionPane.showMessageDialog(null, "Balance: R$" + balance);
				
				break;
			case 2:
				valor = Float.parseFloat(JOptionPane.showInputDialog("Valor?: "));
				
				Control.account.depositBalance(valor);
				
				break;
			case 3:
				int stats;
				valor = Float.parseFloat(JOptionPane.showInputDialog("Valor: "));
				stats = Control.account.sendBalance(valor);
				
				switch(stats)
				{
				case 1:
					JOptionPane.showMessageDialog(null, "Withdrawal succefully.");
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Balance insuficient.");
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Limit execeded.");
					break;
				default:
					break;
				}
				
				break;
			case 4:
				valor = Float.parseFloat(JOptionPane.showInputDialog("Valor?: "));
				
				status = Control.account.apply(valor);
				
				if(status == false)
				{
					JOptionPane.showMessageDialog(null, "Balance insuficient in CC.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Balance to CC for PP succefully.");
				}
				
				break;
			case 5:
				valor = Float.parseFloat(JOptionPane.showInputDialog("Valor?: "));
				
				status = Control.account.redeemBalance(valor);
				
				if(status == false)
				{
					JOptionPane.showMessageDialog(null, "Balance insuficient in PP.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Balance to PP for CC succefully.");
				}
				
				break;
			case 6:
				JOptionPane.showMessageDialog(null, Control.account.scanExtract());
				
				break;
			case 7:
				System.exit(0);
				break;
			default:
				break;
			}
		}while(option != 7);
    }
}
