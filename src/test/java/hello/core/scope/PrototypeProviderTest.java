package hello.core.scope;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Provider;

import static hello.core.scope.PrototypeTest2.*;

public class PrototypeProviderTest {

    @Test
    @DisplayName("Provider 사용으로 싱글톤을 통해 프로토타입 빈을 사용하는 문제점 해결")
    void providerTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean3.class, PrototypeBean.class);

        ClientBean3 clientBean1 = ac.getBean(ClientBean3.class);
        int count1 = clientBean1.logic();
        Assertions.assertEquals(count1, 1);

        ClientBean3 clientBean2 = ac.getBean(ClientBean3.class);
        int count2 = clientBean2.logic();
        Assertions.assertEquals(count2, 1);
    }

    /**
     * 스프링 애플리케이션 컨텍스트를 직접 호출
     */
    static class ClientBean {

        @Autowired
        private ApplicationContext ac;

        public int logic() {
            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    /**
     * Provider 사용으로 개선 (스프링 의존)
     */
    static class ClientBean2 {

        @Autowired
        private ObjectProvider<PrototypeBean>  prototypeBeanProvider;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    /**
     * JSR-330 Provider (자바 표준)
     */
    static class ClientBean3 {

        @Autowired
        private Provider<PrototypeBean> provider;

        public int logic() {
            PrototypeBean prototypeBean = provider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }
}
