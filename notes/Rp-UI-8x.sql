--RP_FEEDBACK_INFO;
--RP_SR;
--SERVICE_REQUEST;

grant unlimited tablespace to rw_eip53;
alter user rw_eip53 quota unlimited on data_s;

select * from rp_sr;
select * from service_request;
select * from rp_feedback_info;



delete from rp_sr;
insert into rp_sr(service_request_id,service_request_open_time,model_output_wid,rp_model_score,sdp_wid,sdp_udc_id,
sdp_universal_id,sdp_gps_lat,sdp_gps_long,sdp_address,premise_wid,data_ref_start_time,data_ref_end_time,
recommendation_cd,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM )
values(4,TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),4,0.7,4,'sdpudc-4','sdpuniv-4',0.23,0.45,'address',4,sysdate,sysdate,'Y',1,sysdate,1,1,sysdate,1);
insert into rp_sr(service_request_id,service_request_open_time,model_output_wid,rp_model_score,sdp_wid,sdp_udc_id,
sdp_universal_id,sdp_gps_lat,sdp_gps_long,sdp_address,premise_wid,data_ref_start_time,data_ref_end_time,
recommendation_cd,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM )
values(5,TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),5,0.7,4,'sdpudc-5','sdpuniv-5',0.23,0.45,'address',4,sysdate,sysdate,'Y',1,sysdate,1,1,sysdate,1);
insert into rp_sr(service_request_id,service_request_open_time,model_output_wid,rp_model_score,sdp_wid,sdp_udc_id,
sdp_universal_id,sdp_gps_lat,sdp_gps_long,sdp_address,premise_wid,data_ref_start_time,data_ref_end_time,
recommendation_cd,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM )
values(6,TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),6,0.7,4,'sdpudc-6','sdpuniv-6',0.23,0.45,'address',4,sysdate,sysdate,'Y',1,sysdate,1,1,sysdate,1);
insert into rp_sr(service_request_id,service_request_open_time,model_output_wid,rp_model_score,sdp_wid,sdp_udc_id,
sdp_universal_id,sdp_gps_lat,sdp_gps_long,sdp_address,premise_wid,data_ref_start_time,data_ref_end_time,
recommendation_cd,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM )
values(7,TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),7,0.7,4,'sdpudc-7','sdpuniv-7',0.23,0.45,'address',4,sysdate,sysdate,'Y',1,sysdate,1,1,sysdate,1);

delete from RP_FEEDBACK_INFO;
insert into RP_FEEDBACK_INFO(SERVICE_REQUEST_ID, SERVICE_REQUEST_OPEN_TIME, MODEL_OUTPUT_WID, INVESTIGATION_OUTCOME_CD, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM )
values(4, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 4, 'faulty-4',1,sysdate,1,1,sysdate,1);
insert into RP_FEEDBACK_INFO(SERVICE_REQUEST_ID, SERVICE_REQUEST_OPEN_TIME, MODEL_OUTPUT_WID, INVESTIGATION_OUTCOME_CD, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM )
values(5, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 5, 'faulty-5',1,sysdate,1,1,sysdate,1);
insert into RP_FEEDBACK_INFO(SERVICE_REQUEST_ID, SERVICE_REQUEST_OPEN_TIME, MODEL_OUTPUT_WID, INVESTIGATION_OUTCOME_CD, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM )
values(6, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 6, 'faulty-6',1,sysdate,1,1,sysdate,1);
insert into RP_FEEDBACK_INFO(SERVICE_REQUEST_ID, SERVICE_REQUEST_OPEN_TIME, MODEL_OUTPUT_WID, INVESTIGATION_OUTCOME_CD, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM )
values(7, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 7, 'faulty-7',1,sysdate,1,1,sysdate,1);

