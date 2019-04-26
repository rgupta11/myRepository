insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(6,1,sysdate,sysdate,6,0.6,'modelVersion6',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(7,1,sysdate,sysdate,7,0.6,'modelVersion6',1,sysdate,sysdate);

insert into rp_investigation_request values (4,'4',21,1,SYSDATE,SYSDATE);
insert into rp_investigation_request values (5,'5',21,1,SYSDATE,SYSDATE);
insert into rp_investigation_request values (6,'6',21,1,SYSDATE,SYSDATE);
insert into rp_investigation_request values (7,'7',21,1,SYSDATE,SYSDATE);

delete from rp_investigation;
commit;

select * from rp_investigation;
select * from rp_model_output;
select * from rp_investigation_request;



select DISTINCT
			  sdp.src_id, sdp.premise_wid, sdp.udc_id, sdp.universal_id, sdp.gps_lat, sdp.gps_long,
			  prms.addr_line_1 || prms.addr_line_2 sdp_address,
			  op.wid model_output_wid, op.sdp_wid, op.score, op.model_version, op.org_id, op.batch_id, 
        /* op.insert_time, op.last_upd_time, op.analysis_end_date,*/
			  ftr.algorithm_wid, ftr.ACTUAL_VALUE, ftr.description
			  from RP_FEATURE ftr, RP_MODEL_OUTPUT op, sdp_d sdp, premise_d prms
			  where op.sdp_wid = ftr.sdp_wid
			  AND prms.wid = sdp.premise_wid
			  AND op.sdp_wid = sdp.wid
			  AND op.score >= 0.5
			  AND op.sdp_wid NOT IN (select sdp_wid from rp_investigation_request);
      
insert into rp_investigation_request values (3,'3',3,1,SYSDATE,SYSDATE);

select DISTINCT ex.sdp_wid, d.src_id from RP_SDP_EXEMPT ex, sdp_d d where ex.sdp_wid = d.wid;
select DISTINCT sr.sdp_wid, d.src_id from RP_SR sr, sdp_d d where sr.sdp_wid = d.wid;

select * from rp_investigation_request;


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


insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(6,1,sysdate,sysdate,6,0.6,'modelVersion6',1,sysdate,sysdate);
insert into RP_MODEL_OUTPUT(WID,BATCH_ID,ANALYSIS_END_DATE,ANALYSIS_START_DATE,SDP_WID,SCORE,MODEL_VERSION,ORG_ID,INSERT_TIME,LAST_UPD_TIME)
values(7,1,sysdate,sysdate,7,0.6,'modelVersion6',1,sysdate,sysdate);



commit;
-------------------------------------------------------------------------------------------------------

/*select * from rp_model_output where score >= 0.5

select DISTINCT
sdp.src_id, sdp.premise_wid, sdp.udc_id, sdp.universal_id, sdp.gps_lat, sdp.gps_long,
prms.addr_line_1 || ' ' || prms.addr_line_2 sdp_address,
op.wid model_output_wid, op.sdp_wid, op.score, op.model_version, op.org_id, op.batch_id, 
op.analysis_end_date, op.analysis_start_date, 
ftr.algorithm_wid, ftr.actual_value algoritm_actual_value, ftr.description algoritm_description, algodef.name algoritm_name
from rp_feature ftr, rp_model_output op, sdp_d sdp, premise_d prms, rp_algorithm_def algodef, org org
where org.udc_id = 'SOURCE1'
AND op.score >= 0.5
AND org.id = op.org_id
AND org.id = ftr.org_id
AND org.id = sdp.org_id
AND org.id = prms.org_id
AND org.id = algodef.org_id
AND op.sdp_wid = ftr.sdp_wid
AND op.analysis_end_date = ftr.analysis_end_date
AND op.batch_id = ftr.batch_id
AND ftr.algorithm_wid = algodef.wid
AND prms.wid = sdp.premise_wid
AND op.sdp_wid = sdp.wid
AND op.sdp_wid NOT IN (select sdp_wid from rp_investigation_request req where req.org_id = 1);*/

--------------Test start------------

delete from sdp_d where wid in(1,2,3,4,5);
delete from premise_d where wid in(1,2,3,4,5);
delete from rp_investigation_request where MODEL_OUTPUT_WID in (3,5);
delete from rp_feature where BATCH_ID = 1;
delete from RP_MODEL_OUTPUT where wid in(1,2,3,4,5); 
delete from RP_ALGORITHM where wid in(1,2,3,4,5); 
delete from RP_ALGORITHM_DEF where wid in(1,2,3,4,5); 

delete from rp_sdp_exempt where SDP_WID = 2;
delete from RP_sr_algorithm where service_request_id in (select id from SERVICE_REQUEST WHERE type_cd ='RevenueProtection');
delete from rp_sr where service_request_id = 4;
--delete from service_request_attr where service_request_id in (select id from SERVICE_REQUEST WHERE type_cd ='RevenueProtection');
delete from SR_PENDING WHERE type_cd ='RevenueProtection';
delete from SERVICE_REQUEST WHERE type_cd ='RevenueProtection';

commit;

--------------Test end------------


--------------------------------------------------------


select * from service_request;
-----------------------

select * from rp_model_output;
select * from rp_investigation_request;
select * from rp_feature;
select * from rp_sdp_exempt;
select * from sdp_d;
--select * from rp_closed_sr;
select * from rp_sr;
select * from rp_sr_algorithm;
select * from service_request;
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
drop table RP_ALGORITHM_DEF;
drop table SERVICE_REQUEST;
drop table SR_PENDING;
----------------
--_D
/*
CREATE TABLE PREMISE_D
   (WID NUMBER NOT NULL, 
	BATCH_ID NUMBER, 
	POSTAL_CODE_WID NUMBER NOT NULL, 
	SRC_ID VARCHAR2(15 BYTE) NOT NULL, 
	ORG_ID NUMBER, 
	UDC_ID VARCHAR2(50 BYTE), 
	ADDR_LINE_1 VARCHAR2(200 BYTE), 
	ADDR_LINE_2 VARCHAR2(200 BYTE), 
	GPS_LAT NUMBER(22,8), 
	GPS_LONG NUMBER(22,8), 
	TIMEZONE VARCHAR2(80 BYTE), 
	DISTRICT VARCHAR2(100 BYTE), 
	BLDG_NAME VARCHAR2(50 BYTE), 
	BLDG_TYPE VARCHAR2(50 BYTE), 
	FLOOR VARCHAR2(50 BYTE), 
	FLOOR_TYPE VARCHAR2(50 BYTE), 
	STREET_NUM VARCHAR2(50 BYTE), 
	STREET_NUM_SUFFIX VARCHAR2(50 BYTE), 
	POSTAL_DELIVERY_ID VARCHAR2(50 BYTE), 
	POSTAL_DELIVERY_TYPE VARCHAR2(50 BYTE), 
	STREET_NAME VARCHAR2(100 BYTE), 
	STREET_PREFIX VARCHAR2(50 BYTE), 
	STREET_SUFFIX VARCHAR2(50 BYTE), 
	STREET_TYPE VARCHAR2(50 BYTE), 
	UNIT_NUM VARCHAR2(50 BYTE), 
	UNIT_TYPE VARCHAR2(50 BYTE), 
	REGION VARCHAR2(50 BYTE), 
	TERRITORY VARCHAR2(50 BYTE), 
	MAP_INFO VARCHAR2(50 BYTE), 
	DESC_TEXT VARCHAR2(255 BYTE), 
	INSERT_TIME TIMESTAMP (0) DEFAULT systimestamp NOT NULL, 
	LAST_UPD_TIME TIMESTAMP (0) DEFAULT systimestamp NOT NULL);
  
  
  CREATE TABLE SDP_D 
   (	WID NUMBER NOT NULL , 
	BATCH_ID NUMBER, 
	SRC_ID VARCHAR2(15 BYTE) NOT NULL , 
	ORG_ID NUMBER NOT NULL , 
	CLASS_WID NUMBER, 
	DESC_TEXT VARCHAR2(1000 BYTE), 
	PREMISE_WID NUMBER, 
	FEED_LOC VARCHAR2(80 BYTE), 
	GPS_LAT NUMBER(22,8), 
	GPS_LONG NUMBER(22,8), 
	PULSE_OUTPUT_BLOCK VARCHAR2(80 BYTE), 
	UDC_ID VARCHAR2(200 BYTE) NOT NULL , 
	UNIVERSAL_ID VARCHAR2(200 BYTE), 
	IS_VIRTUAL_FLG CHAR(1 BYTE), 
	SEAL_INFO VARCHAR2(50 BYTE), 
	ACCESS_INFO VARCHAR2(200 BYTE), 
	ALT_ACCESS_INFO VARCHAR2(200 BYTE), 
	LOC_INFO VARCHAR2(200 BYTE), 
	ALT_LOC_INFO VARCHAR2(200 BYTE), 
	TYPE VARCHAR2(50 BYTE), 
	SUB_TYPE VARCHAR2(50 BYTE), 
	TIMEZONE_ID NUMBER, 
	GIS_ID VARCHAR2(50 BYTE), 
	BILLED_UPTO_TIME TIMESTAMP (0), 
	POWER_STATUS CHAR(1 BYTE), 
	LOAD_STATUS CHAR(1 BYTE), 
	BILLING_HOLD_STATUS CHAR(1 BYTE), 
	INSERT_TIME TIMESTAMP (0) DEFAULT systimestamp NOT NULL , 
	LAST_UPD_TIME TIMESTAMP (0) DEFAULT systimestamp NOT NULL , 
	X_CUSTTEST10_WID NUMBER, 
	X_CUSTTEST11_WID NUMBER, 
	X_CUSTTEST12_WID NUMBER, 
	X_CUSTTEST13_WID NUMBER, 
	X_CUSTTEST14_WID NUMBER, 
	X_CUSTTEST15_WID NUMBER, 
	X_CUSTTEST16_WID NUMBER, 
	X_CUSTTEST17_WID NUMBER, 
	X_CUSTTEST18_WID NUMBER, 
	X_CUSTTEST19_WID NUMBER, 
	X_CUSTTEST1_WID NUMBER, 
	X_CUSTTEST2_WID NUMBER, 
	X_CUSTTEST3_WID NUMBER, 
	X_CUSTTEST4_WID NUMBER, 
	X_CUSTTEST5_WID NUMBER, 
	X_CUSTTEST6_WID NUMBER, 
	X_CUSTTEST7_WID NUMBER, 
	X_CUSTTEST8_WID NUMBER, 
	X_CUSTTEST9_WID NUMBER, 
	X_CUSTTEST20_WID NUMBER,
  CONSTRAINT PK_SDP_D PRIMARY KEY (WID));*/
  
--Job


CREATE TABLE RP_ALGORITHM_DEF(
    WID                					NUMBER   NOT NULL,
    NAME               					 VARCHAR2(100)  not null,
    DESCRIPTION              	 VARCHAR2(1000),
    PROCEDURE_NAME  	 VARCHAR2(100) not null,
    EIP_CD             					 VARCHAR2(10) not null,
    MINUTE_BACKWARD    NUMBER not null,
    ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_ALGORITHM_DEF PRIMARY KEY (WID),
    CONSTRAINT UK_RP_ALGORITHM_DEF   UNIQUE (EIP_CD)
)
;


CREATE TABLE RP_ALGORITHM_DEF_PARAM(
    WID                							NUMBER   NOT NULL,
    ALGORITHM_DEF_WID    	NUMBER   NOT NULL,
    NAME                 						 VARCHAR2(50) not null,
    VALUE                						 VARCHAR2(100),
    ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_ALGORITHM_DEF_PARAM PRIMARY KEY (WID),
    CONSTRAINT UK_RP_ALGORITHM_DEF_PARAM   UNIQUE (ALGORITHM_DEF_WID, NAME)
)
;






CREATE TABLE RP_ALGORITHM(
    WID                       									NUMBER    NOT NULL,
    SDP_SEGMENT_CONFIG_WID    	NUMBER    NOT NULL,
    ALGORITHM_DEF_WID    				NUMBER   NOT NULL,
    ALGORITHM_EIP_CD             					 VARCHAR2(10) not null,
    ACTIVE_FLAG               						CHAR(1) NOT NULL,
    MINUTE_BACKWARD    					NUMBER not null,
    ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_ALGORITHM PRIMARY KEY (WID),
    CONSTRAINT UK_RP_ALGORITHM   UNIQUE (SDP_SEGMENT_CONFIG_WID, ALGORITHM_DEF_WID)
)
;




CREATE TABLE RP_ALGORITHM_PARAM(
    WID                							NUMBER   NOT NULL,
    ALGORITHM_WID    				NUMBER   NOT NULL,
    NAME                 						 VARCHAR2(50) not null,
    VALUE                						 VARCHAR2(100),
  ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_ALGORITHM_PARAM PRIMARY KEY (WID),
    CONSTRAINT UK_RP_ALGORITHM_PARAM   UNIQUE (ALGORITHM_WID, NAME)
)
;


CREATE TABLE RP_EXECUTION_STAT(
    BATCH_ID              						 NUMBER not null,
    ALGORITHM_WID    					NUMBER   NOT NULL,
    ANALYSIS_END_DATE             date not null,
    START_TIME             					timestamp not null,
    END_TIME               					timestamp,
    SUCCESS_FLAG              					CHAR(1) NOT NULL,
    SDP_OUTCOME_COUNT     NUMBER  null,
    SDP_SEGMENT_COUNT     NUMBER  null,
    PARAM_TEXT              					 VARCHAR2(4000),
    ERROR_MSG              					 VARCHAR2(4000),
    ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_EXECUTION_STAT PRIMARY KEY (BATCH_ID, ALGORITHM_WID, ANALYSIS_END_DATE)
);


CREATE TABLE RP_FEATURE(
    BATCH_ID              						 NUMBER not null,
    ALGORITHM_WID        				NUMBER    NOT NULL,
    ANALYSIS_END_DATE             			date not null,
    SDP_WID              						NUMBER not null,
    ACTUAL_VALUE         				numeric(21,6) not null,
    DESCRIPTION 					VARCHAR2(4000),
    ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_FEATURE PRIMARY KEY (BATCH_ID, ALGORITHM_WID, ANALYSIS_END_DATE)
);

/*
ALTER TABLE RP_FEATURE ADD CONSTRAINT FK_RP_FEATURE_2
    FOREIGN KEY (SDP_WID)
    REFERENCES SDP_D(WID)
;
*/

CREATE TABLE RP_MODEL_OUTPUT(
    WID                							NUMBER   NOT NULL,
    BATCH_ID              						 NUMBER not null,
    ANALYSIS_END_DATE             date not null,
    ANALYSIS_Start_DATE             date not null, --updated
    SDP_WID              						NUMBER not null,
    --SEQ_NUM              						NUMBER not null,
    SCORE            								NUMBER not null,
    MODEL_VERSION    					 VARCHAR2(100),
  ORG_ID          									NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_MODEL_OUTPUT PRIMARY KEY (WID),
    CONSTRAINT UK_RP_MODEL_OUTPUT unique (BATCH_ID,  ANALYSIS_END_DATE, SDP_WID, MODEL_VERSION)
);

CREATE TABLE RP_INVESTIGATION_REQUEST(
    model_output_wid    NUMBER           NOT NULL,
    sdp_wid             NUMBER           NOT NULL,
    batch_id            NUMBER    NOT NULL,
    ORG_ID          	NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT PK_RP_INVESTIGATION_REQUEST PRIMARY KEY (model_output_wid)
);


CREATE TABLE RP_INVESTIGATION(
    model_output_wid              NUMBER     NULL,
    batch_id                      NUMBER     NULL,
    service_request_id            NUMBER     NULL,
    sdp_wid                       NUMBER,
    sdp_udc_id                    VARCHAR2(200),
    service_request_open_time     TIMESTAMP     NOT NULL,
    service_request_close_time    TIMESTAMP,
    investigation_outcome_cd      VARCHAR2(50),
    sr_outcome_cd                 VARCHAR2(50),
    sr_outcome_reason_cd          VARCHAR2(50),
    sr_sub_type_cd                VARCHAR2(50),
    ORG_ID          	NUMBER,
    INSERT_TIME       TIMESTAMP    DEFAULT sysdate NOT NULL,
    LAST_UPD_TIME     TIMESTAMP    DEFAULT sysdate NOT NULL,
    CONSTRAINT UK_RP_INVESTIGATION_1  UNIQUE (sdp_wid, sdp_udc_id, model_output_wid, service_request_id, service_request_open_time)
);

ALTER TABLE RP_ALGORITHM_DEF_PARAM ADD CONSTRAINT FK_RP_ALGORITHM_DEF_PARAM_1
    FOREIGN KEY (ALGORITHM_DEF_WID)
    REFERENCES RP_ALGORITHM_DEF(WID)
;
--throws error
/*ALTER TABLE RP_ALGORITHM ADD CONSTRAINT FK_RP_ALGORITHM_1
    FOREIGN KEY (SDP_SEGMENT_CONFIG_WID)
    REFERENCES SDP_SEGMENT_CONFIG(WID)
;*/


ALTER TABLE RP_ALGORITHM ADD CONSTRAINT FK_RP_ALGORITHM_2
    FOREIGN KEY (ALGORITHM_DEF_WID)
    REFERENCES RP_ALGORITHM_DEF(WID)
;

ALTER TABLE RP_ALGORITHM_PARAM ADD CONSTRAINT FK_RP_ALGORITHM_PARAM_1
    FOREIGN KEY (ALGORITHM_WID)
    REFERENCES RP_ALGORITHM(WID)
;
ALTER TABLE RP_EXECUTION_STAT ADD CONSTRAINT FK_RP_EXECUTION_STAT_1
    FOREIGN KEY (ALGORITHM_WID)
    REFERENCES RP_ALGORITHM(WID)
;

ALTER TABLE RP_FEATURE ADD CONSTRAINT FK_RP_FEATURE_1
    FOREIGN KEY (ALGORITHM_WID)
    REFERENCES RP_ALGORITHM(WID)
;
ALTER TABLE RP_INVESTIGATION_REQUEST ADD CONSTRAINT FK_RP_INVESTIGATION_REQUEST_1
    FOREIGN KEY (model_output_wid)
    REFERENCES RP_MODEL_OUTPUT(WID)
;
ALTER TABLE RP_INVESTIGATION ADD CONSTRAINT FK_RP_INVESTIGATION_1
    FOREIGN KEY (model_output_wid)
    REFERENCES RP_MODEL_OUTPUT(WID)
;





-------------------------

insert into rp_sr(service_request_id,service_request_open_time,model_output_wid,rp_model_score,sdp_wid,sdp_udc_id,
sdp_universal_id,sdp_gps_lat,sdp_gps_long,sdp_address,premise_wid,data_ref_start_time,data_ref_end_time,
recommendation_cd,ORG_ID,INSERT_TIME,INSERT_BY,LAST_UPD_BY,LAST_UPD_TIME,REC_VERSION_NUM )
values(4,sysdate,4,0.7,4,'sdpudc-4','sdpuniv-4',0.23,0.45,'address',4,sysdate,sysdate,'Y',1,sysdate,1,1,sysdate,1);



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


CREATE TABLE ORG 
   (	ID NUMBER NOT NULL ENABLE, 
	LAST_UPD_TIME TIMESTAMP (0) DEFAULT systimestamp NOT NULL ENABLE, 
	INSERT_TIME TIMESTAMP (0) DEFAULT systimestamp NOT NULL ENABLE, 
	INSERT_BY NUMBER, 
	LAST_UPD_BY NUMBER, 
	UDC_ID VARCHAR2(50 BYTE), 
	NAME VARCHAR2(50 BYTE), 
	DESC_TEXT VARCHAR2(255 BYTE), 
	MASTER_DATA_ORG_ID NUMBER, 
	REC_VERSION_NUM NUMBER, 
	 CONSTRAINT PK_ORG PRIMARY KEY (ID));
   
/*Extract SQLS ********************************************************/
   1-QFHA
select * from s_org_ext ;

Insert into s_asset(ROW_ID,CREATED,CREATED_BY,LAST_UPD,LAST_UPD_BY,MODIFICATION_NUM,CONFLICT_ID,ASSET_NUM,AUTO_SR_FLG,BU_ID,COMP_UND_WRNTY_FLG,CUSTOMIZABLE_FLG,DMNDNG_DR_FLG,FLEET_FLG,HH_CONSUMED_FLG,PROD_UND_WRNTY_FLG,REFERENCEABLE_FLG,SRL_NUM_VRFD_FLG,TEST_ASSET_FLG,UND_MFG_WRNTY_FLG,BILLPAY_FLG,ALT_FUEL_FLG,ANNUAL_REVN,ANNUAL_USG,APR,APY,ARCHIVE_FLG,ASGN_DT,ASGN_USR_EXCLD_FLG,ASSET_VALUE_AMT,ASSET_VAL_EXCH_DT,AVAIL_BAL,AVERAGE_BAL,CAPACITY,CAUTION_FLG,CFG_VALDN_STAT_DT,CURRENT_BAL,CUTOFF_FLG,DLR_INV_PRICE,EFFICIENCY_RATING,END_DT,EXCHG_DT,EXCH_DATE,EXTD_QTY,EXTENDED_QTY,INCEPTION_DT,INSTALL_DT,INTERNAL_ASSET_FLG,INTR_RATE,LAST_DOWNLOAD_DT,LAST_TEST_DT,LCNS_EXP_DT,LOAD_ADDED,METER_CNT,MFGD_DT,MODEL_YR,MSRP,ORIGINAL_COST,PREMIUM,PREMIUM_DT,PROFIT,PR_REP_DNRM_FLG,PR_REP_MANL_FLG,PR_REP_SYS_FLG,PURCH_ADJ_UNIT_PRI,PURCH_DT,PURCH_LST_UNIT_PRI,QTY,REGISTERED_DT,REL_LIMIT,REVENUE,RPLCMNT_VAL_AMT,SHIP_DT,START_DT,STATUS_CHG_DT,SVC_PER_PROD_AMT,UNINSTALL_DT,WARRANTY_END_DT,WARRANTY_START_DT,WRNTY_LAST_UPD_DT,AAGSVC_CON_ID,ALIAS_NAME,ASSEMBLY_PORT_ID,ASSET_COND_CD,ASSET_IMG_ID,ASSET_VAL_CURCY_CD,BAR_CODE_NUM,BASE_CURRENCY_CD,BILLACCT_ID,BILL_ACCNT_ID,BILL_STATUS_CD,BL_ADDR_ID,BODY_STYLE_CD,BRANCH_ID,BUILD,CAPITALIZED_CD,CASE_ID,CFG_STATE_CD,CFG_TYPE_CD,CFG_VALDN_STAT_CD,CHANNEL_TYPE_CD,COMMENTS,COMPANY_CD,CONDITION_CD,COST_LST_ID,CURCY_CD,CUR_AGREE_ID,DATA_SRC,DESC_TEXT,DLR_ID,DOORS_TYPE_CD,DRIVE_TRAIN_CD,ENGINE_TYPE_CD,EXTENSION_CD,EXT_COLOR_CD,FLEET_OU_ID,FLT_TYPE_CD,FUEL_CD,HLTHACCNT_TYPE_CD,INSCLM_EVT_ID,INTEGRATION_ID,INT_COLOR_CD,INVLOC_ID,LCNS_NUM,LCNS_STATE_CD,LOAD_PERIOD_CD,LOB_CD,LOT_NUM,MAKE_CD,METER_LOC,METER_TYPE_CD,METER_USE_CD,MODEL_CD,NAME,NEW_USD_CD,OPER_STATUS_CD,ORG_CENSUS_ID,ORIG_ORDER_ID,OU_ADDR_ID,OWNERSHIP_TYPE_CD,OWNER_ACCNT_ID,OWNER_ASSET_NUM,OWNER_CON_ID,OWNR_TYPE_CD,PARTNER_BANK,PARTNER_BRANCH,PAR_ASSET_ID,PER_ADDR_ID,PNSN_SUBTYPE_CD,POLICY_SOURCE_ID,PORT_VALID_PROD_ID,PREF_SRV_DLR_ID,PRI_DESC_TEXT,PRI_LST_ID,PRODUCER_CD,PROD_ID,PROD_INV_ID,PROMOTION_ID,PROM_INTEG_ID,PROM_ITEM_ID,PROM_SRC_INTG_ID,PR_ACCNT_ID,PR_ASSET_ID,PR_ASSET_WRNTY_ID,PR_CON_ID,PR_DISCNT_ID,PR_DRVR_ID,PR_EMP_ID,PR_FIN_DTL_ID,PR_GRP_OU_ID,PR_POSTN_ID,PR_TERR_ID,PURCH_LOC_DESC,RATE_CD,RATE_EXCEPTION,RATE_PLAN_CD,RATE_STATE,REASON_CD,REFERRAL_NAME,REF_NUMBER_1,REF_NUMBER_2,REF_NUMBER_3,REGION,REL_TYPE_CD,REV_NUM,ROOT_ASSET_ID,RTNG_DLR_ID,SERIAL_NUM,SERVICE_POINT_ID,SERV_ACCT_ID,SP_NUM,SRV_REGN_ID,SR_RTNG_CD,STATUS_CD,STAT_REASON_CD,STOCK_NUM,SUB_STATUS_CD,SUB_TYPE_CD,SUPPLIER_OU_ID,TERM_CD,THMBNL_IMAGE_ID,TIER_PRI_INFO,TIMEFRAME_CD,TRADEIN_TYPE_CD,TRANSMISSION_CD,TRIM_CD,TYPE_CD,USG_UOM_CD,VALUE_BASIS_CD,VERSION,WARRANTY_TYPE_CD,XA_CLASS_ID,X_AEP_NUM,X_AX_FEED_LOC,X_BILLING_CYCLE,X_ELECTRONIC_ID,X_EMETER_ACCES_INFO,X_EMETER_PREMISE_LOC,X_HIGH_VAL,X_LAST_READ_AMT,X_LATITUDE,X_LATITUDE_NEW,X_LOC_CODE,X_LOCK_FLG,X_LOCK_INFO,X_LOGICAL_CH_NUM,X_LONGITUDE,X_LONGITUDE_NEW,X_LOT_NUM,X_LOW_VAL,X_NETWORK_ID,X_PHYSICAL_CH_NUM,X_POWER_STATUS,X_PULSE_OUTPUT_BLK,X_READ_DT,X_READING_CYCLE,X_REGISTERED__PRVDR_STAT,X_RETIRE_DT,X_ROUTE_OWNER,X_SEAL_INFO,X_SERVICE_ID,X_UDC_ASSET_ID,X_UDC_EXP_USAGE,X_UNIVERSAL_ID,X_USAGE_STATUS,X_UTIL_ACCESS_INFO,X_UTIL_PREMISE_LOC,X_PLAN_APPROVED,X_PLAN_INSTALL_DT,X_MFG_DATE,X_VIRTUAL_ASSET,X_BILLING_HOLD,X_QUERY_LIST)
values('1-ALYT-1DN',to_timestamp('16-JUL-14','DD-MON-RR HH.MI.SSXFF AM'),'1-6F8',to_timestamp('16-JUL-14','DD-MON-RR HH.MI.SSXFF AM'),'1-6F8',0,'0','1-ALYT-1DN','N','1-338','N','N','N','N','N','N','N','N','N','N','N',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'Feeder',null,null,null,null,null,null,null,null,'SOURCE1','Test DN',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'Noida',null,null,null,null,null,null,null,null,null,null,'1-QFG9',null,null,null,null,null,'1-QFH7',null,null,null,null,null,null,null,null,'1-9J6',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'DNSNo-MIG-SC-6_2',null,null,null,null,null,'Active',null,null,null,null,null,null,null,null,null,null,null,null,'Distribution Node',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'N',null,null,null,null,'45',null,null,null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,'1-ALYT-1DN',null,null,null,null,null,null,null,null,null,null,null);

delete from s_org_ext WHERE row_id LIKE '1-ALYT-%';
select * from s_asset where row_id = '1-QFHA';

DELETE FROM s_prod_int WHERE row_id LIKE '1-ALYT-%';
Delete FROM s_addr_per WHERE row_id like '1-ALYT-%';
DELETE FROM s_asset WHERE row_id LIKE '1-ALYT-%';
DELETE FROM s_org_ext WHERE row_id LIKE '1-ALYT-%';
commit;

select distinct type_cd from s_asset;


select * from s_asset_xm where par_row_id = '1-2IWJ';



Insert into s_asset_xm (ROW_ID,CREATED,CREATED_BY,LAST_UPD,LAST_UPD_BY,MODIFICATION_NUM,CONFLICT_ID,PAR_ROW_ID,NAME,TYPE,ATTRIB_08,ATTRIB_09,ATTRIB_10,ATTRIB_11,ATTRIB_12,ATTRIB_13,ATTRIB_14,ATTRIB_15,ATTRIB_16,ATTRIB_17,ATTRIB_18,ATTRIB_19,ATTRIB_20,ATTRIB_21,ATTRIB_22,ATTRIB_23,ATTRIB_24,ATTRIB_25,ATTRIB_26,ATTRIB_27,ATTRIB_28,ATTRIB_29,ATTRIB_30,ATTRIB_31,ATTRIB_32,ATTRIB_33,ATTRIB_01,ATTRIB_02,ATTRIB_03,ATTRIB_04,ATTRIB_05,ATTRIB_06,ATTRIB_07,ATTRIB_34,ATTRIB_35,ATTRIB_36,ATTRIB_37,ATTRIB_38,ATTRIB_39,ATTRIB_40,ATTRIB_41,ATTRIB_42,ATTRIB_43,ATTRIB_44,ATTRIB_45,ATTRIB_46,ATTRIB_47) 
values ('1-2I91',to_timestamp('06-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',to_timestamp('07-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',0,'0','1-2IWJ','1-2I91','SDP_ASSET_ATTRIB',null,null,null,null,to_timestamp('15-JAN-11','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'criticalCareInd','Y','Active',null,'SOURCE1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);


Insert into s_asset_xm (ROW_ID,CREATED,CREATED_BY,LAST_UPD,LAST_UPD_BY,MODIFICATION_NUM,CONFLICT_ID,PAR_ROW_ID,NAME,TYPE,ATTRIB_08,ATTRIB_09,ATTRIB_10,ATTRIB_11,ATTRIB_12,ATTRIB_13,ATTRIB_14,ATTRIB_15,ATTRIB_16,ATTRIB_17,ATTRIB_18,ATTRIB_19,ATTRIB_20,ATTRIB_21,ATTRIB_22,ATTRIB_23,ATTRIB_24,ATTRIB_25,ATTRIB_26,ATTRIB_27,ATTRIB_28,ATTRIB_29,ATTRIB_30,ATTRIB_31,ATTRIB_32,ATTRIB_33,ATTRIB_01,ATTRIB_02,ATTRIB_03,ATTRIB_04,ATTRIB_05,ATTRIB_06,ATTRIB_07,ATTRIB_34,ATTRIB_35,ATTRIB_36,ATTRIB_37,ATTRIB_38,ATTRIB_39,ATTRIB_40,ATTRIB_41,ATTRIB_42,ATTRIB_43,ATTRIB_44,ATTRIB_45,ATTRIB_46,ATTRIB_47) 
values ('1-2I92',to_timestamp('06-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',to_timestamp('07-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',0,'0','1-2IWJ','1-2I92','SDP_ASSET_ATTRIB',null,null,null,null,to_timestamp('15-JAN-11','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'criticalLoadInd','Y','Active',null,'SOURCE1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);


SELECT s.row_id AS src_id,
      NVL(s.data_src, 'SOURCE1') AS data_src,
      --NVL(s.data_src, @primaryOrg@) AS data_src,
      s.x_udc_asset_id AS udc_id,
      mapping.product_name_8x AS prod_name,
      s.desc_text AS desc_text,
      s.x_universal_id AS universal_id,
      s.type_cd AS TYPE,
      s.cfg_type_cd AS sub_type,
      s.status_cd AS status_cd,
      s.x_ax_feed_loc AS feed_loc,
      prms.x_client_prmse_id AS premise_udc_id,
      s.x_util_access_info AS access_info,
      s.x_emeter_acces_info AS alt_access_info,
      s.x_util_premise_loc AS loc_info,
      s.x_emeter_premise_loc AS alt_loc_info,
      s.x_seal_info AS seal_info,
      s.x_lock_info AS lock_info,
      s.x_pulse_output_blk AS pulse_output_block,
      s.x_latitude_new AS gps_lat,
      s.x_longitude_new AS gps_long,
      s.x_virtual_asset AS is_virtual_flg,
      prms.x_time_zn AS timezone,
      s.x_power_status as power_status,
      s.x_read_dt AS billed_upto_date,
      s.x_usage_status AS load_status,
      s.x_billing_hold AS billing_hold_status,
      param.attrib_01 AS param_name,
      param.attrib_02 AS param_value,
      param.attrib_12 AS eff_start_date,
      param.attrib_13 AS eff_end_date
 FROM s_asset s,
      s_addr_per prms,
      s_prod_int prod,
      cx_product_name_mapping mapping,
      s_asset_xm param
WHERE s.per_addr_id = prms.row_id
      AND s.prod_id = prod.row_id
      AND mapping.product_name_7x = prod.name
      AND param.par_row_id (+) = s.row_id
      AND s.type_cd IN ('Service Point')
      order by NVL(s.data_src, 'SOURCE1'), s.row_id;
      --order by NVL(s.data_src, @primaryOrg@), s.row_id;
      
select distinct type_cd from s_asset;      
      /**************************************************************************/
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      drop table cx_product_name_mapping;

create table cx_product_name_mapping(
product_name_7x varchar2(100),
type_7x varchar2(30),
sub_type_7x varchar2(30),
product_name_8x varchar2(100),
type_8x varchar2(30),
sub_type_8x varchar2(30),
udc_id_8x varchar2(50), -- used mainly for Meas Type
register_index_7x varchar2(10)
);

create table cx_product_name_mapping(
product_name_7x varchar2(100),
type_7x varchar2(30),
sub_type_7x varchar2(30),
product_name_8x varchar2(100),
type_8x varchar2(30),
sub_type_8x varchar2(30),
udc_id_8x varchar2(50), -- used mainly for Meas Type
register_index_7x varchar2(10)
);
  
  1-QFHA
select * from s_org_ext ;



Insert into s_asset(ROW_ID,CREATED,CREATED_BY,LAST_UPD,LAST_UPD_BY,MODIFICATION_NUM,CONFLICT_ID,ASSET_NUM,AUTO_SR_FLG,BU_ID,COMP_UND_WRNTY_FLG,CUSTOMIZABLE_FLG,DMNDNG_DR_FLG,FLEET_FLG,HH_CONSUMED_FLG,PROD_UND_WRNTY_FLG,REFERENCEABLE_FLG,SRL_NUM_VRFD_FLG,TEST_ASSET_FLG,UND_MFG_WRNTY_FLG,BILLPAY_FLG,ALT_FUEL_FLG,ANNUAL_REVN,ANNUAL_USG,APR,APY,ARCHIVE_FLG,ASGN_DT,ASGN_USR_EXCLD_FLG,ASSET_VALUE_AMT,ASSET_VAL_EXCH_DT,AVAIL_BAL,AVERAGE_BAL,CAPACITY,CAUTION_FLG,CFG_VALDN_STAT_DT,CURRENT_BAL,CUTOFF_FLG,DLR_INV_PRICE,EFFICIENCY_RATING,END_DT,EXCHG_DT,EXCH_DATE,EXTD_QTY,EXTENDED_QTY,INCEPTION_DT,INSTALL_DT,INTERNAL_ASSET_FLG,INTR_RATE,LAST_DOWNLOAD_DT,LAST_TEST_DT,LCNS_EXP_DT,LOAD_ADDED,METER_CNT,MFGD_DT,MODEL_YR,MSRP,ORIGINAL_COST,PREMIUM,PREMIUM_DT,PROFIT,PR_REP_DNRM_FLG,PR_REP_MANL_FLG,PR_REP_SYS_FLG,PURCH_ADJ_UNIT_PRI,PURCH_DT,PURCH_LST_UNIT_PRI,QTY,REGISTERED_DT,REL_LIMIT,REVENUE,RPLCMNT_VAL_AMT,SHIP_DT,START_DT,STATUS_CHG_DT,SVC_PER_PROD_AMT,UNINSTALL_DT,WARRANTY_END_DT,WARRANTY_START_DT,WRNTY_LAST_UPD_DT,AAGSVC_CON_ID,ALIAS_NAME,ASSEMBLY_PORT_ID,ASSET_COND_CD,ASSET_IMG_ID,ASSET_VAL_CURCY_CD,BAR_CODE_NUM,BASE_CURRENCY_CD,BILLACCT_ID,BILL_ACCNT_ID,BILL_STATUS_CD,BL_ADDR_ID,BODY_STYLE_CD,BRANCH_ID,BUILD,CAPITALIZED_CD,CASE_ID,CFG_STATE_CD,CFG_TYPE_CD,CFG_VALDN_STAT_CD,CHANNEL_TYPE_CD,COMMENTS,COMPANY_CD,CONDITION_CD,COST_LST_ID,CURCY_CD,CUR_AGREE_ID,DATA_SRC,DESC_TEXT,DLR_ID,DOORS_TYPE_CD,DRIVE_TRAIN_CD,ENGINE_TYPE_CD,EXTENSION_CD,EXT_COLOR_CD,FLEET_OU_ID,FLT_TYPE_CD,FUEL_CD,HLTHACCNT_TYPE_CD,INSCLM_EVT_ID,INTEGRATION_ID,INT_COLOR_CD,INVLOC_ID,LCNS_NUM,LCNS_STATE_CD,LOAD_PERIOD_CD,LOB_CD,LOT_NUM,MAKE_CD,METER_LOC,METER_TYPE_CD,METER_USE_CD,MODEL_CD,NAME,NEW_USD_CD,OPER_STATUS_CD,ORG_CENSUS_ID,ORIG_ORDER_ID,OU_ADDR_ID,OWNERSHIP_TYPE_CD,OWNER_ACCNT_ID,OWNER_ASSET_NUM,OWNER_CON_ID,OWNR_TYPE_CD,PARTNER_BANK,PARTNER_BRANCH,PAR_ASSET_ID,PER_ADDR_ID,PNSN_SUBTYPE_CD,POLICY_SOURCE_ID,PORT_VALID_PROD_ID,PREF_SRV_DLR_ID,PRI_DESC_TEXT,PRI_LST_ID,PRODUCER_CD,PROD_ID,PROD_INV_ID,PROMOTION_ID,PROM_INTEG_ID,PROM_ITEM_ID,PROM_SRC_INTG_ID,PR_ACCNT_ID,PR_ASSET_ID,PR_ASSET_WRNTY_ID,PR_CON_ID,PR_DISCNT_ID,PR_DRVR_ID,PR_EMP_ID,PR_FIN_DTL_ID,PR_GRP_OU_ID,PR_POSTN_ID,PR_TERR_ID,PURCH_LOC_DESC,RATE_CD,RATE_EXCEPTION,RATE_PLAN_CD,RATE_STATE,REASON_CD,REFERRAL_NAME,REF_NUMBER_1,REF_NUMBER_2,REF_NUMBER_3,REGION,REL_TYPE_CD,REV_NUM,ROOT_ASSET_ID,RTNG_DLR_ID,SERIAL_NUM,SERVICE_POINT_ID,SERV_ACCT_ID,SP_NUM,SRV_REGN_ID,SR_RTNG_CD,STATUS_CD,STAT_REASON_CD,STOCK_NUM,SUB_STATUS_CD,SUB_TYPE_CD,SUPPLIER_OU_ID,TERM_CD,THMBNL_IMAGE_ID,TIER_PRI_INFO,TIMEFRAME_CD,TRADEIN_TYPE_CD,TRANSMISSION_CD,TRIM_CD,TYPE_CD,USG_UOM_CD,VALUE_BASIS_CD,VERSION,WARRANTY_TYPE_CD,XA_CLASS_ID,X_AEP_NUM,X_AX_FEED_LOC,X_BILLING_CYCLE,X_ELECTRONIC_ID,X_EMETER_ACCES_INFO,X_EMETER_PREMISE_LOC,X_HIGH_VAL,X_LAST_READ_AMT,X_LATITUDE,X_LATITUDE_NEW,X_LOC_CODE,X_LOCK_FLG,X_LOCK_INFO,X_LOGICAL_CH_NUM,X_LONGITUDE,X_LONGITUDE_NEW,X_LOT_NUM,X_LOW_VAL,X_NETWORK_ID,X_PHYSICAL_CH_NUM,X_POWER_STATUS,X_PULSE_OUTPUT_BLK,X_READ_DT,X_READING_CYCLE,X_REGISTERED__PRVDR_STAT,X_RETIRE_DT,X_ROUTE_OWNER,X_SEAL_INFO,X_SERVICE_ID,X_UDC_ASSET_ID,X_UDC_EXP_USAGE,X_UNIVERSAL_ID,X_USAGE_STATUS,X_UTIL_ACCESS_INFO,X_UTIL_PREMISE_LOC,X_PLAN_APPROVED,X_PLAN_INSTALL_DT,X_MFG_DATE,X_VIRTUAL_ASSET,X_BILLING_HOLD,X_QUERY_LIST)
values('1-ALYT-1DN',to_timestamp('16-JUL-14','DD-MON-RR HH.MI.SSXFF AM'),'1-6F8',to_timestamp('16-JUL-14','DD-MON-RR HH.MI.SSXFF AM'),'1-6F8',0,'0','1-ALYT-1DN','N','1-338','N','N','N','N','N','N','N','N','N','N','N',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'Feeder',null,null,null,null,null,null,null,null,'SOURCE1','Test DN',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'Noida',null,null,null,null,null,null,null,null,null,null,'1-QFG9',null,null,null,null,null,'1-QFH7',null,null,null,null,null,null,null,null,'1-9J6',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'DNSNo-MIG-SC-6_2',null,null,null,null,null,'Active',null,null,null,null,null,null,null,null,null,null,null,null,'Distribution Node',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'N',null,null,null,null,'45',null,null,null,null,null,null,null,null,to_timestamp('01-JAN-10','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,'1-ALYT-1DN',null,null,null,null,null,null,null,null,null,null,null);

delete from s_org_ext WHERE row_id LIKE '1-ALYT-%';
select * from s_asset where row_id = '1-QFHA';

DELETE FROM s_prod_int WHERE row_id LIKE '1-ALYT-%';
Delete FROM s_addr_per WHERE row_id like '1-ALYT-%';
DELETE FROM s_asset WHERE row_id LIKE '1-ALYT-%';
DELETE FROM s_org_ext WHERE row_id LIKE '1-ALYT-%';
commit;

select distinct type_cd from s_asset;


select * from s_asset_xm where par_row_id = '1-2IWJ';



Insert into s_asset_xm (ROW_ID,CREATED,CREATED_BY,LAST_UPD,LAST_UPD_BY,MODIFICATION_NUM,CONFLICT_ID,PAR_ROW_ID,NAME,TYPE,ATTRIB_08,ATTRIB_09,ATTRIB_10,ATTRIB_11,ATTRIB_12,ATTRIB_13,ATTRIB_14,ATTRIB_15,ATTRIB_16,ATTRIB_17,ATTRIB_18,ATTRIB_19,ATTRIB_20,ATTRIB_21,ATTRIB_22,ATTRIB_23,ATTRIB_24,ATTRIB_25,ATTRIB_26,ATTRIB_27,ATTRIB_28,ATTRIB_29,ATTRIB_30,ATTRIB_31,ATTRIB_32,ATTRIB_33,ATTRIB_01,ATTRIB_02,ATTRIB_03,ATTRIB_04,ATTRIB_05,ATTRIB_06,ATTRIB_07,ATTRIB_34,ATTRIB_35,ATTRIB_36,ATTRIB_37,ATTRIB_38,ATTRIB_39,ATTRIB_40,ATTRIB_41,ATTRIB_42,ATTRIB_43,ATTRIB_44,ATTRIB_45,ATTRIB_46,ATTRIB_47) 
values ('1-2I91',to_timestamp('06-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',to_timestamp('07-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',0,'0','1-2IWJ','1-2I91','SDP_ASSET_ATTRIB',null,null,null,null,to_timestamp('15-JAN-11','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'criticalCareInd','Y','Active',null,'SOURCE1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);


Insert into s_asset_xm (ROW_ID,CREATED,CREATED_BY,LAST_UPD,LAST_UPD_BY,MODIFICATION_NUM,CONFLICT_ID,PAR_ROW_ID,NAME,TYPE,ATTRIB_08,ATTRIB_09,ATTRIB_10,ATTRIB_11,ATTRIB_12,ATTRIB_13,ATTRIB_14,ATTRIB_15,ATTRIB_16,ATTRIB_17,ATTRIB_18,ATTRIB_19,ATTRIB_20,ATTRIB_21,ATTRIB_22,ATTRIB_23,ATTRIB_24,ATTRIB_25,ATTRIB_26,ATTRIB_27,ATTRIB_28,ATTRIB_29,ATTRIB_30,ATTRIB_31,ATTRIB_32,ATTRIB_33,ATTRIB_01,ATTRIB_02,ATTRIB_03,ATTRIB_04,ATTRIB_05,ATTRIB_06,ATTRIB_07,ATTRIB_34,ATTRIB_35,ATTRIB_36,ATTRIB_37,ATTRIB_38,ATTRIB_39,ATTRIB_40,ATTRIB_41,ATTRIB_42,ATTRIB_43,ATTRIB_44,ATTRIB_45,ATTRIB_46,ATTRIB_47) 
values ('1-2I92',to_timestamp('06-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',to_timestamp('07-MAY-14','DD-MON-RR HH.MI.SSXFF AM'),'1-BTO',0,'0','1-2IWJ','1-2I92','SDP_ASSET_ATTRIB',null,null,null,null,to_timestamp('15-JAN-11','DD-MON-RR HH.MI.SSXFF AM'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'criticalLoadInd','Y','Active',null,'SOURCE1',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);


select * from cx_product_name_mapping;

select row_id, service_point_id from s_asset ch where ch.type_cd = 'Channel'
AND NVL(ch.x_virtual_asset,'N') = 'Y';

SELECT s.row_id AS src_id,
      NVL(s.data_src, 'SOURCE1') AS data_src,
      --NVL(s.data_src, @primaryOrg@) AS data_src,
      s.x_udc_asset_id AS udc_id,
      mapping.product_name_8x AS prod_name,
      s.desc_text AS desc_text,
      s.x_universal_id AS universal_id,
      s.type_cd AS TYPE,
      s.cfg_type_cd AS sub_type,
      s.status_cd AS status_cd,
      s.x_ax_feed_loc AS feed_loc,
      prms.x_client_prmse_id AS premise_udc_id,
      s.x_util_access_info AS access_info,
      s.x_emeter_acces_info AS alt_access_info,
      s.x_util_premise_loc AS loc_info,
      s.x_emeter_premise_loc AS alt_loc_info,
      s.x_seal_info AS seal_info,
      s.x_lock_info AS lock_info,
      s.x_pulse_output_blk AS pulse_output_block,
      s.x_latitude_new AS gps_lat,
      s.x_longitude_new AS gps_long,
      s.x_virtual_asset AS is_virtual_flg,
      prms.x_time_zn AS timezone,
      s.x_power_status as power_status,
      s.x_read_dt AS billed_upto_date,
      s.x_usage_status AS load_status,
      s.x_billing_hold AS billing_hold_status,
      param.attrib_01 AS param_name,
      param.attrib_02 AS param_value,
      param.attrib_12 AS eff_start_date,
      param.attrib_13 AS eff_end_date
 FROM s_asset s,
      s_addr_per prms,
      s_prod_int prod,
      cx_product_name_mapping mapping,
      s_asset_xm param
WHERE s.per_addr_id = prms.row_id
      AND s.prod_id = prod.row_id
      AND mapping.product_name_7x = prod.name
      AND param.par_row_id (+) = s.row_id
      AND s.type_cd IN ('Service Point')
      order by NVL(s.data_src, 'SOURCE1'), s.row_id;
      --order by NVL(s.data_src, @primaryOrg@), s.row_id;

/*
'1-QFFX','1-QFH1','1-QFI5','1-QFLH','1-QFML','1-QFR1','1-QFYL','1-QGA3','1-QFET','1-QFJ9','1-QFKD','1-QFNP','1-QFOT','1-QFPX','1-QFSU','1-QG4C','1-14WA'
*/
 IN ('1-QFFX','1-QFH1','1-QFI5','1-QFLH','1-QFML','1-QFR1','1-QFYL','1-QGA3','1-QFET','1-QFJ9','1-QFKD','1-QFNP','1-QFOT','1-QFPX','1-QFSU','1-QG4C','1-14WA');
 
 
 SELECT ch.row_id AS src_id
					     --, NVL(ch.data_src, @primaryOrg@) AS data_src
               , NVL(ch.data_src, 'SOURCE1') AS data_src
					     , ch.x_udc_asset_id AS udc_id
					     , ch.status_cd AS status_cd
					     , ch.desc_text AS desc_text
					     , NVL(ch.x_virtual_asset,'N') AS is_virtual_flg
					     , ch.type_cd AS TYPE
					     , ch.cfg_type_cd AS sub_type
					     , sdp.x_udc_asset_id AS sdp_udc_id
					     , mapping.udc_id_8x AS prod_name
					     , param.attrib_01 AS param_name
					     , param.attrib_02 AS param_value
					     , param.attrib_12 AS param_eff_start_time
					     , param.attrib_13 AS param_eff_end_time
					     , mapping.register_index_7x
					     , rel.meter_loc_start_dt AS relation_start_dt
					     , rel.meter_loc_end_dt AS relation_end_dt
					     , rel.x_alias AS child_ch_symbol
					     , vc_sdp.x_udc_asset_id as vc_sdp_udc_id
					     , vc_mapping.udc_id_8x AS vc_prod_name
					     , vc_ch.row_id AS vc_src_id
					     , rel.row_id AS rel_src_id
					     , CASE WHEN param.attrib_01 = 'Formula'
					             AND param.type      = 'CHANNEL_ASSET_ATTRIB'
					            THEN (SELECT caxx.x_attribute_02 AS formula_expr
					                    FROM cx_asset_xm_x caxx
					                   WHERE caxx.par_row_id = param.row_id)
					        ELSE
					             NULL
					        END AS vc_formula
					FROM s_asset ch
					     , s_asset sdp
					     , s_prod_int prod
					     , s_asset_xm param
					     , cx_product_name_mapping mapping
					     , s_asset_rel rel
					     , s_asset vc_ch
					     , s_asset vc_sdp
					     , s_prod_int vc_prod
					     , cx_product_name_mapping vc_mapping
					WHERE ch.service_point_id = sdp.row_id
					   AND ch.type_cd          = 'Channel'
					   AND ch.row_id           = param.par_row_id (+)
					   AND ch.prod_id          = prod.row_id
					   AND prod.name           = mapping.product_name_7x
					   AND NVL(ch.x_virtual_asset,'N') = 'Y'
					   --AND sdp.row_id   IN ('1-QFFX','1-QFH1','1-QFI5','1-QFLH','1-QFML','1-QFR1','1-QFYL','1-QGA3','1-QFET','1-QFJ9','1-QFKD','1-QFNP','1-QFOT','1-QFPX','1-QFSU','1-QG4C','1-14WA') --= ?
             --AND sdp.row_id   IN ('1-QFYL','1-QGA3','1-QFSU','1-QG4C') --= ?
             AND sdp.row_id   IN ('1-QFSU') --= ?
					   AND rel.par_asset_id    = ch.row_id
					   AND rel.x_asset_relation_type_cd = 'CHANNEL-CHANNEL'
					  -- AND rel.asset_id        = vc_ch.row_id
					   --AND vc_sdp.row_id       = vc_ch.service_point_id
					   --AND vc_prod.row_id      = vc_ch.prod_id
					   --AND vc_prod.row_id      = vc_mapping.product_name_7x
					   ORDER BY NVL(ch.data_src, 'SOURCE1'), ch.row_id, mapping.udc_id_8x;

select distinct x_asset_relation_type_cd from s_asset_rel; 


select * from s_asset_rel where x_asset_relation_type_cd = 'CHANNEL-CHANNEL' and asset_id = '1-QFTK';

select row_id,type_cd, NVL(x_virtual_asset,'N'), service_point_id from s_asset where row_id in ('1-QFTO', '1-QFTK');


