package practice.thetopics.Module1.encapsulaton;

public class student {

    private String name;
    private  int age;
    private double cgpa;

            public student(String name , int age ,double cgpa ){

                this.name = name ;
                setAge(age);
                setCgpa(cgpa);
            }

    public String getName() { return name;}
    public int getAge(){ return age; }
    public double getCgpa(){return cgpa;}


    public void setName(String name) {
                if (name == null || name.isEmpty()){
                    System.out.println("Name cannot be empty ");
                    return;
                }
                this.name = name;

    }

    public void setAge(int age) {
                if(age < 1 || age > 100){
                    System.out.println("Age is invalid");
                    return;
                }
                this.age = age;
    }

    public void setCgpa(double cgpa ){
                if(cgpa < 0.00 || cgpa > 10.0) {
                    System.out.println("invalid cgpa");
                    return;
                }
                this.cgpa = cgpa;
    }

    public void displayinfo(){
        System.out.println("Name" + name);
        System.out.println("Age"+ age);
        System.out.println("Cgaa" + cgpa);
    }

    public static void main(String[] args) {
        student s = new student("Atharv", 20, 8.5);
        s.displayinfo();

        System.out.println("------");

        s.setAge(-5);
        s.setCgpa(15.0);
        s.setName("Rahul");

        s.displayinfo();


    }
}
