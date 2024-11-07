import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class ClickStatsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 외부 클릭 데이터 가져오기 (예시: DB에서 데이터 가져오기)
    public ClickStatsVO getExternalClickData() {
        String sql = "SELECT tree_clicks, street_clicks, protected_tree_clicks FROM click_stats WHERE id = 1";
        
        // 데이터 조회
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            ClickStatsVO stats = new ClickStatsVO();
            stats.setTreeClicks(rs.getInt("tree_clicks"));
            stats.setStreetClicks(rs.getInt("street_clicks"));
            stats.setProtectedTreeClicks(rs.getInt("protected_tree_clicks"));
            return stats;
        });
    }

    // 클릭 데이터를 매일 자정에 초기화
    public void resetClickStats() {
        String sql = "UPDATE click_stats SET tree_clicks = 0, street_clicks = 0, protected_tree_clicks = 0 WHERE id = 1";
        jdbcTemplate.update(sql);
    }
}
