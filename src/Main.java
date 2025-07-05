import java.text.DecimalFormat;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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

            EmployeeBook employeeBook = new EmployeeBook();

            employeeBook.addEmployee(dmitriy);
            employeeBook.addEmployee(sergey);
            employeeBook.addEmployee(vadim);
            employeeBook.addEmployee(clavdiy);
            employeeBook.addEmployee(antonina);
            employeeBook.addEmployee(gadya);
            employeeBook.addEmployee(greta);
            employeeBook.addEmployee(arnold);
            employeeBook.addEmployee(gulnar);
            employeeBook.addEmployee(nepridumal);

            System.out.println("------------------------------------------------------------------------");
            employeeBook.printStuffInfo();
            System.out.println("------------------------------------------------------------------------");

            System.out.println("Ср. ЗП штата = " + employeeBook.calculateAverageFullStuffSalary());
            for (int i = 1; i < 6; i++) {
                System.out.println("Ср. ЗП отдела №" + i + " = " + employeeBook.calculateAverageDepartamentSalary(i));
            }
            System.out.println("------------------------------------------------------------------------");

            System.out.println("Макс. ЗП в штате = " + employeeBook.findMaxFullStuffSalaryEmployee());
            for (int i = 1; i < 6; i++) {
                System.out.println("Макс. ЗП отдела №" + i + " = " + employeeBook.findMaxDepartmentSalaryEmployee(i));
            }
            System.out.println("------------------------------------------------------------------------");

            System.out.println("Мин. ЗП в штате = " + employeeBook.findMinFullStuffSalaryEmployee());
            for (int i = 1; i < 6; i++) {
                System.out.println("Мин. ЗП отдела №" + i + " = " + employeeBook.findMinDepartmentSalaryEmployee(i));
            }
            System.out.println("Индексация всему штату----------------------------------------------------------------");
            employeeBook.indexFullStuffSalary(10);
            employeeBook.printStuffInfo();

            System.out.println("\n Индексация департаменам-----------------------------------------------------------------");
            employeeBook.indexDepartamentSalary(5, 50);
            employeeBook.printStuffInfo();
            System.out.println("------------------------------------------------------------------------");

            employeeBook.printLessSalaryEmployes(300.00);
            employeeBook.printMoreSalaryEmployes(5000.00);

            if (employeeBook.removeEmployee(7)) {
                System.out.println("Уволен сотрудник с Id = 7.");
            } else {
                System.out.println("Не найден сотрудник с Id = 7.");
            }

            employeeBook.printFullStuffNames();
            System.out.println("------------------------------------------------------------------------");
            for (int i = 1; i < 6; i++) {
                employeeBook.printDepartamentStuffFullNames(i);
                System.out.println("------------------------------------------------------------------------");
            }
            System.out.println("------------------------------------------------------------------------");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}