class detail{
    String name;
    int age;


    detail(){
        name="noname";
        age=0;
    }

    detail(String n,int a){
        name=n;
        age=a;
    }
    
    void display(){
        System.out.println("The name of the student is "+name+" and the age of the student is "+age);

    }

}

class student{
    public static void main(String[] args){
        detail stu=new detail();
        stu.display();

        detail stu1=new detail("Mudit",20);
        stu1.display();
    }
}
