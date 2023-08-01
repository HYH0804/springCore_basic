package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instatnce = new SingletonService();

    public static SingletonService getInstance(){
        return instatnce;
    }

    private SingletonService(){
    //싱글톤 private 생성자
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
