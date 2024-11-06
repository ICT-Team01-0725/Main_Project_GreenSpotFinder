import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "monthly_signup")
public class MonthSignupData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signup_date", nullable = false)
    private LocalDate signupDate;

    // Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDate signupDate) {
        this.signupDate = signupDate;
    }
}

