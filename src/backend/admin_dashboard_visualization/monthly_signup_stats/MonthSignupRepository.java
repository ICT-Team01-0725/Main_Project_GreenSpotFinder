import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MonthSignupRepository extends JpaRepository<MonthSignupData, Long> {

    @Query("SELECT new com.example.dto.MonthlySignupCount(MONTH(s.signupDate), COUNT(s)) " +
           "FROM MonthSignupData s " +
           "WHERE s.signupDate >= :startDate " +
           "GROUP BY MONTH(s.signupDate)")
    List<MonthlySignupCount> countSignupsByMonth(LocalDate startDate);
}

