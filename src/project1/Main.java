package project1;

public class Main {

    public static void main(String[] args) {

        System.out.println("高配系统：");
        MySystem highConfigSystem=new MySystem(3,10);
        String shape1=highConfigSystem.getShapgeFromDB();
        highConfigSystem.print(shape1);
        highConfigSystem.display(shape1);


        System.out.println("\n\n低配系统：");
        MySystem lowConfigSystem=new MySystem(1,1);
        String shape2=lowConfigSystem.getShapgeFromDB();
        lowConfigSystem.print(shape2);
        lowConfigSystem.display(shape2);

    }
}
