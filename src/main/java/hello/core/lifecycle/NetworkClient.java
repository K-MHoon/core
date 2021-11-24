package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 외부 네트워크에 미리 연결하는 클래스 (실제 연결 X)
 * InitializingBean, DisposableBean 구현체 구현.
 */
public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    public void disConnect() {
        System.out.println("close + " + url);
    }

    /**
     * DisposableBean 구현체 = 메소드 소멸
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        disConnect();
    }

    /**
     * InitializingBean 구현체 = 메소드 초기화
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }
}
