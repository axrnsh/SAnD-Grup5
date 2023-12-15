public class UserOperator extends User implements Menu {

    @Override
    public void showMenu() {
        System.out.println("\nMenu:");
        System.out.println(" 1. Membuat task request baru");
        System.out.println(" 2. Tampilkan task request");
        System.out.println(" 3. Update task request");
        System.out.println(" 0. Logout");
    }
}