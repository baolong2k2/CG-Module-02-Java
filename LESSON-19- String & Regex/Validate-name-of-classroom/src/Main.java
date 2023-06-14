public class Main {
    private static ClassExample classExample;
    public static final String[] validName = new String[]{"C0223G", "A0323K"};
    public static final String[] invalidName = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args){
        classExample = new ClassExample();
        for (String name : validName){
            boolean isvalid = classExample.validate(name);
            System.out.println("Name of this class " + name + " is valid " + isvalid);
        }
        for (String name : invalidName){
            boolean isvalid = classExample.validate(name);
            System.out.println("Name of this class " + name + " is valid " + isvalid);
        }
    }
}