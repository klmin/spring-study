-- Team 및 Member 데이터 삽입 SQL

-- 팀 0
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀0', 0);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버0', 20, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버10', 21, CURRVAL('TEAM_SEQ'));

-- 팀 1
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀1', 1);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버1', 22, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버11', 23, CURRVAL('TEAM_SEQ'));

-- 팀 2
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀2', 2);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버2', 24, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버12', 25, CURRVAL('TEAM_SEQ'));

-- 팀 3
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀3', 3);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버3', 26, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버13', 27, CURRVAL('TEAM_SEQ'));

-- 팀 4
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀4', 4);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버4', 28, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버14', 29, CURRVAL('TEAM_SEQ'));

-- 팀 5
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀5', 5);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버5', 30, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버15', 31, CURRVAL('TEAM_SEQ'));

-- 팀 6
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀6', 6);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버6', 32, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버16', 33, CURRVAL('TEAM_SEQ'));

-- 팀 7
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀7', 7);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버7', 34, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버17', 35, CURRVAL('TEAM_SEQ'));

-- 팀 8
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀8', 8);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버8', 36, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버18', 37, CURRVAL('TEAM_SEQ'));

-- 팀 9
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀9', 9);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버9', 38, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버19', 39, CURRVAL('TEAM_SEQ'));

-- 팀 10
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀10', 10);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버10', 40, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버20', 41, CURRVAL('TEAM_SEQ'));

-- 팀 11
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀11', 11);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버11', 42, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버21', 43, CURRVAL('TEAM_SEQ'));

-- 팀 12
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀12', 12);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버12', 44, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버22', 45, CURRVAL('TEAM_SEQ'));

-- 팀 13
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀13', 13);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버13', 46, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버23', 47, CURRVAL('TEAM_SEQ'));

-- 팀 14
INSERT INTO team (team_id, team_name, team_num) VALUES (NEXTVAL('TEAM_SEQ'), '팀14', 14);
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버14', 48, CURRVAL('TEAM_SEQ'));
INSERT INTO member (member_id, name, age, team_id) VALUES (NEXTVAL('MEMBER_SEQ'), '멤버24', 49, CURRVAL('TEAM_SEQ'));
