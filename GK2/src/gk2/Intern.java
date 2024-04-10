package gk2;

public class Intern extends Thongtinnv {
private String majors;
    private String semester;
    private String universityName;

    public Intern(int ID, String FullName, String BirthDay, String Phone, String Email, String Employee_type, int Employee_count, String majors, String semester, String universityName) {
        super(ID, FullName, BirthDay, Phone, Email, Employee_type, Employee_count);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}
