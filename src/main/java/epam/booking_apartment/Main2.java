package epam.booking_apartment;

public class Main2 {
    public static void main(String[] args) {
        String s = "/apartment/1";
        System.out.println(s.replaceAll("\\D", ""));
    }
}
