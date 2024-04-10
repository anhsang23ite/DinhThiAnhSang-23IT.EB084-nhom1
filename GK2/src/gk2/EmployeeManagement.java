package gk2;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        EmployeeManagement app = new EmployeeManagement();
        app.start();
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== MENU ===");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Sửa thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Đếm số lượng nhân viên");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    countEmployee();
                    break;

                    
                    
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
        scanner.close();
    }

    private void addEmployee() {
        System.out.println("Nhập thông tin cho nhân viên:");
        System.out.print("Chọn loại nhân viên (Experience/Fresher/Intern): ");
        String type = scanner.nextLine();
        Employee employee = inputEmployee(type);
        if (employee != null) {
            employeeList.add(employee);
            System.out.println("Thêm nhân viên thành công!");
        } else {
            System.out.println("Không thể thêm nhân viên!");
        }
    }

    private void displayEmployee() {
        System.out.println("Thông tin các nhân viên:");
        for (Employee employee : employeeList) {
            employee.showInfo();
        }
    }

    private void updateEmployee() {
        System.out.print("Nhập ID của nhân viên cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println("Nhập thông tin mới cho nhân viên:");
inputEmployeeDetails(employee);
            System.out.println("Thông tin nhân viên sau khi sửa:");
            employee.showInfo();
        } else {
            System.out.println("Không tìm thấy nhân viên có ID " + id);
        }
    }

    private void deleteEmployee() {
        System.out.print("Nhập ID của nhân viên cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employeeList.remove(employee);
            System.out.println("Đã xóa nhân viên có ID " + id);
        } else {
            System.out.println("Không tìm thấy nhân viên có ID " + id);
        }
    }

    private void countEmployee() {
        System.out.println("Số lượng nhân viên hiện tại: " + employeeList.size());
    }

    private Employee findEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        return null;
    }

    private Employee inputEmployee(String type) {
        System.out.print("ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("BirthDay: ");
        String birthDay = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        String email = inputEmail(); // Validate email format
        if (email == null) {
            return null;
        }
        System.out.print("Employee Type: ");
        String employeeType = scanner.nextLine();

        if (type.equals("Experience")) {
            System.out.print("Exp In Year: ");
            int expInYear = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            System.out.print("Pro Skill: ");
            String proSkill = scanner.nextLine();
            return new Experience(ID, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
        } else if (type.equals("Fresher")) {
            System.out.print("Graduation Date: ");
            String graduationDate = scanner.nextLine();
            System.out.print("Graduation Rank: ");
            String graduationRank = scanner.nextLine();
            System.out.print("Education: ");
            String education = scanner.nextLine();
            return new Fresher(ID, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
        } else if (type.equals("Intern")) {
            System.out.print("Majors: ");
            String majors = scanner.nextLine();
            System.out.print("Semester: ");
            String semester = scanner.nextLine();
            System.out.print("University Name: ");
            String universityName = scanner.nextLine();
return new Intern(ID, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
        } else {
            System.out.println("Loại nhân viên không hợp lệ!");
            return null;
        }
    }

    private void inputEmployeeDetails(Employee employee) {
        System.out.print("Full Name: ");
        employee.setFullName(scanner.nextLine());
        System.out.print("BirthDay: ");
        employee.setBirthDay(scanner.nextLine());
        System.out.print("Phone: ");
        employee.setPhone(scanner.nextLine());
        String email = inputEmail(); // Validate email format
        if (email != null) {
            employee.setEmail(email);
        }
        System.out.print("Employee Type: ");
        employee.setEmployeeType(scanner.nextLine());

        if (employee instanceof Experience) {
            Experience experience = (Experience) employee;
            System.out.print("Exp In Year: ");
            experience.setExpInYear(scanner.nextInt());
            scanner.nextLine(); // Clear buffer
            System.out.print("Pro Skill: ");
            experience.setProSkill(scanner.nextLine());
        } else if (employee instanceof Fresher) {
            Fresher fresher = (Fresher) employee;
            System.out.print("Graduation Date: ");
            fresher.setGraduationDate(scanner.nextLine());
            System.out.print("Graduation Rank: ");
            fresher.setGraduationRank(scanner.nextLine());
            System.out.print("Education: ");
            fresher.setEducation(scanner.nextLine());
        } else if (employee instanceof Intern) {
            Intern intern = (Intern) employee;
            System.out.print("Majors: ");
            intern.setMajors(scanner.nextLine());
            System.out.print("Semester: ");
            intern.setSemester(scanner.nextLine());
            System.out.print("University Name: ");
            intern.setUniversityName(scanner.nextLine());
        } else {
            System.out.println("Loại nhân viên không hợp lệ!");
        }
    }

    private String inputEmail() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                System.out.println("Định dạng email không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }


    interface IEmployee {
        void showInfo();
    }

    static class Employee implements IEmployee, Serializable {
        private static final long serialVersionUID = 1L;

        private int ID;
        private String fullName;
        private String birthDay;
        private String phone;
        private String email;
        private String employeeType;

        public Employee(int ID, String fullName, String birthDay, String phone, String email, String employeeType) {
            this.ID = ID;
            this.fullName = fullName;
            this.birthDay = birthDay;
            this.phone = phone;
            this.email = email;
            this.employeeType = employeeType;
        }

        public int getID() {
            return ID;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmployeeType() {
            return employeeType;
        }

        public void setEmployeeType(String employeeType) {
            this.employeeType = employeeType;
        }

        @Override
        public void showInfo() {
            System.out.println("ID: " + ID);
            System.out.println("Full Name: " + fullName);
            System.out.println("BirthDay: " + birthDay);
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
            System.out.println("Employee Type: " + employeeType);
        }
    }

    static class Experience extends Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private int expInYear;
        private String proSkill;

        public Experience(int ID, String fullName, String birthDay, String phone, String email, String employeeType, int expInYear, String proSkill) {
super(ID, fullName, birthDay, phone, email, employeeType);
            this.expInYear = expInYear;
            this.proSkill = proSkill;
        }

        public int getExpInYear() {
            return expInYear;
        }

        public void setExpInYear(int expInYear) {
            this.expInYear = expInYear;
        }

        public String getProSkill() {
            return proSkill;
        }

        public void setProSkill(String proSkill) {
            this.proSkill = proSkill;
        }

        @Override
        public void showInfo() {
            super.showInfo();
            System.out.println("Experience In Year: " + expInYear);
            System.out.println("Professional Skill: " + proSkill);
        }
    }

    static class Fresher extends Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private String graduationDate;
        private String graduationRank;
        private String education;

        public Fresher(int ID, String fullName, String birthDay, String phone, String email, String employeeType, String graduationDate, String graduationRank, String education) {
            super(ID, fullName, birthDay, phone, email, employeeType);
            this.graduationDate = graduationDate;
            this.graduationRank = graduationRank;
            this.education = education;
        }

        public String getGraduationDate() {
            return graduationDate;
        }

        public void setGraduationDate(String graduationDate) {
            this.graduationDate = graduationDate;
        }

        public String getGraduationRank() {
            return graduationRank;
        }

        public void setGraduationRank(String graduationRank) {
            this.graduationRank = graduationRank;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        @Override
        public void showInfo() {
            super.showInfo();
            System.out.println("Graduation Date: " + graduationDate);
            System.out.println("Graduation Rank: " + graduationRank);
            System.out.println("Education: " + education);
        }
    }

    static class Intern extends Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private String majors;
        private String semester;
        private String universityName;

        public Intern(int ID, String fullName, String birthDay, String phone, String email, String employeeType, String majors, String semester, String universityName) {
            super(ID, fullName, birthDay, phone, email, employeeType);
            this.majors = majors;
            this.semester = semester;
            this.universityName = universityName;
        }

        public String getMajors() {
            return majors;
        }
public void setMajors(String majors) {
            this.majors = majors;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String getUniversityName() {
            return universityName;
        }

        public void setUniversityName(String universityName) {
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
}

