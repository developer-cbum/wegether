package com.wegether.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberNickname;
    private String memberPhoneNumber;
    private boolean memberStatus;
    private String  memberGrade;
    private String memberRegisterDate;
    private String memberUpdateDate;
    private String memberPoint;
    private String memberShcool;
    private String memberMajor;
    private String memberIntroducing;
    private long fileId;
    private String memberLoginStatus;
}
