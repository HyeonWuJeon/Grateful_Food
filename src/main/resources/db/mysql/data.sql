insert into store(store_address, store_name,store_tel) values('서울','비비큐1호점','111-111-111');
insert into store(store_address, store_name,store_tel) values('서울','KFC1호점','011-111-111');

insert into store(store_address, store_name,store_tel) values('경기','현우족발1호점','111-111-111');
insert into store(store_address, store_name,store_tel) values('경기','가족1호점','111-111-111');

insert into store(store_address, store_name,store_tel) values('부산','김밥천국1호점','111-111-111');
insert into store(store_address, store_name,store_tel) values('부산','김밥지옥1호점','111-111-111');

insert into store(store_address, store_name,store_tel) values('대구','도미노1호점','111-111-111');
insert into store(store_address, store_name,store_tel) values('대구','피자헛1호점','111-111-111');


insert into food(ftype,name,price,store_id) values('C','기환치킨',19000,1);
insert into food(ftype,name,price,store_id) values('C','정우치킨',16000,1);
insert into food(ftype,name,price,store_id) values('C','현우치킨',16000,2);
insert into food(ftype,name,price,store_id) values('C','성인치킨',16000,2);

insert into food(ftype,name,price,store_id) values('Z','기환족발',30000,3);
insert into food(ftype,name,price,store_id) values('Z','정우족발',32000,3);
insert into food(ftype,name,price,store_id) values('Z','현우족발',33000,4);
insert into food(ftype,name,price,store_id) values('Z','인성족발',33000,4);

insert into food(ftype,name,price,store_id) values('K','현우김밥',3200,5);
insert into food(ftype,name,price,store_id) values('K','인성김밥',3200,5);
insert into food(ftype,name,price,store_id) values('K','정우김밥' ,4000,6);
insert into food(ftype,name,price,store_id) values('K','기환김밥' ,4000,6);

INSERT INTO food(ftype,name,price,store_id) values('P','현우피자',23000,7);
insert into food(ftype,name,price,store_id) values('P','인성피자',23000,8);
insert into food(ftype,name,price,store_id) values('P','정우피자',23000,7);
insert into food(ftype,name,price,store_id) values('P','기환피자',23000,8);


insert into domino(domino_taste, domino_value,food_id) values('고구마','라지',13);
insert into domino(domino_taste, domino_value,food_id) values('포테이토','미디엄',14);
insert into pizza_hut(hut_taste, hut_value,food_id) values('고구마','라지',15);
insert into pizza_hut(hut_taste, hut_value,food_id) values('포테이토','미디엄',16);

insert into bbq(bbq_taste, bbq_value,food_id) values('양념','뼈',1);
insert into bbq(bbq_taste, bbq_value,food_id) values('후라이드','순살',2);
insert into kfc(kfc_taste, kfc_value,food_id) values('양념','뼈',1);
insert into kfc(kfc_taste, kfc_value,food_id) values('후라이드','순살',2);

insert into gazok values('매운맛', '앞발',5);
insert into gazok values('순한맛', '뒷발',6);
insert into hyeonwu_zok values('매운맛', '앞발',7);
insert into hyeonwu_zok values('순한맛', '뒷발',8);


# insert into member(street, zipcode, coupon, email,name,password,role) values('서울','광진구','천원','yusa2@naver.com','전현우','1234','GUEST')