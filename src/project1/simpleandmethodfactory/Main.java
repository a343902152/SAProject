package project1.simpleandmethodfactory;

public class Main {

    public static void main(String[] args) {

        // CPU+MEMORY>5视为高配
        OperationSystem system=new OperationSystem(2,4);
        system.simplePrint(system.getShapgeFromDB());
        system.factoryMethodPrint(system.getShapgeFromDB());

        system=new OperationSystem(1,2);
        system.simplePrint(system.getShapgeFromDB());
        system.factoryMethodPrint(system.getShapgeFromDB());

    }
}
