import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderInputDataTest {
  public static LadderInputData getLadderInputDataFixture(String userName, int height, String prizeName) {
    List<User> users = ConsoleInputTest.getUsersFixture(userName);
    LadderHeight ladderHeight = LadderHeightTest.getLadderHeightFixture(height);
    List<Prize> prizes = ConsoleInputTest.getPrizesFixture(prizeName);
    return LadderInputData.of(users, ladderHeight, prizes);
  }

  @Test
  void of_ValidInput_ValidOutput() {
    // given
    List<User> users = new ArrayList<>();
    users.add(User.with(UserName.of("김지우"),0));
    users.add(User.with(UserName.of("조광일"),1));
    LadderHeight height = LadderHeight.of(1);
    List<Prize> prizes = new ArrayList<>();
    prizes.add(Prize.with("꽝",0));
    prizes.add(Prize.with("3000",1));
    // when
    LadderInputData ladderInputData = LadderInputData.of(users, height, prizes);
    // then
    assertThat(ladderInputData.getUsers()).isEqualTo(users);
    assertThat(ladderInputData.getHeight()).isEqualTo(height);
    assertThat(ladderInputData.getPrizes()).isEqualTo(prizes);
  }

  @Test
  void of_InvalidInput_ThrowException() {
    // given
    List<User> users = new ArrayList<>();
    users.add(User.with(UserName.of("김지우"),0));
    LadderHeight height = LadderHeight.of(1);
    List<Prize> prizes = new ArrayList<>();
    prizes.add(Prize.with("꽝",0));
    prizes.add(Prize.with("3000",1));
    // then
    assertThatThrownBy(() -> LadderInputData.of(users, height, prizes)).isInstanceOf(IllegalArgumentException.class);
  }
}
