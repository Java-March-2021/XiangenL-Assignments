public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    @Override
    public String ring() {
    	String m = "Galaxy " + this.getVersionNumber() + ", says " + this.getRingTone();
        return m;
    }
    
    @Override
    public String unlock() {
        return "Unlocked with fingerprint scanner";
    }
    
    @Override
    public void displayInfo() {
    	System.out.printf("iPhone %s from %s \n", this.getVersionNumber(), this.getCarrier());      
    }
}