delete from service_request where type_cd = 'RevenueProtection';
insert into service_request(ID, TYPE_CD, SUB_TYPE_CD, DATA_SRC, STATUS_CD, ASSIGNMENT_STATUS_CD, PRIORITY_CD, SEVERITY_CD, DESC_TEXT, EXT_ID, EXTERNAL_SYSTEM, OPEN_TIME , CLOSE_TIME, DUE_TIME, CUR_WORK_QUEUE_ID, ACCNT_ID, SVC_PT_ID, OUTCOME_CD, ALT_OUTCOME_CD, OUTCOME_REASON_CD, ALT_OUTCOME_REASON_CD, REQUEST_REASON_CD, ALT_REQUEST_REASON_CD, DATA_REF_START_TIME, DATA_REF_END_TIME, CONSUMER_ID, INSTALLER_GROUP_ID, DEVICE_ID, WMS_ID, CHANNEL_ID, SVC_AGREE_ID, PARENT_SR_ID, CUR_WORK_FOLDER_ID, CUR_OWNER_ID, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM)
values(4, 'RevenueProtection', 'SYSTEM', 'SOURCE1', 'Closed', 'Investigate', 3, 3, 'Revenue protection SR to investigate faulty SDP', null, null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss') , TO_DATE('2003/05/05 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, 'OUTCOME_CD-4', null, 'OUTCOME_REASON_CD-4', null, 'Investigate', null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2003/05/03 21:08:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, null, null, null, null, null,1,sysdate,1,1,sysdate,1);
insert into service_request(ID, TYPE_CD, SUB_TYPE_CD, DATA_SRC, STATUS_CD, ASSIGNMENT_STATUS_CD, PRIORITY_CD, SEVERITY_CD, DESC_TEXT, EXT_ID, EXTERNAL_SYSTEM, OPEN_TIME , CLOSE_TIME, DUE_TIME, CUR_WORK_QUEUE_ID, ACCNT_ID, SVC_PT_ID, OUTCOME_CD, ALT_OUTCOME_CD, OUTCOME_REASON_CD, ALT_OUTCOME_REASON_CD, REQUEST_REASON_CD, ALT_REQUEST_REASON_CD, DATA_REF_START_TIME, DATA_REF_END_TIME, CONSUMER_ID, INSTALLER_GROUP_ID, DEVICE_ID, WMS_ID, CHANNEL_ID, SVC_AGREE_ID, PARENT_SR_ID, CUR_WORK_FOLDER_ID, CUR_OWNER_ID, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM)
values(5, 'RevenueProtection', 'SYSTEM', 'SOURCE1', 'Closed', 'Investigate', 3, 3, 'Revenue protection SR to investigate faulty SDP', null, null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss') , TO_DATE('2003/05/05 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, 'OUTCOME_CD-5', null, 'OUTCOME_REASON_CD-5', null, 'Investigate', null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2003/05/03 21:08:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, null, null, null, null, null,1,sysdate,1,1,sysdate,1);
insert into service_request(ID, TYPE_CD, SUB_TYPE_CD, DATA_SRC, STATUS_CD, ASSIGNMENT_STATUS_CD, PRIORITY_CD, SEVERITY_CD, DESC_TEXT, EXT_ID, EXTERNAL_SYSTEM, OPEN_TIME , CLOSE_TIME, DUE_TIME, CUR_WORK_QUEUE_ID, ACCNT_ID, SVC_PT_ID, OUTCOME_CD, ALT_OUTCOME_CD, OUTCOME_REASON_CD, ALT_OUTCOME_REASON_CD, REQUEST_REASON_CD, ALT_REQUEST_REASON_CD, DATA_REF_START_TIME, DATA_REF_END_TIME, CONSUMER_ID, INSTALLER_GROUP_ID, DEVICE_ID, WMS_ID, CHANNEL_ID, SVC_AGREE_ID, PARENT_SR_ID, CUR_WORK_FOLDER_ID, CUR_OWNER_ID, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM)
values(6, 'RevenueProtection', 'SYSTEM', 'SOURCE1', 'Closed', 'Investigate', 3, 3, 'Revenue protection SR to investigate faulty SDP', null, null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss') , TO_DATE('2003/05/05 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, 'OUTCOME_CD-6', null, 'OUTCOME_REASON_CD-6', null, 'Investigate', null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2003/05/03 21:08:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, null, null, null, null, null,1,sysdate,1,1,sysdate,1);
insert into service_request(ID, TYPE_CD, SUB_TYPE_CD, DATA_SRC, STATUS_CD, ASSIGNMENT_STATUS_CD, PRIORITY_CD, SEVERITY_CD, DESC_TEXT, EXT_ID, EXTERNAL_SYSTEM, OPEN_TIME , CLOSE_TIME, DUE_TIME, CUR_WORK_QUEUE_ID, ACCNT_ID, SVC_PT_ID, OUTCOME_CD, ALT_OUTCOME_CD, OUTCOME_REASON_CD, ALT_OUTCOME_REASON_CD, REQUEST_REASON_CD, ALT_REQUEST_REASON_CD, DATA_REF_START_TIME, DATA_REF_END_TIME, CONSUMER_ID, INSTALLER_GROUP_ID, DEVICE_ID, WMS_ID, CHANNEL_ID, SVC_AGREE_ID, PARENT_SR_ID, CUR_WORK_FOLDER_ID, CUR_OWNER_ID, ORG_ID, INSERT_TIME, INSERT_BY, LAST_UPD_BY, LAST_UPD_TIME, REC_VERSION_NUM)
values(7, 'RevenueProtection', 'SYSTEM', 'SOURCE1', 'Closed', 'Investigate', 3, 3, 'Revenue protection SR to investigate faulty SDP', null, null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss') , TO_DATE('2003/05/05 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, 'OUTCOME_CD-7', null, 'OUTCOME_REASON_CD-7', null, 'Investigate', null, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2003/05/03 21:08:44', 'yyyy/mm/dd hh24:mi:ss'), null, null, null, null, null, null, null, null, null,1,sysdate,1,1,sysdate,1);

commit;




select feedback.SERVICE_REQUEST_ID, 
feedback.SERVICE_REQUEST_OPEN_TIME, 
feedback.MODEL_OUTPUT_WID, 
feedback.INVESTIGATION_OUTCOME_CD,
rpsr.sdp_wid, rpsr.sdp_udc_id,
sr.CLOSE_TIME, sr.OUTCOME_CD, sr.OUTCOME_REASON_CD, sr.SUB_TYPE_CD
from rp_feedback_info feedback, rp_sr rpsr, service_request sr
where feedback.org_id = 1 --?
and feedback.org_id = sr.org_id
and feedback.SERVICE_REQUEST_ID = sr.id
and feedback.SERVICE_REQUEST_OPEN_TIME = sr.OPEN_TIME
and feedback.org_id = rpsr.org_id
and feedback.SERVICE_REQUEST_ID = rpsr.service_request_id
and feedback.SERVICE_REQUEST_OPEN_TIME = rpsr.SERVICE_REQUEST_OPEN_TIME;


/*select * from service_request;
select * from sr_pending;

--drop table sdp_d;
--drop table PREMISE_D;
drop table rp_feature;
drop table rp_model_output;
drop table rp_investigation_request;
drop table RP_SDP_EXEMPT;
--drop table RP_CLOSED_SR;
drop table RP_sr_algorithm;
drop table rp_sr;
drop table RP_SR_INVESTIGATION;
drop table RP_FEEDBACK_INFO;
drop table RP_ALGORITHM_DEF_PARAM;
drop table RP_ALGORITHM;
drop table RP_ALGORITHM_PARAM;
drop table RP_EXECUTION_STAT;
drop table RP_INVESTIGATION;
drop table RP_ALGORITHM_DEF;*/

select * from service_request WHERE type_cd ='RevenueProtection';
select * from sr_pending WHERE type_cd ='RevenueProtection';
select * from RP_sr_algorithm;

--------------------------------------------------------

delete from sdp_d;
delete from premise_d;
delete from rp_investigation_request;
delete from rp_feature;
delete from RP_MODEL_OUTPUT;
delete from RP_ALGORITHM;
delete from RP_ALGORITHM_DEF;
commit;

--1
insert into premise_d(WID,POSTAL_CODE_WID,SRC_ID,ADDR_LINE_1,ADDR_LINE_2,org_id)
values(1,1,1,'Addr11','Addr12',1);
insert into sdp_d (WID,SRC_ID,ORG_ID,UDC_ID,premise_wid,gps_lat,gps_long)
values(1, 'srcId-1',1,'udcId-1',1,0.34,0.56);
insert into RP_ALGORITHM_DEF(WID, NAME, DESCRIPTION, PROCEDURE_NAME,EIP_CD, MINUTE_BACKWARD,ORG_ID)
values(1,'Algo1','algoDesc1','AlgoProc1','Y1',10,1);
insert into RP_ALGORITHM(WID,SDP_SEGMENT_CONFIG_WID,ALGORITHM_DEF_WID,ALGORITHM_EIP_CD,ACTIVE_FLAG,MINUTE_BACKWARD,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,1,1,'Y1','Y',10,1,sysdate,sysdate);
insert into rp_feature(BATCH_ID,ALGORITHM_WID,ANALYSIS_END_DATE,SDP_WID,ACTUAL_VALUE,DESCRIPTION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,1,sysdate,1,0.1,'Desc 1',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,1,sysdate,sysdate,1,0.4,'modelVersion1',1,sysdate,sysdate);
--2
insert into premise_d(WID,POSTAL_CODE_WID,SRC_ID,ADDR_LINE_1,ADDR_LINE_2,ORG_ID)
values(2,2,2,'Addr21','Addr22',1);
insert into sdp_d (WID,SRC_ID,ORG_ID,UDC_ID,premise_wid,gps_lat,gps_long)
values(2, 'srcId-2',1,'udcId-2',2,0.1,0.2);
insert into RP_ALGORITHM_DEF(WID, NAME, DESCRIPTION, PROCEDURE_NAME,EIP_CD, MINUTE_BACKWARD,ORG_ID)
values(2,'Algo2','algoDesc2','AlgoProc2','Y2',10,1);
insert into RP_ALGORITHM(WID,SDP_SEGMENT_CONFIG_WID,ALGORITHM_DEF_WID,ALGORITHM_EIP_CD,ACTIVE_FLAG,MINUTE_BACKWARD,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(2,2,2,'Y2','Y',10,1,sysdate,sysdate);
insert into rp_feature(BATCH_ID,ALGORITHM_WID,ANALYSIS_END_DATE,SDP_WID,ACTUAL_VALUE,DESCRIPTION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,2,sysdate,2,0.2,'Desc 2',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(2,1,sysdate,sysdate,2,0.5,'modelVersion2',1,sysdate,sysdate);

--3
insert into premise_d(WID,POSTAL_CODE_WID,SRC_ID,ADDR_LINE_1,ADDR_LINE_2,ORG_ID)
values(3,3,3,'Addr31','Addr32',1);
insert into sdp_d (WID,SRC_ID,ORG_ID,UDC_ID,premise_wid,gps_lat,gps_long)
values(3, 'srcId-3',1,'udcId-3',3,0.3,0.4);
insert into RP_ALGORITHM_DEF(WID, NAME, DESCRIPTION, PROCEDURE_NAME,EIP_CD, MINUTE_BACKWARD,ORG_ID)
values(3,'Algo3','algoDesc3','AlgoProc3','Y3',10,1);
insert into RP_ALGORITHM(WID,SDP_SEGMENT_CONFIG_WID,ALGORITHM_DEF_WID,ALGORITHM_EIP_CD,ACTIVE_FLAG,MINUTE_BACKWARD,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(3,3,3,'Y3','Y',10,1,sysdate,sysdate);
insert into rp_feature(BATCH_ID,ALGORITHM_WID,ANALYSIS_END_DATE,SDP_WID,ACTUAL_VALUE,DESCRIPTION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,3,sysdate,3,0.3,'Desc 3',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(3,1,sysdate,sysdate,3,0.6,'modelVersion3',1,sysdate,sysdate);
insert into rp_investigation_request(MODEL_OUTPUT_WID,SDP_WID,BATCH_ID,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values (3,3,1,1,SYSDATE,SYSDATE);
--4
insert into premise_d(WID,POSTAL_CODE_WID,SRC_ID,ADDR_LINE_1,ADDR_LINE_2,ORG_ID)
values(4,4,4,'Addr41','Addr42',1);
insert into sdp_d (WID,SRC_ID,ORG_ID,UDC_ID,premise_wid,gps_lat,gps_long)
values(4, 'srcId-4',1,'udcId-4',4,0.5,0.6);
insert into RP_ALGORITHM_DEF(WID, NAME, DESCRIPTION, PROCEDURE_NAME,EIP_CD, MINUTE_BACKWARD,ORG_ID)
values(4,'Algo4','algoDesc4','AlgoProc4','Y4',10,1);
insert into RP_ALGORITHM(WID,SDP_SEGMENT_CONFIG_WID,ALGORITHM_DEF_WID,ALGORITHM_EIP_CD,ACTIVE_FLAG,MINUTE_BACKWARD,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(4,4,4,'Y4','Y',10,1,sysdate,sysdate);
insert into rp_feature(BATCH_ID,ALGORITHM_WID,ANALYSIS_END_DATE,SDP_WID,ACTUAL_VALUE,DESCRIPTION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,4,sysdate,4,0.4,'Desc 4',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(4,1,sysdate,sysdate,4,0.7,'modelVersion4',1,sysdate,sysdate);

--5
insert into premise_d(WID,POSTAL_CODE_WID,SRC_ID,ADDR_LINE_1,ADDR_LINE_2,ORG_ID)
values(5,5,5,'Addr51','Addr52',1);
insert into sdp_d (WID,SRC_ID,ORG_ID,UDC_ID,premise_wid,gps_lat,gps_long)
values(5, 'srcId-5',1,'udcId-5',5,0.7,0.8);
insert into RP_ALGORITHM_DEF(WID, NAME, DESCRIPTION, PROCEDURE_NAME,EIP_CD, MINUTE_BACKWARD,ORG_ID)
values(5,'Algo5','algoDesc5','AlgoProc5','Y5',10,1);
insert into RP_ALGORITHM_DEF(WID, NAME, DESCRIPTION, PROCEDURE_NAME,EIP_CD, MINUTE_BACKWARD,ORG_ID)
values(6,'Algo6','algoDesc6','AlgoProc6','Y6',11,1);
insert into RP_ALGORITHM(WID,SDP_SEGMENT_CONFIG_WID,ALGORITHM_DEF_WID,ALGORITHM_EIP_CD,ACTIVE_FLAG,MINUTE_BACKWARD,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(5,5,5,'Y5','Y',10,1,sysdate,sysdate);
insert into RP_ALGORITHM(WID,SDP_SEGMENT_CONFIG_WID,ALGORITHM_DEF_WID,ALGORITHM_EIP_CD,ACTIVE_FLAG,MINUTE_BACKWARD,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(6,5,6,'Y6','Y',10,1,sysdate,sysdate);
insert into rp_feature(BATCH_ID,ALGORITHM_WID,ANALYSIS_END_DATE,SDP_WID,ACTUAL_VALUE,DESCRIPTION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,5,sysdate,5,0.5,'Desc 5',1,sysdate,sysdate);
insert into rp_feature(BATCH_ID,ALGORITHM_WID,ANALYSIS_END_DATE,SDP_WID,ACTUAL_VALUE,DESCRIPTION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(1,6,sysdate,5,0.5,'Desc 6',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(5,1,sysdate,sysdate,5,0.6,'modelVersion6',1,sysdate,sysdate);

commit;


delete from rp_sdp_exempt;
delete from RP_sr_algorithm;
delete from rp_sr;
delete from service_request_attr where service_request_id in (select id from SERVICE_REQUEST WHERE type_cd ='RevenueProtection');
delete from SR_PENDING WHERE type_cd ='RevenueProtection';
delete from SERVICE_REQUEST WHERE type_cd ='RevenueProtection';
commit;


insert into rp_sdp_exempt(SDP_WID,EXEMPT_START_TIME,EXEMPT_END_TIME,EXEMPT_TYPE,SERVICE_REQUEST_ID,MODEL_OUTPUT_WID,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM)
values(2,sysdate,sysdate,'y',22,2,1,sysdate,1,1,sysdate,1);

insert into rp_sr(service_request_id,service_request_open_time,model_output_wid,rp_model_score,sdp_wid,sdp_udc_id,
sdp_universal_id,sdp_gps_lat,sdp_gps_long,sdp_address,premise_wid,data_ref_start_time,data_ref_end_time,
recommendation_cd,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM )
values(4,sysdate,4,0.7,4,'sdpudc-4','sdpuniv-4',0.23,0.45,'address',4,sysdate,sysdate,'Y',1,sysdate,1,1,sysdate,1);

commit;


drop table RP_ALGORITHM_DEF; 
drop table RP_ALGORITHM;
drop table SDP_D;
drop table PREMISE_D;
drop table RP_FEATURE;
drop table RP_MODEL_OUTPUT;
drop table RP_INVESTIGATION_REQUEST;
drop table RP_SR_ALGORITHM;
drop table RP_SR;
drop table RP_SDP_EXEMPT;

select count(*) from rp_investigation_request;
select * from rp_model_output;
select * from premise_d;
select * from sdp_d;
select * from RP_ALGORITHM_DEF;
select * from RP_ALGORITHM;
select * from RP_FEATURE;
select * from RP_INVESTIGATION_REQUEST;
select * from RP_SR;
select * from RP_SR_ALGORITHM;
select * from RP_SDP_EXEMPT;
--------------------------------------------------------


select * from Service_request;
select * from SR_PENDING;
select * from RP_SR;
select * from RP_SR_ALGORITHM;

select * from eip_user;
--UI
CREATE TABLE RP_SDP_EXEMPT(
    SDP_WID               NUMBER,
    exempt_start_time     TIMESTAMP(0),
    exempt_end_time       TIMESTAMP(0),
    exempt_type           CHAR(10),
    service_request_id    NUMBER,
    model_output_wid      NUMBER,
    ORG_ID                       NUMBER          NOT NULL,
    INSERT_TIME                  TIMESTAMP(0)    NOT NULL,
    INSERT_BY                    NUMBER          NOT NULL,
    LAST_UPD_BY                  NUMBER          NOT NULL,
    LAST_UPD_TIME                TIMESTAMP(0)    NOT NULL,
    REC_VERSION_NUM              NUMBER          NOT NULL,
    constraint PK_RP_SDP_EXEMPT primary key (SDP_WID, exempt_start_time) using index   
)
;



-- 
-- TABLE: RP_SR 
--

CREATE TABLE RP_SR(
    service_request_id           NUMBER            NOT NULL,
    service_request_open_time    TIMESTAMP(0)      NOT NULL,
    model_output_wid             NUMBER            NOT NULL,
    rp_model_score               NUMBER            NOT NULL,
    sdp_wid                      NUMBER            NOT NULL,
    sdp_udc_id                   VARCHAR2(200)     NOT NULL,
    sdp_universal_id             VARCHAR2(200),
    sdp_gps_lat                  NUMBER(22, 8),
    sdp_gps_long                 NUMBER(22, 8),
    sdp_address                  VARCHAR2(2000),
    premise_wid		         number            NOT NULL,
    data_ref_start_time          TIMESTAMP(0)      NOT NULL,
    data_ref_end_time            TIMESTAMP(0)      NOT NULL,
    recommendation_cd            CHAR(10),
    ORG_ID                       NUMBER          NOT NULL,
    INSERT_TIME                  TIMESTAMP(0)    NOT NULL,
    INSERT_BY                    NUMBER          NOT NULL,
    LAST_UPD_BY                  NUMBER          NOT NULL,
    LAST_UPD_TIME                TIMESTAMP(0)    NOT NULL,
    REC_VERSION_NUM              NUMBER          NOT NULL,
    CONSTRAINT PK_RP_SR PRIMARY KEY (sdp_wid, service_request_id, service_request_open_time) 
   
 );

--create index IX_RP_SR_1
--    on RP_SR (sdp_udc_id)
--    compress local;
--
--create index IX_RP_SR_2
--    on RP_SR (sdp_address)
--    compress local;


-- 
-- TABLE: RP_SR_ALGORITHM 
--

CREATE TABLE RP_SR_ALGORITHM(
    service_request_id           NUMBER            NOT NULL,
    service_request_open_time    TIMESTAMP(0)      NOT NULL,
    sdp_wid                      NUMBER            NOT NULL,
    algorithm_name               VARCHAR2(100)     NOT NULL,
    algorithm_outcome_desc       VARCHAR2(4000)  NOT NULL,
    algorithm_wid                NUMBER          NOT NULL,
    algorithm_ACTUAL_VALUE       NUMBER(21, 6)   NOT NULL,
    ORG_ID                       NUMBER          NOT NULL,
    INSERT_TIME                  TIMESTAMP(0)    NOT NULL,
    INSERT_BY                    NUMBER          NOT NULL,
    LAST_UPD_BY                  NUMBER          NOT NULL,
    LAST_UPD_TIME                TIMESTAMP(0)    NOT NULL,
    REC_VERSION_NUM              NUMBER          NOT NULL,
    CONSTRAINT PK_RP_SR_ALGORITHM PRIMARY KEY (sdp_wid, service_request_id, service_request_open_time, algorithm_wid)
   									
 ) ;



-- 
-- TABLE: RP_SR_INVESTIGATION 
--

CREATE TABLE RP_SR_INVESTIGATION(
    service_request_id           NUMBER           NOT NULL,
    service_request_open_time    TIMESTAMP(0)     NOT NULL,
    sdp_wid                      NUMBER    	  NOT NULL,
    condition_name               VARCHAR2(100)    NOT NULL,
    is_suspected_flag            CHAR(1)          NOT NULL,
    is_found_flag                CHAR(1)          NOT NULL,
    investigator_comment         VARCHAR2(1000),
    ORG_ID                       NUMBER          NOT NULL,
    INSERT_TIME                  TIMESTAMP(0)    NOT NULL,
    INSERT_BY                    NUMBER          NOT NULL,
    LAST_UPD_BY                  NUMBER          NOT NULL,
    LAST_UPD_TIME                TIMESTAMP(0)    NOT NULL,
    REC_VERSION_NUM              NUMBER          NOT NULL,
    CONSTRAINT PK_RP_SR_INVESTIGATION PRIMARY KEY (sdp_wid, service_request_id, service_request_open_time, condition_name)
   								
 );

CREATE TABLE RP_FEEDBACK_INFO(
    SERVICE_REQUEST_ID           NUMBER          NULL,
    SERVICE_REQUEST_OPEN_TIME    TIMESTAMP(0)    NULL,
    MODEL_OUTPUT_WID             NUMBER          NULL,
    INVESTIGATION_OUTCOME_CD	 VARCHAR2(50)	 NOT NULL,
    ORG_ID                       NUMBER          NOT NULL,
    INSERT_TIME                  TIMESTAMP(0)    NOT NULL,
    INSERT_BY                    NUMBER          NOT NULL,
    LAST_UPD_BY                  NUMBER          NOT NULL,
    LAST_UPD_TIME                TIMESTAMP(0)    NOT NULL,
    REC_VERSION_NUM              NUMBER          NOT NULL,
    CONSTRAINT UK_RP_CLOSED_SR UNIQUE (SERVICE_REQUEST_ID, MODEL_OUTPUT_WID)
);



-- 
-- TABLE: RP_SR_ALGORITHM 
--

ALTER TABLE RP_SR_ALGORITHM ADD CONSTRAINT FK_RP_SR_ALGORITHM_1 
    FOREIGN KEY (sdp_wid, service_request_id, service_request_open_time)
    REFERENCES RP_SR(sdp_wid, service_request_id, service_request_open_time)
;


-- 
-- TABLE: RP_SR_INVESTIGATION 
--

ALTER TABLE RP_SR_INVESTIGATION ADD CONSTRAINT FK_RP_SR_INVESTIGATION_1
    FOREIGN KEY (sdp_wid, service_request_id, service_request_open_time)
    REFERENCES RP_SR(sdp_wid, service_request_id, service_request_open_time)
;

/*
create table SERVICE_REQUEST (
  REC_VERSION_NUM NUMBER not null,
  ID NUMBER not null,
  TYPE_CD VARCHAR2(50),
  SUB_TYPE_CD VARCHAR2(50),
  DATA_SRC VARCHAR2(50),
  STATUS_CD VARCHAR2(50),
  ASSIGNMENT_STATUS_CD VARCHAR2(50),
  PRIORITY_CD VARCHAR2(50),
  SEVERITY_CD VARCHAR2(50),
  DESC_TEXT VARCHAR2(2000),
  EXT_ID VARCHAR2(50),
  EXTERNAL_SYSTEM VARCHAR2(50),
  OPEN_TIME TIMESTAMP(0) not null,
  CLOSE_TIME TIMESTAMP(0),
  DUE_TIME TIMESTAMP(0),
  CUR_WORK_QUEUE_ID NUMBER,
  ACCNT_ID NUMBER,
  SVC_PT_ID NUMBER,
  OUTCOME_CD VARCHAR2(50),
  ALT_OUTCOME_CD VARCHAR2(1000),
  OUTCOME_REASON_CD VARCHAR2(50),
  ALT_OUTCOME_REASON_CD VARCHAR2(512),
  REQUEST_REASON_CD VARCHAR2(50),
  ALT_REQUEST_REASON_CD VARCHAR2(50),
  DATA_REF_START_TIME TIMESTAMP(0),
  DATA_REF_END_TIME TIMESTAMP(0),
  CONSUMER_ID NUMBER,
  INSTALLER_GROUP_ID NUMBER,
  DEVICE_ID NUMBER,
  WMS_ID NUMBER,
  CHANNEL_ID NUMBER,
  SVC_AGREE_ID NUMBER,
  PARENT_SR_ID NUMBER,
  CUR_WORK_FOLDER_ID NUMBER,
  CUR_OWNER_ID NUMBER,
  ORG_ID NUMBER not null,
  INSERT_TIME TIMESTAMP(0) not null,
  INSERT_BY NUMBER not null,
  LAST_UPD_BY NUMBER not null,
  LAST_UPD_TIME TIMESTAMP(0) not null);


create table SR_PENDING (
  SERVICE_REQUEST_ID NUMBER not null,
  TYPE_CD VARCHAR2(50),
  SUB_TYPE_CD VARCHAR2(50),
  STATUS_CD VARCHAR2(50),
  ASSIGNMENT_STATUS_CD VARCHAR2(50),
  PRIORITY_CD VARCHAR2(50),
  SEVERITY_CD VARCHAR2(50),
  EXT_ID VARCHAR2(50),
  EXTERNAL_SYSTEM VARCHAR2(50),
  SERVICE_REQUEST_OPEN_TIME TIMESTAMP(0),
  DUE_TIME TIMESTAMP(0),
  CUR_WORK_QUEUE_ID NUMBER,
  ACCNT_ID NUMBER,
  SVC_PT_ID NUMBER,
  DATA_REF_START_TIME TIMESTAMP(0),
  DATA_REF_END_TIME TIMESTAMP(0),
  CONSUMER_ID NUMBER,
  INSTALLER_GROUP_ID NUMBER,
  DEVICE_ID NUMBER,
  WMS_ID NUMBER,
  CHANNEL_ID NUMBER,
  SVC_AGREE_ID NUMBER,
  PARENT_SR_ID NUMBER,
  CUR_WORK_FOLDER_ID NUMBER,
  CUR_OWNER_ID NUMBER,
  ORG_ID NUMBER not null,
  INSERT_TIME TIMESTAMP(0) not null,
  INSERT_BY NUMBER not null,
  LAST_UPD_BY NUMBER not null,
  LAST_UPD_TIME TIMESTAMP(0) not null,
  REC_VERSION_NUM NUMBER not null);
  */