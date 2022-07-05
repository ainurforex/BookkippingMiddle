public class Bookkeeping {
    public static void main(String[] args) {
        Employee[] employeeBook = new Employee[10];
        employeeBook[0] = new Employee("Петров", "Иван", "Сидорович", 1, 1000);
        employeeBook[1] = new Employee("Нечаев", "Петр", "Васильевич", 1, 2000);
        employeeBook[2] = new Employee("Сидоров", "Василий", "Петрович", 1, 5000);
        employeeBook[3] = new Employee("Бекетова", "Анна", "Васильевнв", 2, 50000);
        employeeBook[4] = new Employee("Зарев", "Михаил", "Артурович", 2, 8000);
        employeeBook[5] = new Employee("Пушкин", "Александр", "Сергеевич", 3, 70000);
        employeeBook[6] = new Employee("Сиськин", "Гиви", "Карэнович", 3, 75000);
        employeeBook[7] = new Employee("Могелева", "Кристина", "Андреевна", 4, 25000);


        System.out.println(dataOfEmployees(employeeBook));
        indexingSalaryAllEmployee(employeeBook, 50);
        System.out.println(dataOfEmployees(employeeBook));
        System.out.println();
        System.out.println(findEmployeesMinSalaryInDepartment(employeeBook, 1));
        System.out.println(findEmployeesMaxSalaryInDepartment(employeeBook, 1));
        System.out.println();
        System.out.println(summSalaryInDepartment(employeeBook, 1));
        System.out.println();
        System.out.println(avarageSalaryInDepartment(employeeBook, 1));
        System.out.println();
        System.out.println(listOfEmployeesInDepartment(employeeBook, 2));
        indexingSalaryAllEmployeeInDepartment(employeeBook, 50, 2);
        System.out.println(listOfEmployeesInDepartment(employeeBook, 2));
        System.out.println();
        System.out.println(listOfLessSalary(employeeBook, 50000));
        System.out.println(listOfMoreSalary(employeeBook, 50000));
    }


    private static String dataOfEmployees(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }

        String dataOfEmployees = "";

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                dataOfEmployees += employees[i] + "\n";
            }
        }

        return dataOfEmployees;
    }


    private static String listOfEmployees(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }

        String listOfEmployees = "";

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                listOfEmployees += employees[i].getFullName() + "\n";
            }
        }

        return listOfEmployees;
    }


    private static String listOfEmployeesInDepartment(Employee[] employees, int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(employees, department);
        if (firstEnterInBaseDepartment == -1) {
            return "None";
        }
        String listOfEmployeesInDepartment = "";

        for (int i = firstEnterInBaseDepartment; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                listOfEmployeesInDepartment += "id " + employees[i].getId() + ", " + employees[i].getFullName() +
                        ", " + employees[i].getSalary() + "\n";
            }
        }

        return listOfEmployeesInDepartment;
    }


    private static int summSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return 0;
        }

        int summSalary = 0;

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                summSalary += employees[i].getSalary();
            }
        }

        return summSalary;
    }


    private static int summSalaryInDepartment(Employee[] employees, int department) {
        int firstEnterInBaseDepartment = firstEnterInBaseDepartment(employees, department);
        if (firstEnterInBaseDepartment == -1) {
            return 0;
        }

        int summSalary = 0;

        for (int i = firstEnterInBaseDepartment; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                summSalary += employees[i].getSalary();
            }
        }

        return summSalary;
    }


    private static String findEmployeesMinSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }

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
            if (employees[i] != null && employees[i].getDepartment() == department &&
                    employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                indexEmployeesMinSalary = i;
            }

        }

        return employees[indexEmployeesMinSalary].getFullName();
    }


    private static String findEmployeesMaxSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }
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
            if (employees[i] != null && employees[i].getDepartment() == department &&
                    employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                indexEmployeesMaxSalary = i;
            }

        }

        return employees[indexEmployeesMaxSalary].getFullName();
    }


    private static int avarageSalary(Employee[] employees) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return 0;
        }

        int countEmployees = 0;
        int summSalary = summSalary(employees);

        for (int i = firstEnterInBase; i < employees.length; i++) {
            if (employees[i] != null) {
                countEmployees++;
            }
        }

        return Math.round(summSalary / countEmployees);
    }


    private static int avarageSalaryInDepartment(Employee[] employees, int department) {
        int summSalaryInDepartment = summSalaryInDepartment(employees, department);
        if (summSalaryInDepartment == 0) {
            return 0;
        }

        int countEmployees = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                countEmployees++;
            }
        }

        return Math.round(summSalaryInDepartment / countEmployees);
    }


    private static void indexingSalaryEmployee(Employee employee, int percent) {
        if (employee != null) {
            employee.setSalary((employee.getSalary() * percent / 100) + employee.getSalary());
        }
    }


    private static void indexingSalaryAllEmployee(Employee[] employees, int percent) {
        for (int i = 0; i < employees.length; i++) {
            indexingSalaryEmployee(employees[i], percent);
        }
    }


    private static void indexingSalaryAllEmployeeInDepartment(Employee[] employees, int percent, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                indexingSalaryEmployee(employees[i], percent);
            }
        }
    }


    private static String listOfLessSalary(Employee[] employees, int lessSalary) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }

        String listOfLessSalary = "";

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < lessSalary) {
                listOfLessSalary += "id " + employees[i].getId() + ", Ф.И.О." + employees[i].getFullName() +
                        ", зарплата " + employees[i].getSalary() + "\n";
            }
        }

        return listOfLessSalary;
    }


    private static String listOfMoreSalary(Employee[] employees, int moreSalary) {
        int firstEnterInBase = firstEnterInBase(employees);
        if (firstEnterInBase == -1) {
            return "None";
        }

        String listOfMoreSalary = "";

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].getSalary() >= moreSalary) {
                listOfMoreSalary += "id " + employees[i].getId() + ", Ф.И.О." + employees[i].getFullName() +
                        ", зарплата " + employees[i].getSalary() + "\n";
            }
        }

        return listOfMoreSalary;
    }


    private static int firstEnterInBase(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }
        System.out.println("Запись в базе отсутствует.");
        return -1;
    }


    private static int firstEnterInBaseDepartment(Employee[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                return i;
            }
        }
        System.out.println("Запись в базе отсутствует.");
        return -1;
    }

}