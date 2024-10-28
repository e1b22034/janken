package oit.is.z2409.kaizi.janken.model;

import java.util.Random;

public class Janken {
  private String cpuHand;

  public String play(String userHand) {
    String[] hands = { "Gu", "Choki", "Pa" };
    Random random = new Random();
    cpuHand = hands[random.nextInt(3)];

    if (userHand.equals(cpuHand)) {
      return "Draw";
    } else if ((userHand.equals("Gu") && cpuHand.equals("Choki")) ||
        (userHand.equals("Choki") && cpuHand.equals("Pa")) ||
        (userHand.equals("Pa") && cpuHand.equals("Gu"))) {
      return "You Win!";
    } else {
      return "You Lose!";
    }
  }

  public String getCpuHand() {
    return cpuHand;
  }
}
