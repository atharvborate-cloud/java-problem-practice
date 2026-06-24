package practice.thetopics.Module1.polymorph;



public class Bankacc {

    String name;
    String accno;


    //constructor
    public Bankacc(String name , String accno  ){
        this.name = name;
        this.accno = accno;

    }
     // constructor overloading
    public Bankacc(String name){
        this.name = name;
        this.accno = " XYZ0000000 ";
    }

    //method / function to print ya display info
    public void displayinfo(){
        System.out.println(name);
        System.out.println(accno);
    }

    // main method
    public static void main(String []args ){

        //creation of object
        Bankacc B1 = new Bankacc("Atharv");
        B1.displayinfo();


    }


}
