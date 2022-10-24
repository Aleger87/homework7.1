public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration("AAaa11__", "string66", "string66");
        System.out.println(registration.getLogin());
        System.out.println(registration.getConfirmPassword());
        System.out.println(registration.getPassword());
    }
}