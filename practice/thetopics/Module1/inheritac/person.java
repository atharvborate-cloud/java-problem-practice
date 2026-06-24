package practice.thetopics.Module1.inheritac;

public class person {

    String name ;
    int age ;

    public person (String name , int age){
        this.name = name ;
        this.age  = age ;

    }

    public void displayinfo(){
        System.out.println("Name = " + this.name );
        System.out.println("Age = " + this.age );
    }
}
