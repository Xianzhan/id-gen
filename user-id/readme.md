# user-id-gen
用户账号ID"随机"生成

# SQL

```sql
create table common_config
(
    id       bigint unsigned auto_increment comment '主键'
        primary key,
    category varchar(20) default 'common' not null comment '分类',
    `key`    varchar(20)                  not null comment '键',
    value    varchar(100)                 not null comment '值'
) comment '通用配置表';

create index u_index_1
    on common_config (category, `key`);

create table user
(
    id          bigint unsigned auto_increment comment '主键'
        primary key,
    user_id     bigint unsigned                    not null comment '帐号 ID',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    constraint u_index_1
        unique (user_id)
) comment '帐号';

create table user_id_gen
(
    id       bigint unsigned auto_increment
        primary key,
    start_id bigint unsigned not null comment '起始 ID',
    end_id   bigint unsigned not null comment '结束 ID',
    constraint u_index_1
        unique (start_id)
) comment '帐号 ID 生成记录表';
```