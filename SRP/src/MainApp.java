public class MainApp {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        UserService userService = new UserService(notificationService);
        
        userService.registerUser("abc", "abc@gmail.com");
    }
}
