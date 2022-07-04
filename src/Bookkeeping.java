public class Bookkeeping {
    public static void main(String[] args) {
        Employee[] employeeBase = new Employee[10];
        employeeBase[0] = new Employee("Петров", "Иван", "Сидорович", 1, 1000);
        employeeBase[1] = new Employee("Нечаев", "Петр", "Васильевич", 1, 2000);
        employeeBase[2] = new Employee("Сидоров", "Василий", "Петрович", 1, 3000);
        employeeBase[3] = new Employee("Бекетова", "Анна", "Васильевнв", 2, 50000);
        employeeBase[4] = new Employee("Зарев", "Михаил", "Артурович", 2, 8000);
        employeeBase[5] = new Employee("Пушкин", "Александр", "Сергеевич", 3, 70000);
        employeeBase[6] = new Employee("Сиськин", "Гиви", "Карэнович", 3, 75000);
        employeeBase[7] = new Employee("Могелева", "Кристина", "Андреевна", 4, 25000);


        System.out.println(dataOfEmployees(employeeBase));
        indexingSalaryAllEmployee(employeeBase, 50);
        System.out.println(dataOfEmployees(employeeBase));
        System.out.println();
        System.out.println(findEmployeesMinSalaryInDepartment(employeeBase, 1));
        System.out.println(findEmployeesMaxSalaryInDepartment(employeeBase, 1));
        System.out.println();
        System.out.println(summSalaryInDepartment(employeeBase, 1));
        System.out.println();
        System.out.println(avarageSalaryInDepartment(employeeBase, 1));
        System.out.println();
        System.out.println(listOfEmployeesInDepartment(employeeBase, 2));
        indexingSalaryAllEmployeeInDepartment(employeeBase, 100, 2);
        System.out.println(listOfEmployeesInDepartment(employeeBase, 2));
        System.out.println();
        System.out.println(listOfLessSalary(employeeBase, 50000));
        System.out.println(listOfMoreSalary(employeeBase, 50000));
    }


    private static String dataOfEmployees(Employee[] employees) {
        if (isEmptyBase(employees)) {
            return "None";
        }

        String dataOfEmployees = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                dataOfEmployees += employees[i] + "\n";
            }
        }

        return dataOfEmployees;
    }


    private static String listOfEmployees(Employee[] employees) {
        if (isEmptyBase(employees)) {
            return "None";
        }

        String listOfEmployees = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                listOfEmployees += employees[i].getFullName() + "\n";
            }
        }

        return listOfEmployees;
    }

    private static String listOfEmployeesInDepartment(Employee[] employees, int department) {
        if (isEmptyBase(employees)) {
            return "None";
        }

        String listOfEmployeesInDepartment = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                listOfEmployeesInDepartment += employees[i].getId() + ", " + employees[i].getFullName() + ", " + employees[i].getSalary() + "\n";
            }
        }

        return listOfEmployeesInDepartment;
    }

    private static int summSalary(Employee[] employees) {
        if (isEmptyBase(employees)) {
            return 0;
        }

        int summSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                summSalary += employees[i].getSalary();
            }
        }

        return summSalary;
    }

    private static int summSalaryInDepartment(Employee[] employees, int department) {
        if (isEmptyBase(employees)) {
            return 0;
        }

        int summSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                summSalary += employees[i].getSalary();
            }
        }

        return summSalary;
    }

    private static String findEmployeesMinSalary(Employee[] employees) {
        if (isEmptyBase(employees)) {
            return "None";
        }

        int firstEnterInBase = firstEnterInBase(employees);
        int minSalary = employees[firstEnterInBase].getSalary();
        int indexEmployeesMinSalary = firstEnterInBase;

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                indexEmployeesMinSalary = i;
            }
        }

        return employees[indexEmployeesMinSalary].getFullName();
    }

    private static String findEmployeesMinSalaryInDepartment(Employee[] employees, int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(employees, department);
        if (firstEnterInBaseDepartment == -1) {
            return "None";
        }

        int minSalary = employees[firstEnterInBaseDepartment].getSalary();
        int indexEmployeesMinSalary = firstEnterInBaseDepartment;

        for (int i = firstEnterInBaseDepartment; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                indexEmployeesMinSalary = i;
            }

        }

        return employees[indexEmployeesMinSalary].getFullName();
    }

    private static String findEmployeesMaxSalary(Employee[] employees) {
        if (isEmptyBase(employees)) {
            return "None";
        }
        int firstEnterInBase = firstEnterInBase(employees);
        int maxSalary = employees[firstEnterInBase].getSalary();
        int indexEmployeesMaxSalary = firstEnterInBase;

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                indexEmployeesMaxSalary = i;
            }
        }

        return employees[indexEmployeesMaxSalary].getFullName();
    }

    private static String findEmployeesMaxSalaryInDepartment(Employee[] employees, int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(employees, department);
        if (firstEnterInBaseDepartment == -1) {
            return "None";
        }

        int maxSalary = employees[firstEnterInBaseDepartment].getSalary();
        int indexEmployeesMaxSalary = firstEnterInBaseDepartment;

        for (int i = firstEnterInBaseDepartment; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                indexEmployeesMaxSalary = i;
            }

        }

        return employees[indexEmployeesMaxSalary].getFullName();
    }

    private static int avarageSalary(Employee[] employees) {
        if (isEmptyBase(employees)) {
            return 0;
        }

        int countEmployees = 0;
        int summSalary = summSalary(employees);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                countEmployees++;
            }
        }

        return Math.round(summSalary / countEmployees);
    }

    private static int avarageSalaryInDepartment(Employee[] employees, int department) {

        int countEmployees = 0;
        int summSalaryInDepartment = summSalaryInDepartment(employees, department);
        if (summSalaryInDepartment == 0) {
            return 0;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                countEmployees++;
            }
        }

        return Math.round(summSalaryInDepartment / countEmployees);
    }

    private static void indexingSalaryEmployee(Employee employee, int percentIndex) {
        if (employee != null) {
            employee.setSalary((employee.getSalary() * percentIndex / 100) + employee.getSalary());
        }
    }

    private static void indexingSalaryAllEmployee(Employee[] employees, int percentIndex) {

        for (int i = 0; i < employees.length; i++) {
            indexingSalaryEmployee(employees[i], percentIndex);
        }
    }


    private static void indexingSalaryAllEmployeeInDepartment(Employee[] employees, int percentIndex, int department) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                indexingSalaryEmployee(employees[i], percentIndex);
            }
        }
    }


    private static String listOfLessSalary(Employee[] employees, int lessSalary) {
        if (isEmptyBase(employees)) {
            return "None";
        }

        String listOfLessSalary = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < lessSalary) {
                listOfLessSalary += employees[i].getId() + ", " + employees[i].getFullName() + ", " + employees[i].getSalary() + "\n";
            }
        }

        return listOfLessSalary;
    }

    private static String listOfMoreSalary(Employee[] employees, int moreSalary) {
        if (isEmptyBase(employees)) {
            return "None";
        }

        String listOfMoreSalary = "";

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].getSalary() > moreSalary) {
                listOfMoreSalary += employees[i].getId() + ", " + employees[i].getFullName() + ", " + employees[i].getSalary() + "\n";
            }
        }

        return listOfMoreSalary;
    }

    private static boolean isEmptyBase(Employee[] employees) {
        int countEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                countEmployees++;
            }
        }
        if (countEmployees == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int firstEnterInBase(Employee[] employees) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }

        return -1;
    }

    private static int firstEnterInBaseDepartment(Employee[] employees, int department) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                return i;
            }
        }

        return -1;
    }

}