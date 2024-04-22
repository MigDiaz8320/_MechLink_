package Model;

public class CurrentUser {
    //Kinda Jank solution to determining current user & attributes
    static String CurrentUserName = "";
    static boolean isMechanic = false;

    public static String getCurrentUserName() {
        return CurrentUserName;
    }

    public static void setCurrentUserName(String currentUserName) {
        CurrentUserName = currentUserName;
    }

    public static boolean IsMechanic() {
        return isMechanic;
    }

    public static void setIsMechanic(boolean isMechanic) {
        CurrentUser.isMechanic = isMechanic;
    }

    public static String CurrentUserData() {
        return("Current Username is: " + getCurrentUserName() + " Current User is mechanic? " + IsMechanic());
    }
}
