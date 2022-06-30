import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>();
        Start(people);

    }
    public static void Start(LinkedList<Person> people){
        try {
            while (true) {
                int MenuChoice;
                System.out.println("---------------------------------");
                System.out.println("Меню");
                System.out.println("1) Добавить человека");
                System.out.println("2) Выйти из программы");
                System.out.print("Ввод: ");
                MenuChoice = scanner.nextInt();
                if (MenuChoice == 1) {
                    AddPerson(people);
                } else if (MenuChoice == 2) {
                    System.out.println("До скорой встречи!");
                    break;
                } else {
                    System.out.println("-----------------------------------");
                }

            }
        }
        catch (NotAddNewPeopleException notAddNewPeopleException){
            System.out.println(notAddNewPeopleException.getMessage());
            Start(people);
        }
    }

    public static void AddPerson(LinkedList<Person> people) throws NotAddNewPeopleException {
        int addPerson = 1;
        System.out.println("Добавление человека: ");
        System.out.print("Фамилия: ");
        String lastName = scanner.next();
        System.out.print("Имя: ");
        String firstName = scanner.next();
        System.out.print("Отчество: ");
        String patronymic = scanner.next ();
        for (Person person : people) {
            if(person.getLastName().equals(lastName) && person.getFirstName().equals(firstName) && person.getPatronymic().equals(patronymic)){
                addPerson = 0;
                throw new NotAddNewPeopleException("Такой человек уже существует.");
            }
        }
        if(addPerson == 1){
            people.add(new Person(lastName,firstName,patronymic));
            System.out.println("Человек добавлен.");
            addPerson = 0;
        }
    }
}
