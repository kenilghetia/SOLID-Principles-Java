The Single Responsibility Principle (SRP) states that a class should have only one reason to change, meaning it should only have one job or responsibility.

In this example, UserService class has two responsibilities:

- Managing user data (e.g., saving user information).  
- Handling user notifications (e.g., sending an email to the user after registration).

Single Responsibility Violation: UserService has two reasons to change: one for user data management and another for sending notifications.

### Violation of SRP
``` java
class UserService {

    public void registerUser(String username, String email) {
        // Register the user (responsibility 1)
        System.out.println("User registered: " + username);
        saveUserData(username, email);
        
        // Send a notification (responsibility 2)
        sendNotification(email);
    }

    private void saveUserData(String username, String email) {
        // Logic to save user data in the database
        System.out.println("User data saved: " + username + " (" + email + ")");
    }

    private void sendNotification(String email) {
        // Logic to send an email notification
        System.out.println("Sending notification to: " + email);
    }
}
```

``` java
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.registerUser("john_doe", "john.doe@example.com");
    }
}
```

we can refactor the code into two classes, each with one responsibility:

- UserService handles user data management.
- NotificationService handles sending notifications.

If the notification method changes (e.g., sending an SMS instead of email), we only need to modify NotificationService without affecting UserService.
