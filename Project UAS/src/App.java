import java.util.ArrayList;
import java.util.Scanner;

//dikarenakan keterbatasan waktu, kode program tidak terlalu lengkap
//hasil speedrun sehari, jadi jangan berharap banyak TT
public class App {
    public static ArrayList<TaskRequest> arrayTaskRequest = new ArrayList<TaskRequest>();
    public static ArrayList<Tenant> arrayTenant = new ArrayList<Tenant>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        clearScreen();
        init();
        boolean loggedIn = false;
        boolean selesai = false;

        do {
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("\nPilihan: ");

            String pilih;
            pilih = scanner.nextLine();

            switch (pilih) {
                case "1":
                    if (!loggedIn) {
                        clearScreen();
                        //username dan password dapat dilihat pada file users.csv
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        clearScreen();

                        if (Login.login(username, password)) {
                            loggedIn = true;
                            String role = Login.posisi(username);

                            do {
                                if (role.equals("manajer")) {
                                    UserManajer manajerLogin = new UserManajer();
                                    manajerLogin.showMenu();
                                    System.out.print("\nPilihan: ");

                                    String pilihanLagi;
                                    pilihanLagi = scanner.nextLine();

                                    switch (pilihanLagi) {
                                        case "1":
                                            tambahTenant();
                                            break;
                                        case "2":
                                            generateLaporan();
                                            break;
                                        case "0":
                                            clearScreen();
                                            System.out.println("Logout berhasil!");
                                            loggedIn = false;
                                            break;
                                        default:
                                            System.out.println("Masukkan angka yang valid");
                                            break;
                                    }
                                }

                                else if (role.equals("operator")) {
                                    UserOperator operatorLogin = new UserOperator();
                                    operatorLogin.showMenu();
                                    System.out.print("\nPilihan: ");

                                    String pilihanLagi;
                                    pilihanLagi = scanner.nextLine();

                                    switch (pilihanLagi) {
                                        case "1":
                                            addTaskRequest();
                                            break;
                                        case "2":
                                            showTaskRequest();
                                            break;
                                        case "3":
                                            updateTaskRequest();
                                            break;
                                        case "0":
                                            clearScreen();
                                            System.out.println("Logout berhasil! \n");
                                            loggedIn = false;
                                            break;
                                        default:
                                            System.out.println("\nMasukkan angka yang valid");
                                            break;
                                    }
                                }

                                else {
                                    System.out.println("Posisi tidak valid");
                                    loggedIn = false;
                                }
                            } while (loggedIn);
                        }
                    }
                    break;
                case "2":
                    System.out.println("Terima kasih sudah menggunakan Sistem ini!");
                    selesai = true;
                    break;
                default:
                    System.out.println("Masukkan angka yang valid");
                    break;
            }
        } while (!selesai);
        scanner.close();
    }

    public static void addTaskRequest() {
        clearScreen();
        try {
            System.out.println("Input data berikut!");
            System.out.print("Nomor Task Request\t: ");
            int nomorTaskRequest = Integer.parseInt(scanner.nextLine());
            System.out.print("Nama Perusahaan Tenant\t: ");
            String nomorTenant = scanner.nextLine();
            System.out.print("Tanggal Permintaan\t: ");
            String tanggalPermintaan = scanner.nextLine();
            System.out.print("Waktu Permintaan\t: ");
            String waktuPermintaan = scanner.nextLine();
            System.out.print("Operator\t\t: ");
            String operator = scanner.nextLine();
            System.out.print("Task di Request oleh\t: ");
            String taskDiRequestOleh = scanner.nextLine();
            System.out.print("Teknisi yang Ditugaskan\t: ");
            String teknisiYangDitugaskan = scanner.nextLine();

            TaskRequest taskRequest = new TaskRequest(nomorTaskRequest, nomorTenant, tanggalPermintaan,
                    waktuPermintaan, operator, taskDiRequestOleh, teknisiYangDitugaskan);

            arrayTaskRequest.add(taskRequest);
            clearScreen();
            System.out.println("Input Task Request berhasil!");
        } catch (NumberFormatException e) {
            System.out.println("Input nomor task request harus berupa angka: " + e);
        }

    }

    public static void showTaskRequest() {
        clearScreen();
        try {
            System.out.println("Masukkan Nomor Task Request yang ingin ditampilkan:");
            System.out.print("Nomor Task Request\t: ");
            int nomorTaskRequest = Integer.parseInt(scanner.nextLine());

            TaskRequest taskRequestToShow = findTaskRequestByNomor(nomorTaskRequest);

            if (taskRequestToShow != null) {
                System.out.println("\nInformasi Task Request\t:");
                System.out.println(taskRequestToShow.toString());
            } else {
                System.out
                        .println("\nTask Request dengan Nomor Task Request " + nomorTaskRequest + " tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input nomor task request harus berupa angka: " + e);
        }
    }

    public static TaskRequest findTaskRequestByNomor(int nomorTaskRequest) {
        for (TaskRequest taskRequest : arrayTaskRequest) {
            if (taskRequest.getNomorTaskRequest() == nomorTaskRequest) {
                return taskRequest;
            }
        }
        return null;
    }

    public static void updateTaskRequest() {
        clearScreen();
        try {
            System.out.println("Masukkan Nomor Task Request yang ingin diupdate:");
            System.out.print("Nomor Task Request\t: ");
            int nomorTaskRequest = Integer.parseInt(scanner.nextLine());

            TaskRequest taskRequestToUpdate = findTaskRequestByNomor(nomorTaskRequest);

            if (taskRequestToUpdate != null) {
                System.out.println("\nInformasi Task Request Sebelum Diupdate:");
                System.out.println(taskRequestToUpdate.toString());
                System.out.print("\nTanggal Permintaan Diselesaikan\t: ");
                String tanggalPermintaanDiselesaikan = scanner.nextLine();
                System.out.print("Status\t\t: ");
                String status = scanner.nextLine();

                taskRequestToUpdate.setTanggalPermintaanDiselesaikan(tanggalPermintaanDiselesaikan);
                taskRequestToUpdate.setStatus(status);

                System.out.println("\nInformasi Task Request Setelah Diupdate:");
                System.out.println(taskRequestToUpdate.toString());
            } else {
                System.out
                        .println("\nTask Request dengan Nomor Task Request " + nomorTaskRequest + " tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input nomor task request harus berupa angka: " + e);
        }
    }

    public static void tambahTenant() {
        clearScreen();
        try {
            System.out.println("Input data Tenant berikut!");

            System.out.print("Nomor Tenant\t: ");
            int nomorTenant = Integer.parseInt(scanner.nextLine());
            System.out.print("Nama Perusahaan\t: ");
            String namaPerusahaan = scanner.nextLine();
            System.out.print("Nomor Unit\t: ");
            String nomorUnit = scanner.nextLine();
            System.out.print("Lantai\t\t: ");
            String lantai = scanner.nextLine();
            System.out.print("Gedung\t\t: ");
            String gedung = scanner.nextLine();
            System.out.print("Contact Person\t: ");
            String contactPerson = scanner.nextLine();
            System.out.print("Nomor Telepon\t: ");
            int nomorTelepon = Integer.parseInt(scanner.nextLine());
            System.out.print("Email\t\t: ");
            String email = scanner.nextLine();
            System.out.print("Info Spesifikasi: ");
            String infoSpesifikasi = scanner.nextLine();

            Tenant newTenant = new Tenant(nomorTenant, namaPerusahaan, nomorUnit, lantai, gedung,
                    contactPerson, nomorTelepon, email, infoSpesifikasi);

            arrayTenant.add(newTenant);
            clearScreen();
            System.out.println("Input Tenant berhasil!");
        } catch (NumberFormatException e) {
            System.out.println("Input nomor tenant dan nomor telepon harus berupa angka: " + e);
        }
    }

    public static void generateLaporan() {
        clearScreen();
        try {
            System.out.print("Masukkan nomor Tenant untuk menampilkan laporan: ");
            int nomorTenant = Integer.parseInt(scanner.nextLine());

            Tenant tenant = findTenantByNomor(nomorTenant);

            if (tenant != null) {
                ArrayList<TaskRequest> taskRequestsForTenant = findTaskRequestsByTenant(tenant.getNamaPerusahaan());

                if (!taskRequestsForTenant.isEmpty()) {
                    GenerateLaporan generateLaporan = new GenerateLaporan(taskRequestsForTenant);
                    generateLaporan.tampilkanLaporanByTenant(tenant.getNamaPerusahaan());
                } else {
                    System.out.println(
                            "\nTidak ada Task Request yang terkait dengan Tenant " + tenant.getNamaPerusahaan());
                }
            } else {
                System.out.println("\nTenant dengan Nomor Tenant " + nomorTenant + " tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input nomor tenant harus berupa angka: " + e);
        }
    }

    public static Tenant findTenantByNomor(int nomorTenant) {
        for (Tenant tenant : arrayTenant) {
            if (tenant.getTenant() == nomorTenant) {
                return tenant;
            }
        }
        return null;
    }

    public static ArrayList<TaskRequest> findTaskRequestsByTenant(String tenantName) {
        ArrayList<TaskRequest> result = new ArrayList<>();

        for (TaskRequest taskRequest : arrayTaskRequest) {
            if (taskRequest.getTenant().equalsIgnoreCase(tenantName)) {
                result.add(taskRequest);
            }
        }

        return result;
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\u001b[2J\u001b[H");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Gagal melakukan clear screen: " + e.getMessage());
        }
    }

    public static void init() {
        Tenant tenant1 = new Tenant(10001, "Omoide", "8Q", "Lantai 1", "Gedung A",
                "John Doe", 123456789, "john.doe@example.com", "Spesifikasi A");
        Tenant tenant2 = new Tenant(10002, "Shiritori", "30A", "Lantai G", "Gedung B",
                "Jane Doe", 987654321, "jane.doe@example.com", "Spesifikasi B");
        arrayTenant.add(tenant1);
        arrayTenant.add(tenant2);

        TaskRequest taskRequest1 = new TaskRequest(50001, "Omoide", "2022-12-01", "08:00",
                "Operator A", "John Doe", "Teknisi X", "2022-12-02", "Selesai");
        TaskRequest taskRequest2 = new TaskRequest(50002, "Shiritori", "2022-12-02", "10:30",
                "Operator B", "Jane Doe", "Teknisi Y", "2022-12-03", "Selesai");
        arrayTaskRequest.add(taskRequest1);
        arrayTaskRequest.add(taskRequest2);
    }

}
