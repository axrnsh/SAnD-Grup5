import java.util.ArrayList;

public class GenerateLaporan {
    private ArrayList<TaskRequest> taskRequests;

    public GenerateLaporan(ArrayList<TaskRequest> taskRequests) {
        this.taskRequests = taskRequests;
    }

    public ArrayList<TaskRequest> getTaskRequests() {
        return taskRequests;
    }

    public void setTaskRequests(ArrayList<TaskRequest> taskRequests) {
        this.taskRequests = taskRequests;
    }

    public void tampilkanLaporanByTenant(String tenant) {
        System.out.println("=== Laporan Task Request untuk Tenant " + tenant + " ===");
        for (TaskRequest taskRequest : taskRequests) {
            if (taskRequest.getTenant().equalsIgnoreCase(tenant)) {
                System.out.println(taskRequest);
            }
        }
    }
}
