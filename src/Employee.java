import java.util.Objects;

class Employee {

    private String lastName;
    private String firstName;
    private String patronymic;

    private int departamentId;
    private double salary;

    private int id;
    private static int idCounter = 0;

    Employee(String lastName, String firstName, String patronymic, int departamentId, double salary) {
        boolean isNullName = lastName == null || firstName == null || patronymic == null;
        boolean isOnlyCyrillic = firstName.matches("^\\p{InCyrillic}+") && lastName.matches("^\\p{InCyrillic}+") && patronymic.matches("^\\p{InCyrillic}+");
        boolean isOnlyLatinic = firstName.matches("^[A-Za-z]+") && lastName.matches("^[A-Za-z]+")  && patronymic.matches("^[A-Za-z]+");
        if (isNullName || !isOnlyCyrillic && !isOnlyLatinic || departamentId <= 0 || salary <= 0) {
            throw new IllegalArgumentException("Некорректный формат данных работника.");
        }

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.departamentId = departamentId;
        this.salary = salary;
        id = ++idCounter;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId (int departamentId) {
        this.departamentId = departamentId;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "----------------------------------------\n" +
               "id: " + id + "\n" +
               "ФИО: " + firstName + " " + lastName + " " + patronymic + "\n" +
               "Отдел №" + departamentId + "\n" +
               "Зарплата: " + salary + "\n" +
               "----------------------------------------";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee employee) {
            return lastName.equals(employee.lastName)
                && firstName.equals(employee.firstName)
                && patronymic.equals(employee.patronymic)
                && departamentId == employee.departamentId
                && id == employee.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, departamentId, id);
    }
}
