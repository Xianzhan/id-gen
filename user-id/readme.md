# user-id-gen
用户账号ID"随机"生成

# SQL

```sql
-- auto-generated definition
create table common_config
(
    id       bigint unsigned auto_increment comment '主键'
        primary key,
    category varchar(20) default 'common' not null comment '分类',
    `key`    varchar(20)                  not null comment '键',
    value    varchar(100)                 not null comment '值'
)
    comment '通用配置表';

create index u_index_1
    on common_config (category, `key`);

-- auto-generated definition
create table user
(
    id          bigint unsigned auto_increment comment '主键'
        primary key,
    user_id     bigint unsigned                    not null comment '帐号 ID',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    constraint u_index_1
        unique (user_id)
)
    comment '帐号';

-- auto-generated definition
create table user_id_gen
(
    id       bigint unsigned auto_increment
        primary key,
    start_id bigint unsigned not null comment '起始 ID',
    end_id   bigint unsigned not null comment '结束 ID',
    used     bigint          not null comment '记录在该范围已使用的 ID',
    constraint u_index_1
        unique (start_id)
)

    comment '帐号 ID 生成记录表';

INSERT INTO user_id_gen (start_id, end_id, used) VALUES (100032, 100096, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (116608, 116672, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (238720, 238784, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (233344, 233408, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (477568, 477632, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (501696, 501760, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (516480, 516544, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (650944, 651008, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (715008, 715072, 0);
INSERT INTO user_id_gen (start_id, end_id, used) VALUES (843072, 843136, 0);
```