package pull_up.api.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@Entity
@Table(name = "member")
@SQLDelete(sql = "UPDATE member m SET m.deleted_at = current_timestamp WHERE m.id = ?")
@SQLRestriction("deleted_at is NULL")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column
    private String name;

    @Setter
    @Column
    private String email;

    @Setter
    @Column
    private boolean accessCheck;

    @Column
    private LocalDateTime deletedAt; // 삭제 여부

    protected Member() {
    }

    /**
     * 파라미터 생성자.
     */
    private Member(String name, String email, boolean accessCheck) {
        this.name = name;
        this.email = email;
        this.accessCheck = accessCheck;
        this.deletedAt = null;
    }

    /**
     * 파라미터로부터 멤버 엔티티 객체를 생성하는 함수.
     */
    public static Member of(String name, String email, boolean accessCheck) {
        return new Member(name, email, accessCheck);
    }
}
