package gk2;

public class Loainv {
private String Experience;
private String Fresher;
private String Intern;
public String getExperience() {
	return Experience;
}
public void setExperience(String experience) {
	Experience = experience;
}
public String getFresher() {
	return Fresher;
}
public void setFresher(String fresher) {
	Fresher = fresher;
}
public String getIntern() {
	return Intern;
}
public void setIntern(String intern) {
	Intern = intern;
}
public Loainv(String experience, String fresher, String intern) {
	super();
	Experience = experience;
	Fresher = fresher;
	Intern = intern;
}
}
