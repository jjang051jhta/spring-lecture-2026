--1.월드컵 후승후보   7.2  1
--a:브라질
--b:프랑스
--c:아르헨티나
--d:영국
--
--2.점심메뉴 인기순위   7.2
--a:짜장면
--b:짬뽕
--c:순대국밥

--1. vote       a:번호(seq), b:타이틀,c:regdate
--2. vote_item  a:번호(seq), b:vote_no(vote) c:내용(짜장면,짬뽕...),d:count

CREATE TABLE vote (
                      vote_no NUMBER PRIMARY KEY,
                      title varchar2(300) NOT NULL,
                      reg_date DATE DEFAULT SYSDATE
);
CREATE SEQUENCE vote_seq
    START WITH 1
    INCREMENT BY 1;


CREATE TABLE vote_item(
                          item_no NUMBER PRIMARY KEY,
                          vote_no NUMBER NOT NULL,
                          item_text varchar2(500) NOT NULL,
                          vote_count NUMBER DEFAULT 0,
                          CONSTRAINT fk_vote_item_vote FOREIGN KEY (vote_no) REFERENCES vote(vote_no) ON DELETE CASCADE
);

CREATE SEQUENCE vote_item_seq
    START WITH 1
    INCREMENT BY 1;

INSERT INTO vote (vote_no,title,reg_date) VALUES (vote_seq.nextval,'월드컴 우승후보는?',sysdate);
INSERT INTO vote_item (item_no,vote_no,item_text,vote_count) VALUES
    (vote_item_seq.nextval,1,'브라질',0);
INSERT INTO vote_item (item_no,vote_no,item_text,vote_count) VALUES
    (vote_item_seq.nextval,1,'프랑스',0);
INSERT INTO vote_item (item_no,vote_no,item_text,vote_count) VALUES
    (vote_item_seq.nextval,1,'아르헨티나',0);
INSERT INTO vote_item (item_no,vote_no,item_text,vote_count) VALUES
    (vote_item_seq.nextval,1,'영국',0);

SELECT * FROM vote;
SELECT * FROM vote_item;
