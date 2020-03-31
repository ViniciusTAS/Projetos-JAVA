
public class Account 
{
    private String owner, accountNumber, passwd, extract;
    private float balanceCC, balancePP, limit;
    
    public Account(String owner, String accountNumber, String passwd)
    {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.passwd = passwd;
        this.extract = "";
        this.balanceCC = 0.00f;
        this.balancePP = 0.00f;
        this.limit = -1000f;
    }
    
    public boolean isValid(String account, String passwd)
    {
        if(accountNumber.compareTo(account) == 0 && passwd.compareTo(passwd) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public float searchBalance(int type)
    {
        switch(type)
        {
            case 1: 
                return balanceCC;
            case 2: 
                return balancePP;
            default:
                return 0;
        }   
    }
    
    public void depositBalance(float valor)
    {
        balanceCC += valor;
        extract += "Deposit: R$ " + valor + "\n";
    }
    
    public int sendBalance(float valor)
    {
        if(valor > limit)
        {
            extract += "Transaction invalid. \n";
            
            return 3;
        }
        else
        {
            if(balanceCC - valor > limit)
            {
                balanceCC -= valor;
                extract += "Balance of R$" + valor + ". \n";
                
                return 1;
            }
            else
            {
                return 2;
            }
        }
    }
    
    public boolean redeemBalance(float valor)
    {
        if(balancePP > 0)
        {
            balancePP -= valor;
            balanceCC += valor;
            extract += "Balance PP to CC R$:" + valor + ". \n";
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean apply(float valor)
    {
        if(this.balanceCC > 0)
        {
            balanceCC -= valor;
            balancePP += valor;
            extract += "Balance CC to PP R$:" + valor + ". \n";
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String scanExtract()
    {
        return extract;
    }
    
    public String getOwner()
    {
    	return owner;
    }
    
    public String getPasswd()
    {
    	return passwd;
    }
}