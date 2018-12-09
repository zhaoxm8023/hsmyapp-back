create table  team(
	id  LONG,
	name VARCHAR(100),
	team_desc VARCHAR(1000),
	token VARCHAR(200)
);


drop table meeting_room;
create table  meeting_room(
  id int PRIMARY key not null AUTO_INCREMENT,
	ip  VARCHAR(100),
	room_no VARCHAR(100),
	size VARCHAR(1000),
	terminal_id VARCHAR(200),
	type  VARCHAR(100),
	vnedor  VARCHAR(100),
	team_id LONG
);




-- alter table team default character set utf8;
-- alter table meeting_room default character set utf8;
--  alter table score change score score varchar(50) character utf8;
--

select * from meeting_room

INSERT INTO team(id,name,team_desc,token) VALUES (1,'深研二部','一个敏捷的团队','123456');
INSERT INTO team(id,name,team_desc,token) VALUES (2,'杭州三部','财政团队','123456');
COMMIT;

INSERT INTO meeting_room (ip, room_no, size, terminal_id, type, vnedor,team_id) VALUES ('182.207.96.163', '3201', '大', '21169', '视频', '思科',1);
INSERT INTO meeting_room (ip, room_no, size, terminal_id, type, vnedor,team_id) VALUES ('182.207.96.166', '3202', '中', '120706', '视频', '华为',1);
INSERT INTO meeting_room (ip, room_no, size, terminal_id, type, vnedor,team_id) VALUES (null, '3203', '小', null, '普通', null,1);
INSERT INTO meeting_room (ip, room_no, size, terminal_id, type, vnedor,team_id) VALUES (null, '3207', '小', null, '普通', null,1);
INSERT INTO meeting_room (ip, room_no, size, terminal_id, type, vnedor,team_id) VALUES (null, '3403', '小', null, '普通', null,1);
COMMIT;

select * from User
drop table User;
create table User(
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	mobile_no VARCHAR(100),
	open_id VARCHAR(1000),
	nick_name  VARCHAR(100),
	avatar_url  VARCHAR(1000)
);

ALTER TABLE `User` CHANGE COLUMN `id` `id` LONG NOT NULL AUTO_INCREMENT ;


DELETE from User where id = 1;
INSERT INTO User (name, mobile_no, open_id, nick_name, avatar_url) VALUES ('zhaoxm', '111111', '111111', '普通', null);
commit;


select * from Participant;
drop TABLE Participant;
create table Participant(
	id int PRIMARY key not null AUTO_INCREMENT,
	schedule_id LONG,
	open_id VARCHAR(1000),
	nick_name  VARCHAR(100),
	avatar_url  VARCHAR(1000),
	date TIMESTAMP,
	form_id VARCHAR(100)
);

select * from `Schedule`;
DROP TABLE SCHEDULE;
create table Schedule(
	id int PRIMARY key not null AUTO_INCREMENT ,
	title VARCHAR(100),
	meeting_room_id LONG,
	start_time  VARCHAR(100),
	end_time  VARCHAR(100),
	date TIMESTAMP,
	creator_open_id VARCHAR(100),
	creator_Nick_Name VARCHAR(100),
	creator_Avatar_Url VARCHAR(100),
	repeat_mode VARCHAR(100)
	#participants_id VARCHAR(100)
);



create table team_user_mapping (
team_id LONG,
user_id LONG
);


INSERT into team_user_mapping (team_id , User_id ) VALUES (1,1);
COMMIT;



select * from user
select
        users0_.team_id as team_id1_4_0_,
        users0_.user_id as user_id2_4_0_,
        user1_.id as id1_5_1_,
        user1_.avatar_url as avatar_u2_5_1_,
        user1_.mobile_no as mobile_n3_5_1_,
        user1_.name as name4_5_1_,
        user1_.nick_name as nick_nam5_5_1_,
        user1_.open_id as open_id6_5_1_
    from
        team_user_mapping users0_
    inner join
        user user1_
            on users0_.user_id=user1_.id
    where
        users0_.team_id='1'



DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(64)  COMMENT '登陆名',
  `password` varchar(64)  COMMENT '密码',
  `age` int(2) COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8 COMMENT='用户';

select * from  demo



