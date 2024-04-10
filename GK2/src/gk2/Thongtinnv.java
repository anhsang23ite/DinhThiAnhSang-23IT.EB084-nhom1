package gk2;

class Thongtinnv implements Nhanvien {
    private int ID;
    private String FullName;
    private String BirthDay;
    private String Phone;
    private String Email;
    private String Employee_type;
    private int Employee_count = 0;
    
    public Thongtinnv(int ID, String FullName, String BirthDay, String Phone, String Email, String Employee_type, int Employee_count )
    {
       this.ID = ID;
       this.FullName = FullName;
       this.BirthDay = BirthDay;
       this.Phone = Phone;
       this.Email = Email;
       this.Employee_type = Employee_type;
       Employee_count++;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + FullName);
        System.out.println("BirthDay: " + BirthDay);
        System.out.println("Phone: " + Phone);
        System.out.println("Email: " + Email);
        System.out.println("Employee Type: " + Employee_type);
        System.out.println("Employee Count: " + Employee_count);
    }
    

}
