package packagename;

import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private String sex;
    private int age;
    private String age_word;
    private StringBuilder info_to_print;
    Person(){
        this(null,null,null,null);
    }
    Person(String surname, String name, String patronymic, String birthday){
        this.surname=surname;
        this.name=name;
        this.patronymic = patronymic;
        this.birthday=birthday;
    }
    public void get_info(String[] info){
        try {
            surname = info[0]; name = info[1]; patronymic = info[2]; birthday = info[3];
            System.out.println("Here is a person " + surname + " " + name + " " + patronymic+". Birthday: " + birthday);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("You have inputted data in wrong format");
            System.out.println("Please try again");
            System.exit(1);
        }
    }
    private void define_sex(){
        String ending = (patronymic.charAt(patronymic.length()-2))+
                String.valueOf(patronymic.charAt(patronymic.length()-1));
        if(ending.equalsIgnoreCase("ИЧ")|| ending.equalsIgnoreCase("ЛЫ")) {
            sex="M";
        } else if (ending.equalsIgnoreCase("НА") || ending.equalsIgnoreCase("ЗЫ")
                || ending.equalsIgnoreCase("ВА")) {
            sex="Ж";
        } else {
            sex="The sex is undefined";
        }
    }
    private void calculate_ages(){
        String[] date =  birthday.split("\\.");
        try {
            LocalDate birthday = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
            age = Period.between(birthday,LocalDate.now()).getYears();
            switch (age % 10) {
                case 1 -> age_word = "год";
                case 2, 3, 4 -> age_word = "года";
                case 5, 6, 7, 8, 9, 0 -> age_word = "лет";
            }
        }
        catch (DateTimeException e){
            System.out.println("Something wrong with inputted date");
            System.out.println("Please try again");
            System.exit(1);
        }
    }
    private void preparing_info_to_print(){
        info_to_print = new StringBuilder();
        define_sex();
        calculate_ages();
        info_to_print.append(surname).
                append(" ").
                append(name.charAt(0)).
                append(".").
                append(patronymic.charAt(0)).
                append(". ").
                append(sex).
                append(" ").
                append(age).
                append(" ").
                append(age_word);
    }
    public void print_info() {
        preparing_info_to_print();
        System.out.println(info_to_print);
    }
}
