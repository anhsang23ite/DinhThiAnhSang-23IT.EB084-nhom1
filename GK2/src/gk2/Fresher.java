package gk2;

public class Fresher extends Thongtinnv {
 private String graduationDate;
	    private String graduationRank;
	    private String education;

	    public Fresher(int ID, String FullName, String BirthDay, String Phone, String Email, String Employee_type, int Employee_count, String graduationDate, String graduationRank, String education) {
	        super(ID, FullName, BirthDay, Phone, Email, Employee_type, Employee_count);
	        this.graduationDate = graduationDate;
	        this.graduationRank = graduationRank;
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
