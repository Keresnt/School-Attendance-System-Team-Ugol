/**
 * Represents a Student with personal and contact information.
 */
public class Student {

    private int studentId;          // Unique student ID
    private String firstName;       // First name
    private String lastName;        // Last name
    private String dateOfBirth;     // Date of birth (yyyy-mm-dd)
    private String address;         // Home address
    private String email;           // Email address
    private String guardianName;    // Guardian's name
    private String phoneNumber;     // Phone number

    /**
     * Initializes a Student object with the given details.
     */
    public Student(int studentId, String firstName, String lastName, String dateOfBirth, String address, String email, String guardianName, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.guardianName = guardianName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters for each field
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGuardianName() { return guardianName; }
    public void setGuardianName(String guardianName) { this.guardianName = guardianName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
