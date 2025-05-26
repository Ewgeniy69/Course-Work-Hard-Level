public class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook(int quantity) {
        this.employees = new Employee[quantity];
        this.size = 0;
    }

    public boolean addEmployee(Employee newEmployee) {
        System.out.println(">> Добавляем нового сотрудника <<");
        if (newEmployee == null) {
            System.out.println("Введены некорректные данные");
            return false;
        }
        if (size >= employees.length) {
            System.out.println("В книге нет места для сотрудника: " + newEmployee.getName());
            return false;
        }
        employees[size++] = newEmployee;
        System.out.println("Добавлен новый сотрудник - " + newEmployee.getName());
        return true;
    }

    public Employee deleteEmployee(int id) {
        System.out.println(">> Удаляем сотрудника из телефонной книги <<");

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId()) {
                Employee deleted = employees[i];
                employees[i] = null;
                return deleted;
            }
        }
        System.out.println("Сотрудник с Id " + id + " - не найден");
        return null;
    }

    public Employee searchNumberEmp(int id) {
        System.out.println(">> Поиск сотрудника отдела по Id <<");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId()) {
                System.out.println("Найден сотрудник - " + employees[i].getName() + " Id = " + employees[i].getId());
                return employees[i];
            }
        }
        System.out.println("Сотрудник с Id " + id + " не найден");
        return null;
    }

    public void getFullInfo() {
        System.out.println(">> Вся информация о сотрудниках <<");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public int fullSum() {
        System.out.println(">> Вычисляем траты на заработную плату в месяц <<");
        int sum = 0;
        for (Employee emp : employees) {
            sum += emp.getSalary();
        }
        return sum;
    }

    public void printMin() {
        System.out.println(">> Ищем сотрудника с минимальной заработной платой <<");
        if (employees == null || employees.length == 0) {
            System.out.println("Список пуст");
        }
        Employee min = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < min.getSalary()) {
                min = employees[i];
            }
        }
        System.out.println(min);
    }

    public void printMax() {
        System.out.println(">> Ищем сотрудника с максимальной заработной платой <<");
        if (employees == null || employees.length == 0) {
            System.out.println("Список пуст");
        }
        Employee max = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > max.getSalary()) {
                max = employees[i];
            }
        }
        System.out.println(max);
    }

    public int averageSum() {
        System.out.println(">> Вычисляем среднюю заработную плату сотрудников <<");
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        int aSum = sum / employees.length;
        return aSum;
    }

    public void printName() {
        System.out.println(">> ФИО всех сотрудников <<");
        if (employees == null || employees.length == 0) {
            System.out.println("Список пуст");
        }
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }

    public void promotionSalary() {
        System.out.println(">> Повышаем заработную плуту на 10% <<");
        if (employees == null || employees.length == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (Employee employee : employees) {
            int sum = employee.getSalary();
            int percent = (sum * 10) / 100;
            int newSalary = employee.getSalary() + percent;
            System.out.println("У сотрудника - " + employee.getName() + " заработная плата повышена на 10% и составляет " + newSalary + " рублей");
        }

    }

    public Employee findMinSalary(int departmentNumber) {
        System.out.println(">> Поиск сотрудника с минимальной заработной платой в отделе <<");
        if (departmentNumber <= 0 || departmentNumber > 5) {
            System.out.println("Отдел не существует");
        }
        Employee minSalary = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                if (minSalary == null || employee.getSalary() < minSalary.getSalary()) {
                    minSalary = employee;
                }
            }
        }
        return minSalary;
    }

    public Employee findMaxSalary(int departmentNumber) {
        System.out.println(">> Поиск сотрудника с максимальной заработной платой в отделе <<");
        if (departmentNumber <= 0 || departmentNumber > 5) {
            System.out.println("Отдел не существует");
        }
        Employee maxSalary = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                if (maxSalary == null || employee.getSalary() > maxSalary.getSalary()) {
                    maxSalary = employee;
                }
            }
        }
        return maxSalary;
    }

    public int fullSumInDepartment(int departmentNumber) {
        System.out.println(">> Вычисляем траты на заработную плату в месяц в отделе <<");
        if (departmentNumber <= 0 || departmentNumber > 5) {
            System.out.println("Отдел не существует");
        }
        int fullSum = 0;

        for (Employee emp : employees) {
            if (emp != null && emp.getDepartmentNumber() == departmentNumber) {
                fullSum += emp.getSalary();
            }
        }
        System.out.println("Сумма заработной платы на отдел № " + departmentNumber + " составляет: " + fullSum + " рублей");
        return fullSum;

    }

    public int salaryDepartmentAverage(int departmentNumber) {
        System.out.println(">> Вычесление средней заработной платы в отделе <<");
        if (departmentNumber <= 0 || departmentNumber > 5) {
            System.out.println("Отдел не существует");
        }
        int sum = 0;
        int employeeInDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentNumber() == departmentNumber) {
                sum += employees[i].getSalary();
                employeeInDepartment++;
            }
        }
        int averageSum = sum / employeeInDepartment;
        System.out.println("Средняя заработная плата в отделе № " + departmentNumber + " составляет: " + averageSum + " рублей");
        return averageSum;
    }

    public int indexing(int departmentNumber, int percent) {
        System.out.println(">> Индексация заработной платы сотрудников на процент в параметре <<");
        if (departmentNumber <= 0 || departmentNumber > 5) {
            System.out.println("Отдел не существует");
        }
        int employee = 0;
        for (Employee fan : employees) {
            if (fan.getDepartmentNumber() == departmentNumber) {
                int sum = fan.getSalary();
                int newSalary = sum + (sum * percent / 100);
                fan.setSalary(newSalary);
                System.out.println("После индексации в отделе № " + departmentNumber + " у сотрудника " + fan.getName() + " зарплата составляет: " + newSalary);
                employee++;
            }
        }
        return employee;
    }

    public void printAllOverNumDep(int departmentNumber) {
        System.out.println(">> Информация по сотрудникам конкретного отдела без информации о номере отдела <<");
        for (Employee gan : employees) {
            if (gan.getDepartmentNumber() == departmentNumber) {
                System.out.println("Сотрудник - " + gan.getName() + ", заработная плата: " + gan.getSalary() + " рублей");
            }
        }
    }

    public void printEmployeeBySalary(int number) {
        System.out.println(">> Сотрудники с заработной платой меньше чем <<" + " " + number);
        for (Employee emp : employees) {
            if (emp.getSalary() < number) {
                System.out.println(emp.getId() + ". " + emp.getName() + " " + emp.getSalary());
            }
        }
        System.out.println(">> Сотрудники с заработной платой больше чем <<" + " " + number);
        for (Employee emp : employees) {
            if (emp.getSalary() >= number) {
                System.out.println(emp.getId() + ". " + emp.getName() + " " + emp.getSalary());
            }

        }
    }
}
