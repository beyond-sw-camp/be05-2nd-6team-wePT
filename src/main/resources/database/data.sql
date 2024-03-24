
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
INSERT INTO Reservation (reservation_facility_id, reservation_start_time, reservation_end_time, reservation_user_id)
VALUES
    (1, '2024-03-22 02:25:49', '2024-03-24 02:25:49', 'string'),
    (1, '2024-03-23 02:25:49', '2024-03-24 02:25:49', 'example'),
    (2, '2024-03-24 02:25:49', '2024-03-24 02:25:49', 'string'),
    (2, '2024-03-24 02:25:49', '2024-03-24 02:25:49', 'example'),
    (3, '2024-03-26 02:25:49', '2024-03-26 03:25:49', 'string');






