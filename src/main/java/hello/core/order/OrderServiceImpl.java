package hello.core.order;

import hello.core.discount.DIscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DIscountPolicy discountPolicy;

    //setter로 DI
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository= memberRepository;
//    }
//    public void setDiscountPolicy(DIscountPolicy discountPolicy){
//        this.discountPolicy= discountPolicy;
//    }

     //생성자로 DI
    //lombok @RequiredArgsConstructor로 아래 생성자 자동으로 만들어줌
     @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DIscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);

    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
