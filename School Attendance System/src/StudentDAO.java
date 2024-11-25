import java.sql.*;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        try {
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance", "root", "nemuimors");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch existing student info from the database (Read)
    public Student getStudentById(int studentId) {
        Student student = null;
        try {
            String query = "SELECT * FROM students WHERE student_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("date_of_birth"),
                    rs.getString("address"),
                    rs.getString("email"),
                    rs.getString("guardian_name"),
                    rs.getString("phone_number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Update student info in the database (Update)
    public void updateStudent(Student student) {
        try {
            String query = "UPDATE students SET first_name=?, last_name=?, date_of_birth=?, address=?, email=?, guardian_name=?, phone_number=? WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getDateOfBirth());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getGuardianName());
            ps.setString(7, student.getPhoneNumber());
            ps.setInt(8, student.getStudentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
