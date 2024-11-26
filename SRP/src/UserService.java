// Follows SRP: Each class has a single responsibility
public class UserService {
    
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String username, String email) {
        // Register the user (responsibility 1)
        System.out.println("User registered: " + username);
        saveUserData(username, email);
        
        // Delegate notification responsibility
        notificationService.sendNotification(email);
    }

    private void saveUserData(String username, String email) {
        // Logic to save user data in the database
        System.out.println("User data saved: " + username + " (" + email + ")");
    }
}
