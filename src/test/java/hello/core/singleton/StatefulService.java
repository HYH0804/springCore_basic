package hello.core.singleton;

public class StatefulService {
   // private int price; //상태 유지하는 필드   10000 >> 20000    / 얘는 지금 전역변수니까 무상태로 만들어야되서 빼야함
//    public void order(String name,int price){
//        System.out.println("name = " + name+" price ="+price);
//        this.price = price; //여기가 문제
//    }

    public int order(String name,int price){
        System.out.println("name = " + name+" price ="+price);
        //this.price = price; //여기가 문제
        return price;
    }
//    public int getPrice(){
//        return price;
//    }   //무상태로 만들다보니 멤버전역변수 price가 없으니까 당연히 getPrice도 필요없
}
