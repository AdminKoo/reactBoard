package com.adminKoo.reactboard.global.util;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//생성시간과 수정시간 등록
//JPA의 Auditing을 사용하여 구현하도록 하겠습니다.
//생성시간과 수정시간은
//모든 엔티티에서 사용할 것이므로
// @MappedSupperclass를 사용하여 여러 엔티티가 상속받을 수 있도록 만들어주겠습니다.
//Auditing을 사용하시면 @EnableAuditing을 꼭 스프링 부트 설정 클래스에 적용해야 합니다.
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name = "create_at", updatable = false)
    private String createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private String modifiedAt;

    @PrePersist
    public void onPrePersist(){
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.modifiedAt = this.createdAt;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.modifiedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}
