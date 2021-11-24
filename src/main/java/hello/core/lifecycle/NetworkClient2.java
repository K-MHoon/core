package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 외부 네트워크에 미리 연결하는 클래스 (실제 연결 X)
 * @Bean 설정 정보를 통해 init, close 호출
 */
public class NetworkClient2 {

    private String url;

    public NetworkClient2() {
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

    public void init() {
        System.out.println("NetworkClient2.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() {
        System.out.println("NetworkClient2.close");
        disConnect();
    }
}
