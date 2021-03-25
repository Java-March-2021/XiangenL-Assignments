public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    @Override
    public String ring() {
    	String m = "Galaxy " + this.getVersionNumber() + ", says " + this.getRingTone();
    	return m;
    }

    @Override
    public String unlock() {
      return "Unlocked with facial recognition";
    }

    @Override
    public void displayInfo() {
    	System.out.printf("Galaxy %s from %s \n", this.getVersionNumber(), this.getCarrier());  
    }
}
