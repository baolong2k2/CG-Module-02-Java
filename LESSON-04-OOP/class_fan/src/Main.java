public class Main {
    public static void main(String[] args){
    Fan fan1 = new Fan();
    Fan fan2 = new Fan();

        fan1.setOn(true);
        fan1.setSpeed(Fan.FAST);
        fan1.setColor("yellow");
        fan1.setRadius(10);

        fan2.setOn(false);
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setColor("blue");
        fan2.setRadius(5);

        System.out.println("Fan 1: ");
        System.out.println(fan1.toString());
        System.out.println("");
        System.out.println("Fan 2: ");
        System.out.println(fan2.toString());

}
}
