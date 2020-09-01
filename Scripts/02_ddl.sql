DROP table MEMBER;
CREATE TABLE member(
	name	varchar2(20),
	userid	varchar2(20),
	pwd		varchar2(20),
	email	varchar2(20), 
	phone 	char(13),
	admin number(1) DEFAULT 0, --0:사용자, 1:관리자
	joinDate DATE DEFAULT sysdate,
	PRIMARY key(userid)
);

SELECT *
FROM USER_TABLES;

--접속한 계정의 테이블별  컬럼 조회
SELECT *
FROM USER_TAB_COLUMNS 
WHERE table_name in('MEMBER');

--접속한 계정의 테이블별 제약조건 검색
SELECT *
	FROM USER_CONSTRAINTS 
	WHERE table_name in('MEMBER');