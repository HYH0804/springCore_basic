package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>(); //메모리에 저장할려다보니까 Map을 쓰게 됨, MemoryMemberRepository의 인스턴스를 만들면 얘네는 모두 저장된 Member을 공유해야되니까 static
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
