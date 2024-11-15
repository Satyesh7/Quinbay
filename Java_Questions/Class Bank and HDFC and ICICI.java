// Base class for all banks
abstract class Bank {
    protected double defaultTransactionCharge;  // Base transaction charge
    protected final String bankName;  // Bank name
    
    public Bank(String bankName, double defaultCharge) {
        this.bankName = bankName;
        this.defaultTransactionCharge = defaultCharge;
    }
    
    
    public abstract double calculateTransactionCharge(double amount);
    
    
    public double getDefaultCharge() {
        return defaultTransactionCharge;
    }
    
  
    public String getBankName() {
        return bankName;
    }
}


class ICICI extends Bank {
    private static final double ICICI_ADDITIONAL_CHARGE = 0.02;  
    
    public ICICI() {
        super("ICICI", 20.0);  
    }
    
    @Override
    public double calculateTransactionCharge(double amount) {
        return defaultTransactionCharge + (amount * ICICI_ADDITIONAL_CHARGE);
    }
}


class HDFC extends Bank {
    private static final double HDFC_ADDITIONAL_CHARGE = 0.025;
    private static final double PREMIUM_THRESHOLD = 10000.0;  
    
    public HDFC() {
        super("HDFC", 25.0);  
    }
    
    @Override
    public double calculateTransactionCharge(double amount) {
        double charge = defaultTransactionCharge + (amount * HDFC_ADDITIONAL_CHARGE);
        if (amount > PREMIUM_THRESHOLD) {
            charge *= 0.9;  
        }
        return charge;
    }
}

public class BankTest {
    public static void main(String[] args) {
       
        Bank icici = new ICICI();
        Bank hdfc = new HDFC();
        
       
        double[] testAmounts = {5000.0, 15000.0, 7500.0};
        
        for (double amount : testAmounts) {
            System.out.println("\nTransaction Amount: Rs. " + amount);
            
            double iciciCharge = icici.calculateTransactionCharge(amount);
            System.out.printf("%s Charge: Rs. %.2f%n", 
                            icici.getBankName(), iciciCharge);
            
            double hdfcCharge = hdfc.calculateTransactionCharge(amount);
            System.out.printf("%s Charge: Rs. %.2f%n", 
                            hdfc.getBankName(), hdfcCharge);
        }
    }
}