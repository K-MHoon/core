package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
//        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
//        NetworkClient client = ac.getBean(NetworkClient.class);
//        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
//        NetworkClient2 client = ac.getBean(NetworkClient2.class);
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig3.class);
        NetworkClient3 client = ac.getBean(NetworkClient3.class);
        ac.close();
    }

    /**
     * 구현체로 초기화,소멸
     */
//    @Configuration
//    static class LifeCycleConfig {
//
//        @Bean
//        public NetworkClient networkClient() {
//            NetworkClient networkClient = new NetworkClient();
//            networkClient.setUrl("http://hello-spirng.dev");
//            return networkClient;
//        }
//    }

//    /**
//     * Bean 설정으로 지정
//     */
//    @Configuration
//    static class LifeCycleConfig2 {
//
//        @Bean(initMethod = "init", destroyMethod = "close")
//        public NetworkClient2 networkClient() {
//            NetworkClient2 networkClient = new NetworkClient2();
//            networkClient.setUrl("http://hello-spirng.dev");
//            return networkClient;
//        }
//    }

    /**
     * 어노테이션 활용
     */
    @Configuration
    static class LifeCycleConfig3 {

        @Bean
        public NetworkClient3 networkClient() {
            NetworkClient3 networkClient = new NetworkClient3();
            networkClient.setUrl("http://hello-spirng.dev");
            return networkClient;
        }
    }
}