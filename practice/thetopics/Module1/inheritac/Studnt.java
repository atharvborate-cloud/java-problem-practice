package practice.thetopics.Module1.inheritac;

public class Studnt extends person {

    String Rollno ;
    String Branch ;
    public Studnt(String Rollno , String Branch , String name , int age ){

        super(name , age );
        this.Rollno = Rollno;
        this.Branch = Branch;

    }

    public void displayStudntinfo(){
        super.displayinfo();
        System.out.println("Rollno = " + this.Rollno);
        System.out.println("Branch = " + this.Branch);

    }

    public static void main(String[] args) {
        Studnt S1 = new Studnt("CSE-101", "CSE", "Atharv" , 21);
        S1.displayStudntinfo();

    }
}
