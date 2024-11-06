import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MonthSignupController {

    @Autowired
    private MonthSignupRepository signupRepository;

    @GetMapping("/signup-analysis")
    public String getSignupAnalysis(Model model) {
        LocalDate startDate = LocalDate.now().minusMonths(5);                                   // 최근 5개월 데이터 가져오기
        List<MonthlySignupCount> monthlySignupData = signupRepository.countSignupsByMonth(startDate);

        model.addAttribute("monthlySignupData", monthlySignupData);
        return "signupAnalysis";
    }
}
