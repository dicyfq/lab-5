package ua.opnu;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[] {
                new Person("Боговік", "Олександра", 30),
                new Student("Ковбащук", "Анастасія", 18, "АІ-251", "СК12345678"),
                new Student("Точило", "Ярослав", 19, "АІ-251", "СК87654321"),
                new Lecturer("Годовиченко", "Микола", 45, "Комп'ютерні системи", 35000)
        };

        for (Person person : people) {
            System.out.println(person);
        }
    }
}