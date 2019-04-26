use envsvc;
select * from environments;

use instancesvc;
select * from instance;
select * from instance_property;

use catalogsvc;
select * from solutions;
select * from solutions_property;

use orch_svc;
select * from launch;
select * from launch where launch_id= '7b01eda1-602f-4ca2-bb4c-9c0995342c5b';
select * from history;
select * from parameter;

select id,action_name, launch_id, parent_launch_id, root_launch_id,created_on from launch order by created_on desc;

select id,action_name, launch_id, parent_launch_id, root_launch_id,created_on from launch order by created_on desc;
select id,action_name, launch_id, parent_launch_id, root_launch_id,created_on from launch where root_launch_id= 'f2d6201d-82fd-41c2-9313-58555c06439e' order by created_on desc;

select distinct(launch_id) from parameter;
select * from parameter where launch_id in ('e592c527-aed4-4135-bda9-695d2e8c9d2c', '7b01eda1-602f-4ca2-bb4c-9c0995342c5b');
select * from parameter where launch_id in ('93d08888-6b82-4c4f-b20d-cdc056321bd4');

describe parameter;

select * from parameter where launch_id in (select launch_id from launch where action_name ='provision-database-servers');

select launch_id from launch where action_name ='provision-database-servers';




use rulessvc;
select * from rule;

/* 1c3bd96a-a9c6-47d3-ab53-b1072c9fb9d0 | 696670f9-3de5-46c6-a148-b2cfa87c56a0 | b99e30b9-02a3-40bb-9a8a-01331fe77f09 */
/* 1c3bd96a-a9c6-47d3-ab53-b1072c9fb9d0 | 05ac10f4-249d-4761-a494-df3f9a6c63ce | 27eb4431-a73e-48fa-a461-b83de664c2db */


