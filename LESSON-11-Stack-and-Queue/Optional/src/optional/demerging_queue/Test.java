package optional.demerging_queue;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Queue male = new Queue();
        Queue female = new Queue();

        ArrayList<Employee> employee = new ArrayList<>();
        employee.add(new Employee("B","male", new int[]{1,1,1991}));
        employee.add(new Employee("C","female",new int[]{2,2,1992}));
        employee.add(new Employee("D","male",new int[]{3,3,1993}));
        employee.add(new Employee("E","female",new int[]{4,4,1994}));
        employee.add(new Employee("F","male",new int[]{5,5,1995}));
        employee.add(new Employee("G","female",new int[]{6,6,1996}));
        employee.add(new Employee("H","male",new int[]{7,7,1997}));
        employee.add(new Employee("I","female",new int[]{8,8,1998}));
        employee.add(new Employee("K","male",new int[]{9,9,1999}));
        employee.add(new Employee("L","female",new int[]{10,10,2000}));

        for (Employee value : employee) {
            if (value.getGender().equals("male")) {
                male.enQueue(value);
            } else {
                female.enQueue(value);
            }
        }

        System.out.println("Male: ");
        while (male.getTail() != null){
            System.out.print(male.deQueue());
        }

        System.out.println("Female: ");
        while (female.getTail() != null){
            System.out.print(female.deQueue());
        }
    }
}
