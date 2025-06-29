import java.text.DecimalFormat;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    final static int staffRestrictions = 10;
    static Employee[] employes = new Employee[staffRestrictions];
    static  int[] depertamentsId = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        try {
            Employee dmitriy = new Employee("Иванов", "Дмитрий", "Петрович", depertamentsId[0], 3000.53);
            Employee sergey = new Employee("Семёнов", "Сергей", "Васильевич", depertamentsId[0], 5732.00);
            Employee vadim = new Employee("Фёдоров", "Вадим", "Усович", depertamentsId[1], 6984.20);
            Employee clavdiy = new Employee("Безухов", "Клавдий", "Варфоломеевич", depertamentsId[1], 5783.00);
            Employee antonina = new Employee("Ждунова", "Антонина", "Сафроновна", depertamentsId[2], 299.99);
            Employee gadya = new Employee("Петрова", "Гадя", "Хренович", depertamentsId[2], 15000.00);
            Employee greta = new Employee("Зеленова", "Гретта", "Туборг", depertamentsId[3], 15.00);
            Employee arnold = new Employee("Иванов", "Арнольд", "Железнович", depertamentsId[3], 1590.00);
            Employee gulnar = new Employee("Забродов", "Гульнар", "Заблудович", depertamentsId[4], 12.00);
            Employee nepridumal = new Employee("Иванов", "Иван", "Иванович", depertamentsId[4], 100000.99);

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
            System.out.println("Месячный зарплатный бюджет: " + new DecimalFormat("#0.00").format(calculateMonthStuffSalary(employes)));
            System.out.println("\nСамый низкооплачиваемый сотрудник:\n" + findMinSalaryEmployee(employes));
            System.out.println("\nСамый высокооплачиваемый сотрудник:\n" + findMaxSalaryEmployee(employes));
            System.out.println("\nСредняя зарплата сотрудников: " + new DecimalFormat("#0.00").format(calculateAverageSalary(employes)));
            System.out.println("\nФИО сотрудников:");
            printStuffFullNames(employes);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void getEmployes() {
        Arrays.stream(employes).forEach((employee -> System.out.println(employee)));
    }

    static double calculateMonthStuffSalary(Employee[] employes) {
        return Arrays.stream(employes).mapToDouble(Employee::getSalary).sum();
    }

    static Employee findMinSalaryEmployee(Employee[] employes) {
        return Arrays.stream(employes).min(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))).get();
    }

    static Employee findMaxSalaryEmployee(Employee[] employes) {
        return Arrays.stream(employes).max(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))).get();
    }

    static double calculateAverageSalary(Employee[] employes) {
        return calculateMonthStuffSalary(employes) / staffRestrictions;
    }

    static void printStuffFullNames(Employee[] employes) {
        Arrays.stream(employes).forEach((employee) -> System.out.println(employee.getFullName()));
    }

    static void indexSalary(Employee[] employes, int indexPercent) {
        Arrays.stream(employes).forEach((employee) -> {
            employee.setSalary(employee.getSalary() +  employee.getSalary() * indexPercent);
        });
    }

    static Employee findMinDepartmentSalaryEmployee(int departamentId) {
        Employee[] departamentEmployees = Arrays.stream(employes)
            .filter(item -> item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        return findMinSalaryEmployee(departamentEmployees);
    }

    static Employee findMaxDepartmentSalaryEmployee(int departamentId) {
        Employee[] departamentEmployees = Arrays.stream(employes)
            .filter(item -> item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        return findMaxSalaryEmployee(departamentEmployees);
    }

    static double calculateAverageSalary(int departamentId) {
        Employee[] departamentEmployees = Arrays.stream(employes)
            .filter(item -> item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        return calculateAverageSalary(departamentEmployees);
    }

    static void indexDepartamentSalary(int departamentId, int indexPercent) {
        Employee[] departamentEmployees = Arrays.stream(employes)
            .filter(item -> item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        indexSalary(departamentEmployees, indexPercent);
    }

    static void printDepartamentStuffFullNames(int departamentId) {
        Employee[] departamentEmployees = Arrays.stream(employes)
            .filter(item -> item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        printStuffFullNames(departamentEmployees);
    }

    static void printLessSalaryEmployes(Employee[] employes, int salaryTreshold) {
        Arrays.stream(employes)
            .filter(item -> item.getSalary() < salaryTreshold)
            .forEach(employee -> System.out.println(employee.getId() + "_"
                    + employee.getFullName() + ": "
                    + employee.getSalary() + " руб."));
    }

    static void printMoreSalaryEmployes(Employee[] employes, int salaryTreshold) {
        Arrays.stream(employes)
                .filter(item -> item.getSalary() >= salaryTreshold)
                .forEach(employee -> System.out.println(employee.getId() + "_"
                        + employee.getFullName() + ": "
                        + employee.getSalary() + " руб."));
    }
}