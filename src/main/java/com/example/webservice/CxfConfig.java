import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    @Bean
    public JaxWsServerFactoryBean myService() {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(MyServiceInterface.class);
        factory.setAddress("/MyService");
        return factory;
    }

    @Bean
    public MyServiceInterface myServiceClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyServiceInterface.class);
        factory.setAddress("http://localhost:8080/MyService");
        return (MyServiceInterface) factory.create();
    }
}