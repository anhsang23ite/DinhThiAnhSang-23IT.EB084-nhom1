package gk2;

import java.io.*;
import java.util.*;
public class Experience extends Thongtinnv {
    private int expInYear;
    private String proSkill;

	    public Experience(int ID, String FullName, String BirthDay, String Phone, String Email, String Employee_type, int Employee_count, int expInYear, String proSkill) {
	        super(ID, FullName, BirthDay, Phone, Email, Employee_type, Employee_count);
	        this.expInYear = expInYear;
	        this.proSkill = proSkill;
	    }

	    @Override
	    public void showInfo() {
	        super.showInfo();
	        System.out.println("Experience In Year: " + expInYear);
	        System.out.println("Professional Skill: " + proSkill);
	    }
	
}
