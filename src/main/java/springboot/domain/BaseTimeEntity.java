package springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPAEntity 클래스들이 BaseTimeEntity을 상속할 경우 칼럼을 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 추가
public class BaseTimeEntity {

    @CreatedDate // 생성되어 저장될 때 시간 자동생성
    private LocalDateTime createdDate;

    @LastModifiedDate // 수정 시 시간 자동저장
    private LocalDateTime modifiedDate;
}
