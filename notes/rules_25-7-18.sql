CREATE DATABASE  IF NOT EXISTS `rulessvc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rulessvc`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: rulessvc
-- ------------------------------------------------------
-- Server version 5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `headers`
--

DROP TABLE IF EXISTS `headers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headers` (
  `headerid` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`headerid`,`name`),
  CONSTRAINT `fkq5ui7p9bsiuskhq49dds1870v` FOREIGN KEY (`headerid`) REFERENCES `ruleaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headers`
--

LOCK TABLES `headers` WRITE;
/*!40000 ALTER TABLE `headers` DISABLE KEYS */;
/*!40000 ALTER TABLE `headers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `rule_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_rule_rulename` (`rule_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (1,'LaunchRequestEvent','','LaunchRequestEvent'),
(2,'LaunchResponseEvent','','LaunchResponseEvent'),
(3,'LaunchTerminatedEvent','','LaunchTerminatedEvent'),
(4,'ErrorLaunchRequestEvent','','ErrorLaunchRequestEvent'),
(5,'RegisterEnvironmentEvent ',1,'RegisterEnvironmentEvent ');
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruleaction`
--

DROP TABLE IF EXISTS `ruleaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruleaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(255) NOT NULL,
  `body_template` text,
  `content_type` varchar(255) NOT NULL,
  `continue_on_failure` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `method` varchar(255) NOT NULL,
  `retry_count` int(11) NOT NULL,
  `retry_delay_seconds` int(11) NOT NULL,
  `rule_id` bigint(20) NOT NULL,
  `url` varchar(255) NOT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_ruleaction_rule_id_action_name` (`rule_id`,`action_name`),
  UNIQUE KEY `idx_ruleaction_rule_id_weight` (`rule_id`,`weight`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruleaction`
--

LOCK TABLES `ruleaction` WRITE;
/*!40000 ALTER TABLE `ruleaction` DISABLE KEYS */;


