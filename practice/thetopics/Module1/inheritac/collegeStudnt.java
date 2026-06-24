package practice.thetopics.Module1.inheritac;

public class collegeStudnt extends Studnt{

    String CollegeName;

    public collegeStudnt(String CollegeName, String Rollno , String Branch , String name , int age){
        super( Rollno , Branch , name ,  age);
        this.CollegeName = CollegeName;

    }

    public void displayAll(){
        super.displayStudntinfo();
        System.out.println("College Name =" + CollegeName);
    }

    public static void main(String[] args) {
        collegeStudnt S1 = new collegeStudnt("Sage university" , "CSE_101", "CSE", "Atharv",21);
        S1.displayAll();
    }
}
// Yaha apan ne jo dekha vo ek IS-A relation hai jisko apan Inheritance bolte hai
// matlab CollegeStudent is a Student and student is a Person
// ek aur type ka relation hota hai HAS-A iska example hai Studne HAS-A address.....Isko composition bola jaata hai ye interviews me pooch lete hai