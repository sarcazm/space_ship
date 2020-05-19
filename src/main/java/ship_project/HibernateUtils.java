package ship_project;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ship_project.entity.Ship;


import java.util.HashMap;
import java.util.Map;

//@Component
public class HibernateUtils {

    private static SessionFactory ourSessionFactory;
    private static StandardServiceRegistry registry;

    public HibernateUtils() {
    }

    public static SessionFactory getSessionFactory() {
        try {
            if (ourSessionFactory == null) {
                StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> settings = new HashMap<String, String>();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/space_ships");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

                serviceRegistryBuilder.applySettings(settings);
                registry = serviceRegistryBuilder.build();
                MetadataSources sources = new MetadataSources(registry);
                //тут добаляем потом аантоации
                sources.addAnnotatedClass(Ship.class);
                Metadata metadata =  sources.getMetadataBuilder().build();
                ourSessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            if (registry != null)StandardServiceRegistryBuilder.destroy(registry);
        }

        return ourSessionFactory;
    }

    public static void closeSessionFactory(){
        if (registry != null)StandardServiceRegistryBuilder.destroy(registry);

    }
}
