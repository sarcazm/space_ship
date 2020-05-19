package ship_project;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ship_project.service.ShipService;

import javax.servlet.ServletContext;


@Configuration
@EnableWebMvc
@ComponentScan("ship_project.rest")
//@PropertySource("user.properties")
public class SpringConfig {

    @Bean
    public SessionFactory getSessionFactory(){
        return HibernateUtils.getSessionFactory();
    }
    @Bean
    public ShipService getShipService(){
        return new ShipService(getSessionFactory()/*, getGson()*/);
    }




}
