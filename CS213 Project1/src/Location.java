public enum Location {
    ARC103( "Allison_Road_Classroom", "Busch"),
    HLL114( "Hill_Center", "Busch"),
    AB2225( "Academic_Building", "College Avenue"),
    MU302( "Murray_Hall", "College Avenue"),
    BE_AUD( "Beck_Hall", "Livingston"),
    TIL232( "Tillett_Hall", "Livingston");

 private final String building;
 private final String campus;
    Location(String building, String campus) {
        this.building= building;
        this.campus= campus;

    }

    public String getBuilding() {
        return building;
    }

    public String getCampus() {
        return campus;
    }
}
