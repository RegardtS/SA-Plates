package regimeister.saplates;

public class Numberplate {
	private String registration;
    private String location;
    
 
    public Numberplate(String registration, String location) {
        this.registration = registration;
        this.location = location;
    }
 
    public String getRegistration() {
        return this.registration;
    }
 
    public String getLocation() {
        return this.location;
    }
}
