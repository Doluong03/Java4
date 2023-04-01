package utils;
//import com.poly.template.entity.DongVat;
import DomainModel.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HIbernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=javaWeb;encrypt=false;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "1");
        properties.put(Environment.SHOW_SQL, "true");
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(ChiTietSP.class);
        configuration.addAnnotatedClass(DongSP.class);
        configuration.addAnnotatedClass(Nsx.class);
        configuration.addAnnotatedClass(ChucVu.class);
        configuration.addAnnotatedClass(HoaDon.class);
        configuration.addAnnotatedClass(HoaDonChiTiet.class);
        configuration.addAnnotatedClass(KhachHang.class);
        configuration.addAnnotatedClass(MauSac.class);
        configuration.addAnnotatedClass(GioHang.class);
        configuration.addAnnotatedClass(GioHangChiTIet.class);
        configuration.addAnnotatedClass(SanPham.class);
        configuration.addAnnotatedClass(NhanVien.class);
        configuration.addAnnotatedClass(CuaHang.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
         sessionFactory = configuration.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return sessionFactory ;

    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
