public class UserManajer extends User implements Menu {

    @Override
    public void showMenu() {
        System.out.println("\nMenu:");
        System.out.println(" 1. Tambah tenant baru");
        System.out.println(" 2. Generate laporan");
        System.out.println(" 0. Logout");
    }
}