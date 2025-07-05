import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {

    private final int stuffRestrict;
    private final Employee[] stuff;
    private int employeeCounter;
    private int[] departaments;

    public EmployeeBook() {
        stuffRestrict = 10;
        stuff = new Employee[stuffRestrict];
        employeeCounter = 0;
        departaments = new int[]{ 1, 2, 3, 4, 5 };
    }

    public boolean addEmployee(Employee employee) {
        if (employeeCounter == stuffRestrict ||
            employee == null ||
            !Arrays.stream(departaments)
               .anyMatch(item -> item == employee.getDepartamentId())) {
            return false;
        }

        for (int i = 0; i < stuffRestrict; i++) {
            if (stuff[i] == null) {
                stuff[i] = employee;
                employeeCounter++;

                break;
            }
        }

        return true;
    }

    public boolean removeEmployee(int employeeId) {
        for (int i = 0; i < stuffRestrict; i++) {
            if (stuff[i] != null && stuff[i].getId() == employeeId) {
                stuff[i] = null;
                employeeCounter--;

                return true;
            }
        }

        return false;
    }

    public Employee findMinFullStuffSalaryEmployee() throws Exception {
        if (employeeCounter <= 0) {
            throw new Exception("В штате нет сотрудников");
        }

        return findMinSalaryEmployee(stuff);
    }

    public Employee findMaxFullStuffSalaryEmployee() throws Exception {
        if (employeeCounter <= 0) {
            throw new Exception("В штате нет сотрудников.");
        }

        return findMaxSalaryEmployee(stuff);
    }

    public double calculateAverageFullStuffSalary() {
        return calculateAverageSalary(stuff);
    }

    public void printFullStuffNames() {
        printEmployesFullNames(stuff);
    }

    public void indexFullStuffSalary(int indexPercent) throws Exception {
        indexSalary(stuff, indexPercent);
    }

    public Employee findMinDepartmentSalaryEmployee(int departamentId) throws Exception {
        if (Arrays.stream(departaments).anyMatch(departament -> departament == departamentId)) {
            throw new Exception(String.format("Отдела №%d не существует.", departamentId));
        }

        Employee[] departamentEmployees = Arrays.stream(stuff)
                .filter(item -> item != null && item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        if (departamentEmployees.length == 0) {
            throw new Exception(String.format("В штате отдела №%d нет сотрудников.", departamentId));
        }

        return findMinSalaryEmployee(departamentEmployees);
    }

    public Employee findMaxDepartmentSalaryEmployee(int departamentId) throws Exception {
        if (Arrays.stream(departaments).anyMatch(departament -> departament == departamentId)) {
            throw new Exception(String.format("Отдела №%d не существует.", departamentId));
        }

        Employee[] departamentEmployees = Arrays.stream(stuff)
                .filter(item -> item != null && item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        if (departamentEmployees.length == 0) {
            throw new Exception(String.format("В штате отдела №%d нет сотрудников", departamentId));
        }

        return findMaxSalaryEmployee(departamentEmployees);
    }

    public double calculateAverageDepartamentSalary(int departamentId) throws Exception {
        if (Arrays.stream(departaments).anyMatch(departament -> departament == departamentId)) {
            throw new Exception(String.format("Отдела №%d не существует.", departamentId));
        }

        Employee[] departamentEmployees = Arrays.stream(stuff)
            .filter(item -> item != null && item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        return calculateAverageSalary(departamentEmployees);
    }

    public void indexDepartamentSalary(int departamentId, int indexPercent) throws Exception {
        if (Arrays.stream(departaments).anyMatch(departament -> departament == departamentId)) {
            throw new Exception(String.format("Отдела №%d не существует.", departamentId));
        }

        Employee[] departamentEmployees = Arrays.stream(stuff)
                .filter(item -> item != null && item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        indexSalary(departamentEmployees, indexPercent);
    }

    public void printDepartamentStuffFullNames(int departamentId) throws Exception {
        if (Arrays.stream(departaments).anyMatch(departament -> departament == departamentId)) {
            throw new Exception(String.format("Отдела №%d не существует.", departamentId));
        }

        Employee[] departamentEmployees = Arrays.stream(stuff)
                .filter(item -> item != null && item.getDepartamentId() == departamentId).toArray(Employee[]::new);

        printEmployesFullNames(departamentEmployees);
    }

    public void printLessSalaryEmployes(Employee[] employes, int salaryTreshold) {
        Arrays.stream(employes)
            .filter(item -> item != null && item.getSalary() < salaryTreshold)
            .forEach(employee -> System.out.println(employee.getId() + "_"
                    + employee.getFullName() + ": "
                    + employee.getSalary() + " руб."));
    }

    public void printMoreSalaryEmployes(Employee[] employes, int salaryTreshold) {
        Arrays.stream(employes)
                .filter(item -> item != null && item.getSalary() >= salaryTreshold)
                .forEach(employee -> System.out.println(employee.getId() + "_"
                        + employee.getFullName() + ": "
                        + employee.getSalary() + " руб."));
    }

    private double calculateMonthEmployesSalary(Employee[] employes) {
        return Arrays.stream(employes).filter(Objects::nonNull).mapToDouble(Employee::getSalary).sum();
    }

    private Employee findMinSalaryEmployee(Employee[] employes) {
        return Arrays.stream(employes).min(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))).orElse(null);
    }

    private Employee findMaxSalaryEmployee(Employee[] employes) {
        return Arrays.stream(employes).max(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))).orElse(null);
    }

    private double calculateAverageSalary(Employee[] employes) {
        if (employes == null || employes.length == 0) {
            return 0.0;
        }

        return calculateMonthEmployesSalary(employes) / employes.length;
    }

    private void printEmployesFullNames(Employee[] employes) {
        Arrays.stream(employes).filter(Objects::nonNull).forEach((employee) -> System.out.println(employee.getFullName()));
    }

    private void indexSalary(Employee[] employes, int indexPercent) throws Exception {
        if (indexPercent < 0) {
            throw new Exception("Процент индексации не долджен быть отрицательным. Проверьте правильность ввода.");
        }

        Arrays.stream(employes).filter(Objects::nonNull).forEach((employee) -> {
            employee.setSalary(employee.getSalary() +  employee.getSalary() * indexPercent);
        });
    }
}
