package iuh.fit.se.baitap01.entities;

public class Student {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String fb;
    private String bio;

    public Student() {}

    public Student(String firstName, String lastName, String username, String email,
                   String password, String fb, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fb = fb;
        this.bio = bio;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFb() { return fb; }
    public void setFb(String fb) { this.fb = fb; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
}
