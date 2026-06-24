DROP TABLE security_member;
CREATE TABLE security_member (
                                 NO NUMBER CONSTRAINT security_member_no_pk PRIMARY KEY,
                                 USER_ID varchar2(100) CONSTRAINT security_member_userid_nn NOT NULL
						  CONSTRAINT security_member_userid_uk UNIQUE,
                                 USER_PW varchar2(100) CONSTRAINT security_member_userpw_nn NOT NULL,
                                 USER_NAME varchar2(100) CONSTRAINT security_member_username_nn NOT NULL,
                                 USER_EMAIL varchar2(100) CONSTRAINT security_member_useremail_nn NOT NULL,
                                 ROLE    varchar2(20)  DEFAULT 'ROLE_USER' CONSTRAINT security_member_role_nn NOT NULL,
                                 REGDATE DATE DEFAULT sysdate
);
DROP TABLE security_member;
CREATE SEQUENCE seq_sequrity_member
    START WITH 1
    INCREMENT BY 1
    nocache
nocycle;

SELECT * FROM security_member;

CREATE TABLE security_board (
                                NO NUMBER CONSTRAINT security_board_no_pk PRIMARY KEY,
                                TITLE varchar2(1000) CONSTRAINT security_board_title_nn NOT NULL ,
                                CONTENT varchar2(3000) CONSTRAINT security_board_content_nn NOT NULL,
                                hit     NUMBER  DEFAULT 1,
                                REGDATE DATE DEFAULT sysdate
);

CREATE SEQUENCE seq_security_board
    START WITH 1
    INCREMENT BY 1
    nocache
nocycle;

SELECT * FROM security_board;

DELETE  FROM security_member;
COMMIT;


