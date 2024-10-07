package oit.is.z2409.kaizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @GetMapping("/")
  public String index() {
    return "index"; // index.htmlを表示
  }

  @GetMapping("/janken")
  public String janken(@RequestParam String username, @RequestParam(required = false) String hand, Model model) {
    model.addAttribute("username", username);

    if (hand != null) {
      // CPUの手を決定する（例: 常にグー）
      String cpuHand = "rock"; // CPUは常にグーを出す
      String result = determineResult(hand, cpuHand); // 結果を判定

      model.addAttribute("userHand", hand);
      model.addAttribute("cpuHand", cpuHand);
      model.addAttribute("result", result);
    }

    return "janken"; // janken.htmlを表示
  }

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
}
