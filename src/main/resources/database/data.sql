
-- Apartment 테이블 더미데이터
INSERT INTO Apartment (apartment_name, apartment_address, apartment_total_household) VALUES
    ('강남아파트', '서울특별시 강남구 강남대로 1234', 100),
    ('종로아파트', '서울특별시 종로구 종로 567', 80),
    ('마포아파트', '서울특별시 마포구 마포대로 890', 120),
    ('송파아파트', '서울특별시 송파구 올림픽로 123', 150),
    ('영등포아파트', '서울특별시 영등포구 영등포로 456', 90),
    ('광진아파트', '서울특별시 광진구 뚝섬로 789', 110),
    ('서초아파트', '서울특별시 서초구 서초대로 101', 70),
    ('강북아파트', '서울특별시 강북구 삼양로 222', 60),
    ('동작아파트', '서울특별시 동작구 상도로 333', 80),
    ('강서아파트', '서울특별시 강서구 화곡로 444', 100),
    ('은평아파트', '서울특별시 은평구 통일로 555', 110),
    ('양천아파트', '서울특별시 양천구 신월로 666', 70),
    ('노원아파트', '서울특별시 노원구 동일로 777', 130),
    ('구로아파트', '서울특별시 구로구 구일로 888', 120),
    ('성북아파트', '서울특별시 성북구 동소문로 999', 90),
    ('금천아파트', '서울특별시 금천구 시흥대로 1010', 80),
    ('동대문아파트', '서울특별시 동대문구 회기로 1111', 110),
    ('서대문아파트', '서울특별시 서대문구 신촌로 1212', 100),
    ('강동아파트', '서울특별시 강동구 천호대로 1313', 140);


--     reservation_facility_id int          not null,
--     reservation_id          int auto_increment
--         primary key,
--     reservation_end_time    datetime(6)  not null,
--     reservation_start_time  datetime(6)  not null,
--     reservation_user_id     varchar(255) not null
INSERT INTO reservation (reservation_facility_id, reservation_start_time, reservation_end_time,
                         reservation_user_id, reservation_headcount)
VALUES
    (4, '2024-03-22 02:25:49', '2024-03-24 02:25:49', 'string', 2),
    (4, '2024-03-23 02:25:49', '2024-03-24 02:25:49', 'example', 3),
    (5, '2024-03-24 02:25:49', '2024-03-24 02:25:49', 'string', 3),
    (5, '2024-03-24 02:25:49', '2024-03-24 02:25:49', 'example', 4),
    (6, '2024-03-26 02:25:49', '2024-03-26 03:25:49', 'string', 3);


-- facility 기본 값
--     facility_fee                       int          not null,
--     facility_id                        int          not null
--     facility_operating_time            int          not null,
--     facility_reservation_availble_time int          null,
--     facility_membership_yn             varchar(255) not null,
--     facility_name                      varchar(255) not null
--      수영장0, 헬스장0, 스크린골프장, 테니스장, 바베큐장, 영화관, 독서실0, 회의실
INSERT INTO facility (facility_id, facility_name,
                             facility_reservation_availble_time, facility_operating_time,
                             facility_membership_yn, facility_fee)
VALUES
    (1, '수영장', 24, 522, true, 100000),
    (2, '헬스장', 24, 522, true, 100000),
    (3, '독서실', 24, 724, true, 100000),
    (4, '스크린골프장', 2, 522, false, 30000),
    (5, '테니스장', 2, 522, false, 30000),
    (6, '바베큐장', 3, 1622, false, 30000),
    (7, '영화관', 3, 724, false, 30000),
    (8, '회의실', 2, 724, false, 30000);

-- realtimefacility 기본 값
--     realtime_facility_current_users int not null,
--     realtime_facility_id            int not null

INSERT INTO realtime_facility (realtime_facility_id, realtime_facility_current_users)
VALUES
    (1, 0),
    (2, 0),
    (3, 0);

