package packagename;

public class Main {
    public static void main(String[] args) {
        Person someone = new Person();
        String[] information = {"Селезнев", "Максим", "Вячеславович", "22.11.2002"};
        someone.get_info(information);
        someone.print_info();
    }
}
