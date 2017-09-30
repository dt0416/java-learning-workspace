package ln.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

/**
 * Optional可以替null省去很多不必要的麻煩
 * 
 * @author Ian Chen
 */
public class A4_OptionalTest {

  @Test
  public void testOptional() {
    // 1.7前寫法
    String nickName = this.getNickName("Duke");
    if (nickName == null) {
        nickName = "Openhome Reader";
    }
    System.out.println(nickName);
    
    // Optional 寫法，仍是有點囉嗦
    Optional<String> nickOptional = this.getOptionNickName("Duke");
    nickName = "Openhome Reader";
    if (nickOptional.isPresent()) {
      nickName = nickOptional.get();
    }
    System.out.println(nickName);
    
    // Optional + orElse() 寫法
    nickOptional = this.getOptionNickName("Duke");
    nickName = nickOptional.orElse("Openhome Reader");
    System.out.println(nickName);
  }

  private String getNickName(String name) {
    Map<String, String> nickNames = new HashMap<>();
    nickNames.put("Justin", "caterpillar");
    nickNames.put("Monica", "momor");
    nickNames.put("Irene", "hamimi");
    return nickNames.get(name);
  }
  
  private Optional<String> getOptionNickName(String name) {
    Map<String, String> nickNames = new HashMap<>();
    nickNames.put("Justin", "caterpillar");
    nickNames.put("Monica", "momor");
    nickNames.put("Irene", "hamimi");
    String nickName = nickNames.get(name);
//    return nickName == null ? Optional.empty() : Optional.of(nickName);
    // 上一行可以更精簡的改成下一行
    return Optional.ofNullable(nickName);
  }
}
