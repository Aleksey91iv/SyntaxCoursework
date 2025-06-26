import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    final static int staffRestrictions = 10;
    static Employee[] employes = new Employee[staffRestrictions];

    public static void main(String[] args) {
        try {
            Employee dmitriy = new Employee("Иванов", "Дмитрий", "Петрович", 1, 3000.53);
            Employee sergey = new Employee("Семёнов", "Сергей", "Васильевич", 1, 5732.00);
            Employee vadim = new Employee("Фёдоров", "Вадим", "Усович", 2, 6984.20);
            Employee clavdiy = new Employee("Безухов", "Клавдий", "Варфоломеевич", 2, 5783.00);
            Employee antonina = new Employee("Ждунова", "Антонина", "Сафроновна", 3, 299.99);
            Employee gadya = new Employee("Петрова", "Гадя", "Хренович", 3, 15000.00);
            Employee greta = new Employee("Зеленова", "Гретта", "Туборг", 4, 15.00);
            Employee arnold = new Employee("Иванов", "Арнольд", "Железнович", 4, 1590.00);
            Employee gulnar = new Employee("Забродов", "Гульнар", "Заблудович", 5, 12.00);
            Employee nepridumal = new Employee("Иванов", "Иван", "Иванович", 5, 100000.99);

            employes[0] = dmitriy;
            employes[1] = sergey;
            employes[2] = vadim;
            employes[3] = clavdiy;
            employes[4] = antonina;
            employes[5] = gadya;
            employes[6] = greta;
            employes[7] = arnold;
            employes[8] = gulnar;
            employes[9] = nepridumal;

            getEmployes();
            System.out.println("Месячный зарплатный бюджет: " + calculateMonthStuffSalary());
            System.out.println("\nСамый низкооплачиваемый сотрудник:\n" + findMinSalaryEmployee());
            System.out.println("\nСамый высокооплачиваемый сотрудник:\n" + findMaxSalaryEmployee());
            System.out.println("\nСредняя зарплата сотрудников: " + calculateAverageSalary());
            System.out.println("\nФИО сотрудников:");
            printStuffFullNames();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void getEmployes() {
        for (Employee employee : employes) {
            System.out.println(employee);
        }
    }

    static double calculateMonthStuffSalary() {
        double sum = 0;
        for (Employee employee : employes) {
            sum += employee.getSalary();
        }

        return sum;
    }

    static Employee findMinSalaryEmployee() {
        return Arrays.stream(employes).min(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))).get();
    }

    static Employee findMaxSalaryEmployee() {
        return Arrays.stream(employes).max(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))).get();
    }

    static double calculateAverageSalary() {
        return calculateMonthStuffSalary() / staffRestrictions;
    }

    static void printStuffFullNames() {
        Arrays.stream(employes).forEach((employe) -> System.out.println(employe.getFullName()));
    }
}