package tSmirnova_hW_auto01.Parsers_all;

public class Medic {
    private String department;
    private String position;
    private String surname;
    private String name;
    private String middlename;
    private String workExperience;

    public Medic(String department, String position, String surname, String name, String middlename, String workExperience) {
        this.department = department;
        this.position = position;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.workExperience = workExperience;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getWorkExperience() {
        return workExperience;
    }

}
