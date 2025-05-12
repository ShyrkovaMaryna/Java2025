import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class EmployeeDAO {
    public void addEmployee(String name, int age, String position, float salary) {
        String sql = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, position);
            preparedStatement.setFloat(4, salary);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployeeSalary(int id, float newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFloat(1, newSalary);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {
            while (result.next()) {
                System.out.println("ID: " + result.getInt("id") +
                        ", Name: " + result.getString("name") +
                        ", Age: " + result.getInt("age") +
                        ", Position: " + result.getString("position") +
                        ", Salary: " + result.getFloat("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
