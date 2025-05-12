public class Main1 {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        employeeDAO.addEmployee("Marina", 30, "Manager", 5000);
        employeeDAO.addEmployee("Olga", 25, "Developer", 4000);

        System.out.println("List of employees:");
        employeeDAO.getAllEmployees();

        employeeDAO.updateEmployeeSalary(1, 5500);
        System.out.println("\nAfter updating the salary:");
        employeeDAO.getAllEmployees();

        employeeDAO.deleteEmployee(2);
        System.out.println("\nAfter deletion:");
        employeeDAO.getAllEmployees();

    }
}
