package practice.thetopics.Module1.polymorph;

public class Student {
    // Fields (what a student has)
    String name ;
    String rollno ;
    int age;


   // Constructor .... Same name as class ..... yeh default hota hai means run hota he hota hai agar apan kuch parameter na do toh
    public Student (String name , String rollno , int age){
        this.name = name;
        this.rollno = rollno;
        this.age = age;

    }

    //Constructor overloading ----  yeh apan ne default values set kar di constructor ko fir se use kiya isliye constructor overloading .....
    public Student(String name ){
        this.name = name;
        this.rollno = "TBD";
        this.age = 18;
    }

    public void displayinfo (){
        System.out.println(name);
        System.out.println(rollno);
        System.out.println(age);

    }

    public static void main(String []args){
        Student s1 = new Student("Atharv" , "CSE0021", 21);
        Student s2 = new Student ("Diya");
        s1.displayinfo();
        s2.displayinfo();
    }
}