INSERT INTO `ruleaction` VALUES (1,'getCSTMetadata',NULL,'application/json','\0','','GET',0,0,1,'http://192.168.56.102:32004/cst-service/rest/v1/api/csts/${cstId}/fields?path=/Metadata&keysOnly=false',10),
(2,'getResolvedAction','${inputs}','application/json','\0','','POST',0,0,1,'http://192.168.56.102:32004/cst-service/rest/v1/api/csts/${cstId}/resolvedAction?actionName=${cstActionName}',20),
(7,'getInstance',NULL,'application/json','\0','','GET',0,0,1,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${instanceId}',70),
(12,'launchAction','{ \"cstId\": \"${cstId}\", \"customerId\": \"${customerId}\",  \"delegator\": \"${getResolvedAction.body.delegator}\",  \"environmentId\": \"${environmentId}\",  \"instanceId\": \"${instanceId}\", \"launchId\": \"${launchId}\",  \"resolvedAction\": \"${getResolvedAction.body}\", \"phase\": \"${phase}\", \"instanceProperties\" : \"${getInstance.body.properties}\", \"instanceHistoryId\" : \"${getInstance.body.propertyHistoryId}\"  , \"parentLaunchId\" : \"${parentLaunchId}\", \"environments\" : \"${getCustomerEnvironments.body}\" }','application/json','\0','','POST',0,0,1,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches',120),
(13,'getInstanceId',NULL,'application/json','\0','','GET',0,0,1,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches/${launchId}',130),
(14,'updateInstanceState',NULL,'application/json','\0','','PUT',0,0,1,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${getInstanceId.body.instanceId}/state/InProgress',140),
(15,'getInstanceId',NULL,'application/json','\0','','GET',0,0,2,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches/${launchId}',10),
(16,'updateInstanceProperties','${outputs}','application/json','\0','','PUT',0,0,2,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/properties/${getInstanceId.body.instanceId}',20),
(17,'getInstanceProperties',NULL,'application/json','\0','','GET',0,0,2,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${getInstanceId.body.instanceId}',30),
(18,'updateLaunchStatus','{ "message": "${message}", "status": "${status}",  "outputs": "${outputs}", "instanceProperties" : "${getInstanceProperties.body.properties}", "environments" : "${getCustomerEnvironments.body}" }','application/json','\0','','PUT',0,0,2,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches/${launchId}/history',40),
(19,'getInstanceId',NULL,'application/json','\0','','GET',0,0,3,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches/${launchId}',10),
(20,'getActionScope',NULL,'application/json','\0','','GET',0,0,3,'http://192.168.56.102:32004/cst-service/rest/v1/api/csts/${cstId}/fields?path=/Actions/${actionName}/Scope&keysOnly=false',20),
(21,'updateInstanceState',NULL,'application/json','\0','','PUT',0,0,3,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${getInstanceId.body.instanceId}/state/Active',30),
(22,'updateInstanceStateForFailure',NULL,'application/json','\0','','PUT',0,0,3,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${getInstanceId.body.instanceId}/state/Failed',40),
(23,'updateInstanceStateForRetired',NULL,'application/json','\0','','PUT',0,0,3,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${getInstanceId.body.instanceId}/state/Retired',50),
(24,'updateInstanceStateForFailure',NULL,'application/json','\0','','PUT',0,0,4,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${request.body.instanceId}/state/Failed',10),
(25,'updateLaunchStatusForEnvironment','{ "message": "${message}", "status": "${status}",  "outputs": "${outputs}", "environments" : "${getCustomerEnvironments.body}" }','application/json','\0',1,'PUT',0,0,2,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches/${launchId}/history',50),
(26,'getCustomerEnvironments',NULL,'application/json','\0',1,'GET',0,0,1,'http://192.168.56.102:32030/environment-service/rest/v1/api/environments/${environmentId}/properties',110),
(27,'createEnvironment','{ \"id\": \"${id}\", \"customerId\": \"${customerId}\",  \"location\": \"${location}\",  \"name\": \"${name}\",  \"parentEnvironmentId\": \"${parentEnvironmentId}\", \"type\": \"${type}\",  \"properties\": \"${properties}\" }','application/json','\0',1,'POST',0,0,5,'http://192.168.56.102:32030/environment-service/rest/v1/api/environments',10),
(28,'getLaunchDetail',NULL,'application/json','\0',1,'GET',0,0,2,'http://192.168.56.102:8008/orch-service/rest/v1/api/launches/${launchId}',31),
(29,'getCustomerEnvironments',NULL,'application/json','\0',1,'GET',0,0,2,'http://192.168.56.102:32030/environment-service/rest/v1/api/environments/${getLaunchDetail.body.environmentId}/properties',32),
(30,'getCST',NULL,'application/json','\0',1,'GET',0,0,3,'http://192.168.56.102:32004/cst-service/rest/v1/api/csts/${cstId}',60),
(31,'updateCSTVersion','{ \"cstVersion\": \"${getCST.body.Metadata.Version}\" }','application/json','\0',1,'PUT',0,0,3,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/${getInstanceId.body.instanceId}',70),
(32,'upgradeInstanceProperties','{ \"InstanceProperties\": \"${getCST.body.InstanceProperties}\", \"Outputs\": "${outputs}" }','application/json','\0',1,'PUT',0,0,3,'http://192.168.56.102:32012/instance-service/rest/v1/api/instances/properties/${getInstanceId.body.instanceId}/upgrade-instance',80);
/*!40000 ALTER TABLE `ruleaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruleactionexpression`
--

DROP TABLE IF EXISTS `ruleactionexpression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruleactionexpression` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `expression` varchar(500) NOT NULL,
  `rule_action_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_ruleactionexpression_rule_action_id_expression` (`rule_action_id`,`expression`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruleactionexpression`
--

LOCK TABLES `ruleactionexpression` WRITE;
/*!40000 ALTER TABLE `ruleactionexpression` DISABLE KEYS */;
INSERT INTO `ruleactionexpression` VALUES (5,'check scope',1,'${map.getResolvedAction.body.scope != \'CREATE_INSTANCE\' && map.getResolvedAction.body.scope != \'ENVIRONMENT\'}', 7),
(11,'check output map is null','','${!empty map.outputs && !empty map.getInstanceId.body.instanceId}',16),
(12,'check instanceId exists and launch status is success','','${!empty map.getInstanceId.body.instanceId &&  (map.status == \'succeeded\'  || map.status == \'Succeeded\' || map.status == \'SUCCEEDED\') && (map.getActionScope.body == \'CREATE_INSTANCE\' || map.getActionScope.body == \'INSTANCE\' || map.getActionScope.body == \'UPGRADE_INSTANCE\')}',21),
(13,'check instanceId exists and launch status is failed','','${!empty map.getInstanceId.body.instanceId &&  (map.status == \'failed\'  || map.status == \'Failed\' || map.status == \'FAILED\') && (map.getActionScope.body == \'CREATE_INSTANCE\' || map.getActionScope.body == \'INSTANCE\' || map.getActionScope.body == \'UPGRADE_INSTANCE\')}',22),
(14,'check instanceId exists and launch status is success','','${!empty map.getInstanceId.body.instanceId &&  (map.status == \'succeeded\'  || map.status == \'Succeeded\' || map.status == \'SUCCEEDED\') && map.getActionScope.body == \'RETIRE_INSTANCE\' }',23),
(16,'check scope',1,'${map.getResolvedAction.body.scope != \'ENVIRONMENT\'}', 13),
(17,'check scope',1,'${map.getResolvedAction.body.scope != \'ENVIRONMENT\'}', 14),
(18,'check instanceId is null',1,'${empty map.getInstanceId.body.instanceId}', 25),
(19,'check instanceId is not null',1,'${!empty map.getInstanceId.body.instanceId}',17),
(20,'check instanceId is not null',1,'${!empty map.getInstanceId.body.instanceId}',18),
(21,'Upgrade-Instance scope exists and launch status is success',1,'${!empty map.getInstanceId.body.instanceId &&  (map.status == \'succeeded\'  || map.status == \'Succeeded\' || map.status == \'SUCCEEDED\') && (map.getActionScope.body == \'UPGRADE_INSTANCE\') }',30),
(22,'Upgrade-Instance scope exists and launch status is success',1,'${!empty map.getInstanceId.body.instanceId &&  (map.status == \'succeeded\'  || map.status == \'Succeeded\' || map.status == \'SUCCEEDED\') && (map.getActionScope.body == \'UPGRADE_INSTANCE\') }',31),
(23,'Upgrade-Instance scope exists and launch status is success',1,'${!empty map.getInstanceId.body.instanceId &&  (map.status == \'succeeded\'  || map.status == \'Succeeded\' || map.status == \'SUCCEEDED\') && (map.getActionScope.body == \'UPGRADE_INSTANCE\') }',32);
/*!40000 ALTER TABLE `ruleactionexpression` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-16 16:24:10
