package project1;
/**
 Different Campus locations where events take place
 @author Micheal Kassie, Donald Yubeaton
 */
public enum Location {
    ARC103( "Allison_Road_Classroom", "Busch"),
    HLL114( "Hill_Center", "Busch"),
    AB2225( "Academic_Building", "College Avenue"),
    MU302( "Murray_Hall", "College Avenue"),
    BE_AUD( "Beck_Hall", "Livingston"),
    TIL232( "Tillett_Hall", "Livingston");

 private final String building;
 private final String campus;
    /**
     Enum Constructor
     */
    Location(String building, String campus) {
        this.building= building;
        this.campus= campus;

    }

    /**
     Returns the Location's building
     @return the Location's building
     */
    public String getBuilding() {
        return building;
    }

    /**
     Returns the Location's campus
     @return the Location's campus
     */
    public String getCampus() {
        return campus;
    }
}
