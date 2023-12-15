public class Tenant {
    private int tenant;
    private String namaPerusahaan;
    private String nomorUnit;
    private String lantai;
    private String gedung;
    private String contactPerson;
    private int nomorTelepon;
    private String email;
    private String infoSpesifikasi;

    public Tenant(int tenant, String namaPerusahaan, String nomorUnit, String lantai, String gedung,
                  String contactPerson, int nomorTelepon, String email, String infoSpesifikasi) {
        this.tenant = tenant;
        this.namaPerusahaan = namaPerusahaan;
        this.nomorUnit = nomorUnit;
        this.lantai = lantai;
        this.gedung = gedung;
        this.contactPerson = contactPerson;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
        this.infoSpesifikasi = infoSpesifikasi;
    }
    public int getTenant() {
        return tenant;
    }

    public void setTenant(int tenant) {
        this.tenant = tenant;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNomorUnit() {
        return nomorUnit;
    }

    public void setNomorUnit(String nomorUnit) {
        this.nomorUnit = nomorUnit;
    }

    public String getLantai() {
        return lantai;
    }

    public void setLantai(String lantai) {
        this.lantai = lantai;
    }

    public String getGedung() {
        return gedung;
    }

    public void setGedung(String gedung) {
        this.gedung = gedung;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(int nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfoSpesifikasi() {
        return infoSpesifikasi;
    }

    public void setInfoSpesifikasi(String infoSpesifikasi) {
        this.infoSpesifikasi = infoSpesifikasi;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenant=" + tenant +
                ", namaPerusahaan='" + namaPerusahaan + '\'' +
                ", nomorUnit='" + nomorUnit + '\'' +
                ", lantai='" + lantai + '\'' +
                ", gedung='" + gedung + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", nomorTelepon=" + nomorTelepon +
                ", email='" + email + '\'' +
                ", infoSpesifikasi='" + infoSpesifikasi + '\'' +
                '}';
    }
}