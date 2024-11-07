import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.Scheduled;

@RestController
public class ClickStatsController {

    @Autowired
    private ClickStatsDAO clickStatsDAO;

    // 외부 클릭 통계 데이터 제공
    @GetMapping("/api/clicks/external")
    public ClickStatsVO getExternalClickData() {
        return clickStatsDAO.getExternalClickData();
    }

    // 매일 자정에 클릭 통계 초기화
    @Scheduled(cron = "0 0 0 * * *")  // 자정에 실행되는 스케줄러
    public void resetClickStatsDaily() {
        clickStatsDAO.resetClickStats();
    }
}
