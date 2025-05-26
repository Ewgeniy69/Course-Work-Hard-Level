public class Main {
    public static void main(String[] args) {
//        Провел повторное изучение материала и выполнил все уровни сложности курсовой работы

        Employee employee = new Employee("Потапов Евгений Анатольевич", 1, 5000);
        Employee employee1 = new Employee("Арсеньев Дмитрий Александрович", 2, 150000);
        Employee employee2 = new Employee("Сергеев Андрей Сергеевич", 3, 570000);
        Employee employee3 = new Employee("Чой Татьяна Александровна", 4, 5987);
        Employee employee4 = new Employee("Литвиненко Антон Владимирович", 5, 30000);
        Employee employee5 = new Employee("Иванов Станислав Иванович", 1, 23000);
        Employee employee6 = new Employee("Бердников Максим Иванович", 2, 897000);
        Employee employee7 = new Employee("Епифанцева Алина Сергеевна", 3, 90000);
        Employee employee8 = new Employee("Табанакова Анжела Александровна", 4, 200);
        Employee employee9 = new Employee("Бруева Наталья Ивановна", 5, 97000);

        EmployeeBook smallBook = new EmployeeBook(10);


        smallBook.addEmployee(employee);
        smallBook.addEmployee(employee1);
        smallBook.addEmployee(employee2);
        smallBook.addEmployee(employee3);
        smallBook.addEmployee(employee4);
        smallBook.addEmployee(employee5);
        smallBook.addEmployee(employee6);
        smallBook.addEmployee(employee7);
        smallBook.addEmployee(employee8);
        smallBook.addEmployee(employee9);

        smallBook.getFullInfo();

        smallBook.searchNumberEmp(4);

        int i = smallBook.fullSum();
        System.out.println("Сумма затрат на ЗП в месяц по всем отделам составляет: " + i + " рублей");

        smallBook.printMin();

        smallBook.printMax();

        System.out.println("Средняя заработная плата по отделам в месяц составляет: " + smallBook.averageSum() + " рублей");

        smallBook.printName();
        smallBook.promotionSalary();
        Employee min = smallBook.findMinSalary(1);
        System.out.println("В отделе № " + min.getDepartmentNumber() + " минимальная заработная плата у сотрудника - " + min.getName() + " и составляет: " + min.getSalary() + " рублей");
        Employee max = smallBook.findMaxSalary(4);
        System.out.println("В отделе № " + max.getDepartmentNumber() + " максимальная заработная плата у сотрудника - " + max.getName() + " и составляет: " + max.getSalary() + " рублей");
        smallBook.fullSumInDepartment(2);
        smallBook.salaryDepartmentAverage(3);
        smallBook.indexing(1, 20);
        smallBook.printAllOverNumDep(2);
        smallBook.printEmployeeBySalary(50000);

        smallBook.getFullInfo();
        Employee emp = smallBook.deleteEmployee(7);
        System.out.println("Сотрудник отдела с Id " + emp.getId() + " " + emp.getName() + " удален");
        smallBook.getFullInfo();

        employee.setDepartmentNumber(15);
        smallBook.getFullInfo();

        employee.setSalary(200000);
        smallBook.getFullInfo();

        int hash = employee.hashCode();
        System.out.println("Хэш код у объекта " + employee.getName() + " = " + hash);

        boolean name = employee.equals(employee1);
        System.out.println("Результат сравнения объекта " + employee.getName() + " и объекта " + employee1.getName() + " = " + name);



    }
}







