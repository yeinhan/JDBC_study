DROP SEQUENCE MEMBERSQ;
DROP TABLE TB_MEMBER;

CREATE SEQUENCE MEMBERSQ
NOCACHE;

CREATE TABLE TB_MEMBER(
	M_NO NUMBER PRIMARY KEY,
	M_NAME VARCHAR2(20) NOT NULL,
	M_AGE NUMBER NOT NULL,
	M_GENDER VARCHAR2(2) CHECK(M_GENDER IN('M','F')) NOT NULL,
	M_LOCATION VARCHAR2(20),
	M_JOB VARCHAR2(10),
	M_TELL VARCHAR2(20),
	M_EMAIL VARCHAR2(20)
);

INSERT INTO TB_MEMBER VALUES(
MEMBERSQ.NEXTVAL, '이창진', 19,'M','화성','강사','010-1111-1111','LEE@KH'
);

SELECT * FROM TB_MEMBER;