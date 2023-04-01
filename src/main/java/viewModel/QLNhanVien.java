package viewModel;

    public class QLNhanVien {
        private String ma;
        private String ho;
        private String ten_dem;
        private String ten;
        private String ngay_sinh;
        private String sdt;
        private String dia_chi;
        private String trang_thai;
        private String mat_khau;
        private String gioi_tinh;

        public QLNhanVien() {
        }

        public QLNhanVien(String ma, String ho, String ten_dem, String ten, String ngay_sinh, String sdt, String dia_chi, String trang_thai, String mat_khau, String gioi_tinh) {
            this.ma = ma;
            this.ho = ho;
            this.ten_dem = ten_dem;
            this.ten = ten;
            this.ngay_sinh = ngay_sinh;
            this.sdt = sdt;
            this.dia_chi = dia_chi;
            this.trang_thai = trang_thai;
            this.mat_khau = mat_khau;
            this.gioi_tinh = gioi_tinh;
        }

        public String getMa() {
            return ma;
        }

        public void setMa(String ma) {
            this.ma = ma;
        }

        public String getHo() {
            return ho;
        }

        public void setHo(String ho) {
            this.ho = ho;
        }

        public String getTen_dem() {
            return ten_dem;
        }

        public void setTen_dem(String ten_dem) {
            this.ten_dem = ten_dem;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getNgay_sinh() {
            return ngay_sinh;
        }

        public void setNgay_sinh(String ngay_sinh) {
            this.ngay_sinh = ngay_sinh;
        }

        public String getSdt() {
            return sdt;
        }

        public void setSdt(String sdt) {
            this.sdt = sdt;
        }

        public String getDia_chi() {
            return dia_chi;
        }

        public void setDia_chi(String dia_chi) {
            this.dia_chi = dia_chi;
        }

        public String getTrang_thai() {
            return trang_thai;
        }

        public void setTrang_thai(String trang_thai) {
            this.trang_thai = trang_thai;
        }

        public String getMat_khau() {
            return mat_khau;
        }

        public void setMat_khau(String mat_khau) {
            this.mat_khau = mat_khau;
        }

        public String getGioi_tinh() {
            return gioi_tinh;
        }

        public void setGioi_tinh(String gioi_tinh) {
            this.gioi_tinh = gioi_tinh;
        }
    }




