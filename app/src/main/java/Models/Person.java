package Models;

public class Person {
    private String firstName;
    private String lastName;
    private double salary;
    private int age;
    private String email;
    private String position;

    public Person(String firstName, String lastName, double salary, int age, String email, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
        this.email = email;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Full Name: " + firstName + " " + lastName + "\n" +
                "Salary: $" + salary + "\n" +
                "Age: " + age + "\n" +
                "Email: " + email + "\n" +
                "Position=: " + position + "\n";
    }
}
