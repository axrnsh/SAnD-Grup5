public class TaskRequest {
    private int nomorTaskRequest;
    private String tenant;
    private String tanggalPermintaan;
    private String waktuPermintaan;
    private String operator;
    private String taskDiRequestOleh;
    private String teknisiYangDitugaskan;
    private String tanggalPermintaanDiselesaikan;
    private String status;

    public TaskRequest() {
    }

    public TaskRequest(int nomorTaskRequest, String tenant, String tanggalPermintaan, String waktuPermintaan,
            String operator, String taskDiRequestOleh, String teknisiYangDitugaskan) {
        this.nomorTaskRequest = nomorTaskRequest;
        this.tenant = tenant;
        this.tanggalPermintaan = tanggalPermintaan;
        this.waktuPermintaan = waktuPermintaan;
        this.operator = operator;
        this.taskDiRequestOleh = taskDiRequestOleh;
        this.teknisiYangDitugaskan = teknisiYangDitugaskan;
    }

    public TaskRequest(int nomorTaskRequest, String tenant, String tanggalPermintaan, String waktuPermintaan,
            String operator, String taskDiRequestOleh, String teknisiYangDitugaskan,
            String tanggalPermintaanDiselesaikan, String status) {
        this.nomorTaskRequest = nomorTaskRequest;
        this.tenant = tenant;
        this.tanggalPermintaan = tanggalPermintaan;
        this.waktuPermintaan = waktuPermintaan;
        this.operator = operator;
        this.taskDiRequestOleh = taskDiRequestOleh;
        this.teknisiYangDitugaskan = teknisiYangDitugaskan;
        this.tanggalPermintaanDiselesaikan = tanggalPermintaanDiselesaikan;
        this.status = status;
    }

    public int getNomorTaskRequest() {
        return this.nomorTaskRequest;
    }

    public void setNomorTaskRequest(int nomorTaskRequest) {
        this.nomorTaskRequest = nomorTaskRequest;
    }

    public String getTenant() {
        return this.tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getTanggalPermintaan() {
        return this.tanggalPermintaan;
    }

    public void setTanggalPermintaan(String tanggalPermintaan) {
        this.tanggalPermintaan = tanggalPermintaan;
    }

    public String getWaktuPermintaan() {
        return this.waktuPermintaan;
    }

    public void setWaktuPermintaan(String waktuPermintaan) {
        this.waktuPermintaan = waktuPermintaan;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTaskDiRequestOleh() {
        return this.taskDiRequestOleh;
    }

    public void setTaskDiRequestOleh(String taskDiRequestOleh) {
        this.taskDiRequestOleh = taskDiRequestOleh;
    }

    public String getTeknisiYangDitugaskan() {
        return this.teknisiYangDitugaskan;
    }

    public void setTeknisiYangDitugaskan(String teknisiYangDitugaskan) {
        this.teknisiYangDitugaskan = teknisiYangDitugaskan;
    }

    public String getTanggalPermintaanDiselesaikan() {
        return this.tanggalPermintaanDiselesaikan;
    }

    public void setTanggalPermintaanDiselesaikan(String tanggalPermintaanDiselesaikan) {
        this.tanggalPermintaanDiselesaikan = tanggalPermintaanDiselesaikan;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return 
            "Nomor Task Request\t\t: " + getNomorTaskRequest() + 
            "\nTenant\t\t\t\t: " + getTenant() + 
            "\nTanggal Permintaan\t\t: " + getTanggalPermintaan() + 
            "\nWaktu Permintaan\t\t: " + getWaktuPermintaan() + 
            "\nOperator\t\t\t: " + getOperator() + 
            "\nTask DiRequest Oleh\t\t: " + getTaskDiRequestOleh() + 
            "\nTeknisi Yang Ditugaskan\t\t: " + getTeknisiYangDitugaskan() + 
            "\nTanggal Permintaan Diselesaikan : " + getTanggalPermintaanDiselesaikan() +
            "\nStatus\t\t\t\t: " + getStatus();
    }    
}