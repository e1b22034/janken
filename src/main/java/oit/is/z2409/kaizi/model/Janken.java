package oit.is.z2409.kaizi.model;

public class Janken {
  private String userHand; // ユーザーの手
  private String cpuHand; // CPUの手
  private String result; // 結果

  public Janken(String userHand, String cpuHand) {
    this.userHand = userHand;
    this.cpuHand = cpuHand;
    this.result = determineResult(userHand, cpuHand);
  }

  // 結果を判定するメソッド
  private String determineResult(String userHand, String cpuHand) {
    if (userHand.equals(cpuHand)) {
      return "引き分け";
    } else if ((userHand.equals("rock") && cpuHand.equals("scissors")) ||
        (userHand.equals("scissors") && cpuHand.equals("paper")) ||
        (userHand.equals("paper") && cpuHand.equals("rock"))) {
      return "あなたの勝ち";
    } else {
      return "あなたの負け";
    }
  }

  // ゲッター
  public String getUserHand() {
    return userHand;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public String getResult() {
    return result;
  }
}
