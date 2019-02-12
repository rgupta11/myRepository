Teradata JDBC Driver 16.20.00.10

Part of the Teradata Tools and Utilities 16.20 product suite


Get the Latest Software
-----------------------

We are always adding new features to the Teradata JDBC Driver, and
fixing issues that might affect your application.

If you obtained this release of the Teradata JDBC Driver from
physical media, please check whether a newer version is available at
http://downloads.teradata.com/download/connectivity/jdbc-driver


System Requirements
-------------------

This release of the Teradata JDBC Driver requires JDK/JRE 1.4.2, 5, 6, 7, 8, 9, 10, or 11.

This release of the Teradata JDBC Driver supports Teradata Database
14.10, 15.00, 15.10, 16.10, and 16.20.


Release Notes
-------------

This section highlights issues that you should be aware of when upgrading to this release
of the Teradata JDBC Driver. Please refer to the Teradata JDBC Driver Reference for more
information about the driver.

This release includes changes to address the following issues, originally included
in release 16.20.00.10:

JDBC-189912 Restrict XML External Entity References in SQLXML values

This release includes changes to address the following issues, originally included
in release 16.20.00.09:

JDBC-190725 JDBC failing with error 8028 - The LAN message Authentication is invalid when using ENCRYPTDATA=ON option

This release includes changes to address the following issues, originally included
in release 16.20.00.08:

JDBC-189906 Translate new JDBC 16.20 error messages into Japanese

This release includes changes to address the following issues, originally included
in release 16.20.00.07:

JDBC-184471 Support for AES-GCM Quality of Protection
JDBC-187068 TeraGSSJava Support for JWT Authentication Mechanism
JDBC-187839 JWT authentication
JDBC-188758 TeraGSSJava unable to logon with new QOPs with SHA256 and SHA512
JDBC-189125 TeraGSSJava unable to logon with AES GCM using IBM JRE

This release includes changes to address the following issues, originally included
in release 16.20.00.06:

JDBC-186581 Support the SET TRANSFORM GROUP command

This release includes changes to address the following issues, originally included
in release 16.20.00.05:

JDBC-187572 Support Function Mapping
JDBC-188137 Use additional built-in functions for escape syntax

This release includes changes to address the following issues, originally included
in release 16.20.00.03:

JDBC-187399 54 second login delay using TD2

This release includes changes to address the following issues, originally included
in release 16.10.00.05:

JDBC-184179 Support Kerberos authentication on AIX, HP-UX, MacOS, and Solaris
JDBC-187763 Support JDK 9

This release includes changes to address the following issues, originally included
in release 16.10.00.04:

JDBC-184941 Support DATASET STORAGE FORMAT CSV data type

This release includes changes to address the following issues, originally included
in release 16.00.00.31:

JDBC-171880 JDBC FastLoad and JDBC FastLoad CSV connection parameters for error tables
JDBC-184577 improve error handling for null or invalid Struct SQLTypeName and incompatible number of Struct attributes

This release includes changes to address the following issues, originally included
in release 16.00.00.30:

JDBC-124424 Support Java Stored Procedure parameters that are UDTs, Periods, XML, ST_Geometry, and Array
JDBC-181323 Improve performance of Blob.getBytes and Clob.getSubString methods
JDBC-186070 JDBC MonitorPreparedStatement.execute needs to close the current open response spool

This release includes changes to address the following issues, originally included
in release 16.00.00.26:

JDBC-114050 validate URL connection parameters and throw exception for invalid parameter names and/or argument values
JDBC-118928 provide complete connection URL from DatabaseMetaData.getURL
JDBC-177754 Connection parameter COPLAST=ON to enable DNS lookup of coplast IP address
JDBC-183490 Connection parameter MAYBENULL for ResultSetMetaData.isNullable variant behavior
JDBC-185106 Connection parameter COLUMN_NAME to control ResultSetMetaData getColumnName and getColumnLabel

This release includes changes to address the following issues, originally included
in release 16.00.00.25:

JDBC-174213 Support Teradata Database multiple hash maps

This release includes changes to address the following issues, originally included
in release 16.00.00.24:

JDBC-154936 Support Stored Password Protection
JDBC-184352 Translate new JDBC 16.0 error messages into Japanese

This release includes changes to address the following issues, originally included
in release 15.10.00.37:

JDBC-188567 Conditional QVCI usage per flag provided by DBS DR 188341

This release includes changes to address the following issues, originally included
in release 15.10.00.36:

JDBC-187689 TeraGSSJava support for MessageDigest algorithms SHA-256 and SHA-512
JDBC-187798 Avoid DBS DR 187498 QVCI fails to push down LIKE predicates

This release includes changes to address the following issues, originally included
in release 15.10.00.34:

JDBC-185088 completes work of adding row number to JDBC FastLoad USING clause to aid in identifying bad row

This release includes changes to address the following issues, originally included
in release 15.10.00.33:

JDBC-143102 DatabaseMetaData methods can use DBC.UDTInfoV view provided by DBS DR 142702
JDBC-170532 DatabaseMetaData methods can use DBC.UDTTransformV view provided by DBS RFC 170531

This release includes changes to address the following issues, originally included
in release 15.10.00.32:

JDBC-156332 JDBC 4.0 API behavior for ParameterMetaData.getPrecision and ResultSetMetaData.getPrecision

This release includes changes to address the following issues, originally included
in release 15.10.00.29:

JDBC-165187 Support TeraGSSJava DR 165186 for integrated logging
JDBC-180947 Improve code of TDNEGO java and other modules
JDBC-181373 Incorrect logging information in tdnegojava
JDBC-181448 The global logging level of teragssjava doesn't work
JDBC-181712 tdnego throws null pointer exception if server is not in kerberos database
JDBC-182119 TeraGSSJava TDNEGO fails to establish context when LDAP is given higher priority than Kerberos in tdgss server
JDBC-182628 tdgssjava throws an exception during a JDBC test when the tdgss debug logging is enabled
JDBC-182944 Modify the TdgssLogger Interface to use the JDBC logging levels for a connection

This release includes changes to address the following issues, originally included
in release 15.10.00.28:

JDBC-163135 Implement JDBC 4.0 APIs DatabaseMetaData getFunctions, getFunctionColumns, getSchemas(String,String)

This release includes changes to address the following issues, originally included
in release 15.10.00.27:

JDBC-168339 Support additional connection parameters for Java Stored Procedure jdbc:default:connection

This release includes changes to address the following issues, originally included
in release 15.10.00.25:

JDBC-115666 Support 1MB result set rows
JDBC-177261 Support 16MB messages
JDBC-177265 SQL connection support for 1MB permanent table rows
JDBC-177267 JDBC FastLoad support for 1MB permanent table rows

This release includes changes to address the following issues, originally included
in release 15.10.00.24:

JDBC-177470 add row number to JDBC FastLoad USING clause to aid in identifying bad row
JDBC-180342 Add access rights descriptions

This release includes changes to address the following issues, originally included
in release 15.10.00.23:

JDBC-176193 Support DATASET data type

This release includes changes to address the following issues, originally included
in release 15.10.00.22:

JDBC-181231 Provide incremental fetch for Monitor connection result sets
JDBC-181560 Support account string with LDAP and KRB5 logon mechanisms

This release includes changes to address the following issues, originally included
in release 15.10.00.21:

JDBC-182658 Improve performance of ResultSet cursor movement methods

This release includes changes to address the following issues, originally included
in release 15.10.00.20:

JDBC-154823 DatabaseMetaData methods query column information for views as an alternative to HELP commands

This release includes changes to address the following issues, originally included
in release 15.10.00.19:

JDBC-182168 Avoid reverse DNS lookup when IP address specified for Teradata Database

This release includes changes to address the following issues, originally included
in release 15.10.00.17:

JDBC-181611 getMoreResults advance to second and subsequent ResultSetMetaData from prepare before execute

This release includes changes to address the following issues, originally included
in release 15.10.00.16:

JDBC-154836 Use logon mechanism specified by centralized administration
JDBC-161033 TeraGSSJava Single Mechanism to Log-On
JDBC-165186 Provide logger interface, change all logging to use the logger interface, eliminate all direct ex.printStackTrace
JDBC-165378 All GSSExceptions should use the initCause option if they are the result of an exception
JDBC-168648 A non-zero offset for wrap greater than 16 throws an ArrayIndexOutOfBoundsException
JDBC-175759 TeraGSSJava error handling cleanup
JDBC-176636 TeraGSSJava Eliminate a token exchange in the LDAP method

This release includes changes to address the following issues, originally included
in release 15.10.00.14:

JDBC-179996 Connection parameter LITERAL_UNDERSCORE=ON/OFF for DatabaseMetaData pattern arguments

This release includes changes to address the following issues, originally included
in release 15.10.00.12:

JDBC-177757 Skip when possible non-COP hostname lookup before COP Discovery

This release includes changes to address the following issues, originally included
in release 15.10.00.11:

JDBC-179413 DatabaseMetaData getImportedKeys/getExportedKeys provide PK_NAME if available

This release includes changes to address the following issues, originally included
in release 15.00.00.34:

JDBC-180574 NullPointerException from execute method with scrollable result set enabled for create/drop/replace object

This release includes changes to address the following issues, originally included
in release 15.00.00.33:

JDBC-121720 Local escape function teradata_provide
JDBC-179976 Dynamic RS has -1 activity count (a.k.a. 18446744073709551615) when Java SP fetches past last row

This release includes changes to address the following issues, originally included
in release 15.00.00.32:

JDBC-179083 Coverity found null pointer dereferences & resource leaks in JDBC Driver

This release includes changes to address the following issues, originally included
in release 15.00.00.30:

JDBC-178714 Escape functions {fn teradata_call_param_rs} and {fn teradata_auto_out_param}

This release includes changes to address the following issues, originally included
in release 15.00.00.29:

JDBC-174886 Support Unicode Pass Through

This release includes changes to address the following issues, originally included
in release 15.00.00.28:

JDBC-148961 Support backslash ( \ ) as LIKE ESCAPE character in pattern arguments of DatabaseMetaData methods
JDBC-161165 Use equals (=) rather than LIKE for DatabaseMetaData method pattern arguments not containing a pattern

This release includes changes to address the following issues, originally included
in release 15.00.00.27:

JDBC-167410 Provide ResultSet SQLWarning when row count exceeds Integer.MAX_VALUE
JDBC-176246 Translate new JDBC 15.10 error messages into Japanese

This release includes changes to address the following issues, originally included
in release 15.00.00.26:

JDBC-163202 Improve LOB performance
JDBC-174526 Improve ClientProgramName identification

This release includes changes to address the following issues, originally included
in release 15.00.00.25:

JDBC-159947 Support Primary AMP Index
JDBC-173903 Support pass-thru tokens in SQL request text

This release includes changes to address the following issues, originally included
in release 15.00.00.23:

JDBC-128828 provide Monitor partition connection support for Statement.cancel and Statement.setQueryTimeout
JDBC-170226 Enhance Connection.getClientInfo to return profile query band values

This release includes changes to address the following issues, originally included
in release 15.00.00.22:

JDBC-163170 JDBC 4.0 API changes for DatabaseMetaData getNumericFunctions getStringFunctions getTimeDateFunctions
JDBC-170566 Use TD 15.10 string function RIGHT for escape syntax
JDBC-170631 Support the INITIATE CHECK command

This release includes changes to address the following issues, originally included
in release 14.10.00.44:

JDBC-181141 JDBC Reconnect can fail when Encryption enabled and Redrive is on

This release includes changes to address the following issues, originally included
in release 14.10.00.43:

JDBC-180154 Accommodate relocation of JSON support flag in Config Response parcel
JDBC-180517 Validate the 64KB maximum size for each insert parameter set with JDBC FastLoad

This release includes changes to address the following issues, originally included
in release 14.10.00.40:

JDBC-173521 Avoid sending unneeded Continue Request messages with Cancel parcel

This release includes changes to address the following issues, originally included
in release 14.10.00.37:

JDBC-163490 Translate new JDBC 15.0 error messages into Japanese
JDBC-164061 Support the Connection.isValid method
JDBC-168727 Support SQL current database for JDBC FastExport SELECT statements
JDBC-170713 Improve DatabaseMetaData.getUDTs to return Class Name and Data Type for Array Types

This release includes changes to address the following issues, originally included
in release 14.10.00.36:

JDBC-168132 avoid JDK call to System.err.println in case of XML transform error
JDBC-170225 Coverity found null pointer dereferences in JDBC Driver

This release includes changes to address the following issues, originally included
in release 14.10.00.35:

JDBC-171241 Increase the JDBC FastLoad maximum transmitted message size to 1MB

This release includes changes to address the following issues, originally included
in release 14.10.00.34:

JDBC-148040 Centralized administration for data encryption

This release includes changes to address the following issues, originally included
in release 14.10.00.33:

JDBC-155892 Support for detection of replayed or out-of-order messages

This release includes changes to address the following issues, originally included
in release 14.10.00.32:

JDBC-144067 Remove all references to the Cryptix source version of the AES algorithm
JDBC-155353 Complete AES-256 implementation started in 14.0
JDBC-163542 In wrap or unwrap throw GSSException if MsgProp is NULL
JDBC-165341 TeraGSS Java on Linux + Oracle/Sun Java blocks on /dev/random increasing logon time
JDBC-165369 TERAGSSJAVA: LDAP mechanism is not working

This release includes changes to address the following issues, originally included
in release 14.10.00.27:

JDBC-162376 Support JSON data type

This release includes changes to address the following issues, originally included
in release 14.10.00.26:

JDBC-110776 support INTERVAL data types for implicit data type conversions, and for use with the EXTRACT function
JDBC-144698 Support TIME WITH TIME ZONE and TIMESTAMP WITH TIME ZONE Struct bind values
JDBC-162127 Clarify exception for DBS request of same LOB token more than once

This release includes changes to address the following issues, originally included
in release 14.10.00.25:

JDBC-168961 Improve Monitor connection PreparedStatement interoperability with JDK 7

This release includes changes to address the following issues, originally included
in release 14.10.00.23:

JDBC-154833 Recoverable Network Support
JDBC-154881 Support Redrive protocol to automatically redrive SQL request after communication failure
JDBC-165410 setObject(col, new BigDecimal("1.5e-39"), Types.DECIMAL) generates StringIndexOutOfBoundsException

This release includes changes to address the following issues, originally included
in release 14.10.00.21:

JDBC-165252 Improve JDBC FastLoad support for UTF8 session character set

This release includes changes to address the following issues, originally included
in release 14.10.00.19:

JDBC-160024 Support PERIOD data type for JDBC FastExport
JDBC-160027 Support PERIOD data type for JDBC FastLoad and JDBC FastLoad CSV
JDBC-162940 JDBC PERIOD attributes have the same column type name as the PERIOD, which causes getAttributes (Map) to fail

This release includes changes to address the following issues, originally included
in release 14.10.00.18:

JDBC-144415 STRICT_ENCODE connection parameter

This release includes changes to address the following issues, originally included
in release 14.00.00.44:

JDBC-181582 Limit send and receive message size

This release includes changes to address the following issues, originally included
in release 14.00.00.43:

JDBC-180518 Dynamic limit for ciphertext expansion sanity check

This release includes changes to address the following issues, originally included
in release 14.00.00.42:

JDBC-173198 remove obsolete JDBC FastLoad support for V2R6.1 and earlier

This release includes changes to address the following issues, originally included
in release 14.00.00.41:

JDBC-167776 CLOB INOUT parameter assigned new value in procedure body is truncated to 4 bytes when input was NULL
JDBC-172432 Error 1178 thrown for query returning result set of Array columns mixed with other type columns

This release includes changes to address the following issues, originally included
in release 14.00.00.40:

JDBC-169289 Reconnect count not limited by RECONNECT_COUNT connection parameter after JDBC DR 159065 change

This release includes changes to address the following issues, originally included
in release 14.00.00.39:

JDBC-167176 Avoid NullPointerException at logon when System property "java.vm.info" is not set

This release includes changes to address the following issues, originally included
in release 14.00.00.38:

JDBC-161300 Slow JDBC logons inside TdgssContext.initSecContext 14.00
JDBC-165159 Change TdgssConfigApi access to accommodate TeraGSSJava DR 161300

This release includes changes to address the following issues, originally included
in release 14.00.00.37:

JDBC-164718 EON support for DatabaseMetaData getMax...NameLength methods

This release includes changes to address the following issues, originally included
in release 14.00.00.35:

JDBC-163466 Translate new JDBC 14.10 error messages into Japanese
JDBC-163807 Updatable ResultSet exception "No value has been set for parameter" with unique column

This release includes changes to address the following issues, originally included
in release 14.00.00.33:

JDBC-153317 Provide ClientAttributes COPSuffixHostName and Client/Server IPAddresses/Ports
JDBC-162211 Implement Connection.getClientInfo to return query band values
JDBC-163421 Improve logging of LCC activity
JDBC-163501 Support PreparedStatement setAsciiStream setBinaryStream setCharacterStream with long length

This release includes changes to address the following issues, originally included
in release 14.00.00.31:

JDBC-160663 Support JDBC FastLoad CSV as an application server data source
JDBC-160795 Support new JDBC 4.0 PreparedStatement.setAsciiStream methods for JDBC FastLoad CSV
JDBC-161123 Bypass JDBC FastExport for unsupported ResultSet scrollability, concurrency, or holdability

This release includes changes to address the following issues, originally included
in release 14.00.00.30:

JDBC-162982 Support LDAP password containing space character
JDBC-163164 Correct DatabaseMetaData getNumericFunctions getStringFunctions getSystemFunctions getTimeDateFunctions

This release includes changes to address the following issues, originally included
in release 14.00.00.29:

JDBC-160209 Support the SHOW IN XML command

This release includes changes to address the following issues, originally included
in release 14.00.00.28:

JDBC-99266 implement ResultSet holdability CLOSE_CURSORS_AT_COMMIT

This release includes changes to address the following issues, originally included
in release 14.00.00.27:

JDBC-162129 Support JDK 7

This release includes changes to address the following issues, originally included
in release 14.00.00.26:

JDBC-156715 Support UTF8 session character set with Console partition
JDBC-159277 Provide DBS RFC 159237 DBC.IndicesV[X].IndexDatabaseName as getIndexInfo INDEX_QUALIFIER

This release includes changes to address the following issues, originally included
in release 14.00.00.25:

JDBC-68722 Accommodate 64-bit Activity Count

This release includes changes to address the following issues, originally included
in release 14.00.00.24:

JDBC-100184 DatabaseMetaData.getIndexInfo should support arguments containing double quotes

This release includes changes to address the following issues, originally included
in release 14.00.00.23:

JDBC-160380 Support new JDBC 4.0 API methods for non-SQL connections

This release includes changes to address the following issues, originally included
in release 14.00.00.22:

JDBC-127422 support sending fixed-width BYTE data values to the database
JDBC-160029 Provide PreparedStatement setObject method with scaleOrLength argument for Raw connections

This release includes changes to address the following issues, originally included
in release 14.00.00.18:

JDBC-134645 Add support for the JDBC 4.0 SQLXML data type

This release includes changes to address the following issues, originally included
in release 14.00.00.17:

JDBC-153117 JDBC FastLoad/FastExport GOVERN=OFF to use TASM fail-fast no-wait for Check Workload End

This release includes changes to address the following issues, originally included
in release 14.00.00.16:

JDBC-159065 Support reconnect after database restart for MPP systems

This release includes changes to address the following issues, originally included
in release 14.00.00.15:

JDBC-55968 Implement java.sql.Driver.getPropertyInfo

This release includes changes to address the following issues, originally included
in release 14.00.00.14:

JDBC-157883 Increased Diffie-Hellman keysize to 2048bits used excessive CPU resulting in increased logon times

This release includes changes to address the following issues, originally included
in release 14.00.00.13:

JDBC-157308 URL parameters USER/PASSWORD used when DriverManager.getConnection user/password arguments omitted or null

This release includes changes to address the following issues, originally included
in release 14.00.00.12:

JDBC-156903 Support the "gtwcontrol -u yes" option for Send Connect Response with Integrity Only

This release includes changes to address the following issues, originally included
in release 14.00.00.11:

JDBC-156851 Connection parameter LOGMECH=NONE enables DatabaseMetaData version retrieval without logon

This release includes changes to address the following issues, originally included
in release 14.00.00.10:

JDBC-109167 Statement.execute to provide update count for MERGE statement
JDBC-155909 Stricter syntax check to determine whether Insert statement qualifies for JDBC FastLoad
JDBC-156706 Translate new JDBC 14.0 error messages into Japanese

This release includes changes to address the following issues, originally included
in release 14.00.00.09:

JDBC-143362 Support the SQL NUMBER data type as the JDBC NUMERIC data type

This release includes changes to address the following issues, originally included
in release 14.00.00.08:

JDBC-156036 Add connection parameter FINALIZE_AUTO_CLOSE=ON/OFF (default OFF) to control finalize method auto-closing JDBC objects

This release includes changes to address the following issues, originally included
in release 14.00.00.05:

JDBC-147216 Modify TDGSS Configuration Files to support more encryption types
JDBC-147218 Stronger Encryption for the Teradata Security Mechanisms
JDBC-150335 Need a better exception message when unsupported AES keysize encountered
JDBC-150599 Build error in TdgssConfigFile.xsd: element LdapConfig not found in the Schema
JDBC-152773 Do not allow legacy logons for TD2 and LDAP when AES-128 bit logons are not allowed

This release includes changes to address the following issues, originally included
in release 14.00.00.04:

JDBC-138098 support the SQL ARRAY data type and the java.sql.Array data type

This release includes changes to address the following issues, originally included
in release 13.10.00.37:

JDBC-172943 Support insert without return of Structured UDT values using getGeneratedKeys with column list
JDBC-178409 Log the Teradata JDBC Driver version number

This release includes changes to address the following issues, originally included
in release 13.10.00.31:

JDBC-155128 Case-insensitive session character set names for CHARSET connection parameter
JDBC-155129 Throw SQLException from commit and get/setAutoCommit for closed connection

This release includes changes to address the following issues, originally included
in release 13.10.00.30:

JDBC-154743 Incorrect SQLSTATE for some Exceptions returned from PreparedStatement.executeBatch
JDBC-155013 Accommodate PCLUSERNAMERESP parcel for Java Stored Procedure default connection

This release includes changes to address the following issues, originally included
in release 13.10.00.29:

JDBC-148644 support Monitor partition 1MB response message

This release includes changes to address the following issues, originally included
in release 13.10.00.28:

JDBC-135100 Teradata dialect for Hibernate

This release includes changes to address the following issues, originally included
in release 13.10.00.27:

JDBC-153226 Updatable ResultSet Error 1244 Column index value 0 is outside the valid range

This release includes changes to address the following issues, originally included
in release 13.10.00.26:

JDBC-137214 Translate new JDBC 13.10 error messages into Japanese

This release includes changes to address the following issues, originally included
in release 13.10.00.25:

JDBC-96348 implement setFetchSize and setMaxRows to use FetchRowCount parcel

This release includes changes to address the following issues, originally included
in release 13.10.00.24:

JDBC-107800 JDBC reconnect after database communication failure

This release includes changes to address the following issues, originally included
in release 13.10.00.23:

JDBC-152249 Support result set returned from the Create/Alter Replication Group commands

This release includes changes to address the following issues, originally included
in release 13.10.00.22:

JDBC-141717 Reduce synchronization on Connection and Statement objects

This release includes changes to address the following issues, originally included
in release 13.10.00.21:

JDBC-129622 Support Mandatory Access Control
JDBC-146934 provide ClientInterfaceKind, ClientInterfaceVersion, and ClientAttributesEx

This release includes changes to address the following issues, originally included
in release 13.10.00.19:

JDBC-109963 Monitor connection support for UTF8 and UTF16 session character sets
JDBC-149284 support TD_ANYTYPE

This release includes changes to address the following issues, originally included
in release 13.10.00.18:

JDBC-148441 unify parameter marker implementation classes
JDBC-149859 Return empty result set from DatabaseMetaData getClientInfoProperties for older databases

This release includes changes to address the following issues, originally included
in release 13.10.00.16:

JDBC-148993 Avoid error 3749 "Options Parcel information is invalid" with TD13.10 DisableSipSupport=TRUE

This release includes changes to address the following issues, originally included
in release 13.10.00.15:

JDBC-145765 tdgssjava TD2 unwrap fails for integrity-only with Defective Token error
JDBC-146421 Multi-threaded concurrent logon attempts can throw GSSException: Error during MIC calculation
JDBC-148119 JDBC failing intermittently with "The LAN message Authentication is invalid"

This release includes changes to address the following issues, originally included
in release 13.10.00.12:

JDBC-122378 support the ClientAttributes feature as an improvement for LogonSource
JDBC-138855 JDBC 4.0 API DatabaseMetaData getClientInfoProperties
JDBC-148350 ignore the HUTConfig returned from FastLoad BEGIN LOADING statement

This release includes changes to address the following issues, originally included
in release 13.10.00.11:

JDBC-107402 JDBC 4.0 API Specification support

This release includes changes to address the following issues, originally included
in release 13.10.00.09:

JDBC-147980 support multiple Record parcels for Console partition response messages

This release includes changes to address the following issues, originally included
in release 13.10.00.08:

JDBC-147087 PreparedStatement executeQuery after getMoreResults throws SQLException with error code 1077

This release includes changes to address the following issues, originally included
in release 13.10.00.07:

JDBC-115641 enable application custom type mapping for Distinct, Structured, and Internal UDT values
JDBC-147134 ResultSet getBinaryStream to return null for NULL column value

This release includes changes to address the following issues, originally included
in release 13.10.00.06:

JDBC-146852 PreparedStatement.setObject(n,BigDecimal,DECIMAL,scale) scale argument specifies minimum scale

This release includes changes to address the following issues, originally included
in release 13.10.00.05:

JDBC-146722 Improve DBS statement cache hit ratio for PreparedStatement VARCHAR bind values

This release includes changes to address the following issues, originally included
in release 13.10.00.04:

JDBC-94091 Remove "CREATE PROCEDURE FROM EXTERNAL NAME" feature from driver
JDBC-136075 Avoid sending extra ET commands which cause 3510 errors in DBQLOGTBL
JDBC-145227 support session character set UTF8 for JDBC FastLoad CSV

This release includes changes to address the following issues, originally included
in release 13.10.00.03:

JDBC-139067 DatabaseMetaData getSQLKeywords method to query SYSLIB.SQLRestrictedWords
JDBC-140609 Additional support for DISTINCT user-defined types

This release includes changes to address the following issues, originally included
in release 13.00.00.33:

JDBC-166995 JDBC scalar function LOG returns incorrect results
JDBC-167160 JDBC Fastload error with ENCRYPTDATA=ON

This release includes changes to address the following issues, originally included
in release 13.00.00.32:

JDBC-164292 Provide correct SQLException error codes to distinguish logon vs non-logon communication failure

This release includes changes to address the following issues, originally included
in release 13.00.00.31:

JDBC-155666 Accommodate more rows from the Teradata Database than the Activity Count indicates

This release includes changes to address the following issues, originally included
in release 13.00.00.30:

JDBC-163433 ResultSet.close and Statement.close may not always close response spools spanning multiple messages
JDBC-163530 Support JDBC 4.0 API Service Provider mechanism for automatic class loading

This release includes changes to address the following issues, originally included
in release 13.00.00.29:

JDBC-155367 Intermittent socket communication failures when using setQueryTimeout with large result sets
JDBC-160371 Intermittent "Read timeout after abort was sent" on Linux

This release includes changes to address the following issues, originally included
in release 13.00.00.26:

JDBC-143576 add connection parameter TYPE=FASTLOADCSV
JDBC-145146 add JDBC FastLoad CSV connection parameter FIELD_SEP

This release includes changes to address the following issues, originally included
in release 13.00.00.25:

JDBC-143408 DatabaseMetaData methods use Data Dictionary V-views for TD 12.0 and later

This release includes changes to address the following issues, originally included
in release 13.00.00.24:

JDBC-106710 enhance getProcedures and getProcedureColumns to report on external stored procedures also
JDBC-133599 DatabaseMetaData getTables support for table type GLOBAL TEMPORARY
JDBC-143844 The JDBC Driver throws a NullPointerException if executeBatch is called when the batch is empty

This release includes changes to address the following issues, originally included
in release 13.00.00.23:

JDBC-137079 JDBC 4.0 API support ResultSet getAsciiStream and getCharacterStream for CLOB column
JDBC-141432 Restore missing code/methods for SIP/LOB/PREP support

This release includes changes to address the following issues, originally included
in release 13.00.00.22:

JDBC-142328 Changes for DatabaseMetaData getColumns

This release includes changes to address the following issues, originally included
in release 13.00.00.21:

JDBC-138607 Improve Java Tdgss initialization performance

This release includes changes to address the following issues, originally included
in release 13.00.00.20:

JDBC-139320 add support for session charsets KANJISJIS_0S and KANJIEUC_0U in JDBC FastLoad
JDBC-139380 add support for additional session charsets in JDBC FastExport
JDBC-140148 add PERIOD type name to SQLWarning message when attempting JDBC FastLoad into table with PERIOD data type
JDBC-140534 NullPointerException from PreparedStatement setNull Types.STRUCT when using V2R6.1

This release includes changes to address the following issues, originally included
in release 13.00.00.19:

JDBC-101075 Include TTU client version in Client Config parcel built by JDBC
JDBC-138870 Some invalid JDBC methods throw NullPointerException

This release includes changes to address the following issues, originally included
in release 13.00.00.18:

JDBC-115639 input and output java.sql.Struct values for Structured and Internal UDT values
JDBC-117048 JDBC support for Period Data Types as java.sql.Struct
JDBC-139824 DatabaseMetaData getColumns should ignore Error 3523 The user does not have any access to dbname.tabname

This release includes changes to address the following issues, originally included
in release 13.00.00.17:

JDBC-139774 Reduce finalizer locking for already-closed ResultSets

This release includes changes to address the following issues, originally included
in release 13.00.00.16:

JDBC-124457 enable PreparedStatement batch execution to return individual success and error conditions for each parameter set

This release includes changes to address the following issues, originally included
in release 13.00.00.15:

JDBC-123191 support TD 13.10 TASM workload management

This release includes changes to address the following issues, originally included
in release 13.00.00.14:

JDBC-136315 Coverity found null pointer dereferences in JDBC Driver

This release includes changes to address the following issues, originally included
in release 13.00.00.13:

JDBC-127101 support Extended Object Names in parcels

This release includes changes to address the following issues, originally included
in release 13.00.00.12:

JDBC-134440 JDBC Error 858 is returned when single & double quotes are combined in the same query & a '?' is located in the quotes

This release includes changes to address the following issues, originally included
in release 13.00.00.11:

JDBC-135882 OutOfMemoryError for getMoreResults with multi-statement request returning large result set
JDBC-136276 ResultSetMetaData getPrecision for DATE column (regression caused by DR 106221)
JDBC-136380 getDate on CHAR/VARCHAR column containing integer date values throws SQLException with error 1332

This release includes changes to address the following issues, originally included
in release 13.00.00.09:

JDBC-104643 CallableStatement.getObject needs to return Time or Timestamp objects for TIME or TIMESTAMP data types
JDBC-106221 ResultSet and CallableStatement getDate with Calendar parameter to use Calendar's TimeZone to construct Date
JDBC-106222 ResultSet and CallableStatement getTime/getTimestamp with Calendar parameter to set or use Calendar's TimeZone
JDBC-134413 PreparedStatement/CallableStatement setDate with Calendar parameter to use Calendar's TimeZone to send DATE value
JDBC-134573 Enable ResultSet and CallableStatement getTimestamp to return complete TIME value fractional seconds
JDBC-135093 DatabaseMetaData getColumnPrivileges support for leading spaces in database object names

This release includes changes to address the following issues, originally included
in release 13.00.00.08:

JDBC-122317 support FastExport direct export without spooling
JDBC-122340 provide TRUSTED_SQL connection parameter and {fn teradata_untrusted} escape function
JDBC-129206 SQL keyword changes and SQLState mappings for TD 13.10

This release includes changes to address the following issues, originally included
in release 13.00.00.07:

JDBC-120610 Clean up Coverity defects found in 13g TDGSS JAVA LIBRARIES
JDBC-123280 GSSException from initSecContext needs to provide the exception cause for troubleshooting
JDBC-123711 change remaining sample programs to use CHARSET=UTF8 after DBS DR 118299 is available
JDBC-124683 TDGSSJAVA Kerberos fails when Data Encryption specified and server is MPRAS
JDBC-125601 TdgssLibraryConfigFile.xml and TdgssUserConfigFile.xml incorrectly specified DH G key in litle endian
JDBC-132356 TDGSS Java LDAP Mechanism does not handle Non "US-ASCII" characters in logdata
JDBC-132545 JDBC does not send correct charset in Unicode LDAP logons
JDBC-133045 If a password includes certain escape chars, the UPN created should have those chars escaped
JDBC-133291 Modify JDBC sample program for Transaction Isolation levels
JDBC-133304 Support PreparedStatement setNull with PreparedStatement setClob or setBlob in a batch insert request
JDBC-133717 Change log level for socket read timeout exceptions from ERROR to INFO

This release includes changes to address the following issues, originally included
in release 13.00.00.06:

JDBC-132370 DatabaseMetaData getColumns support for Period and Geospatial data types

This release includes changes to address the following issues, originally included
in release 13.00.00.05:

JDBC-132251 improve Thread reference usage for pooled Statement objects

This release includes changes to address the following issues, originally included
in release 13.00.00.04:

JDBC-98096 In ANSI mode w/auto commit on, an unnecessary commit is sent after a prepare
JDBC-99487 enable use of PreparedStatement batch update when LOB_SUPPORT=off

This release includes changes to address the following issues, originally included
in release 13.00.00.03:

JDBC-131214 Provide incremental fetch for Console connection result sets

This release includes changes to address the following issues, originally included
in release 13.00.00.02:

JDBC-122326 provide a Raw connection type
JDBC-129026 use INDIC mode for JDBC FastExport
JDBC-130385 JDBC Driver support for STARTUP string specified by CREATE/MODIFY USER
JDBC-130413 Connection.getTransactionIsolation may be incorrect after SET SESSION CHARACTERISTICS command

This release includes changes to address the following issues, originally included
in release 13.00.00.01:

JDBC-92605 ResultSet getter methods should throw exception for invalid RS cursor position
JDBC-95122 remove remaining code for obsolete feature: DR63489 connection parameter
JDBC-95817 remove undocumented connection pool implementation
JDBC-96825 remove obsolete CASE_SENSITIVE connection parameter and DataSource property
JDBC-97757 remove undocumented and obsolete connection parameters
JDBC-99263 add ConnectionPoolDataSource getters and setters defined by JDBC 3.0 spec 
JDBC-101602 Exception thrown when a stored procedure called w/ literal IN value & ? OUT vals
JDBC-102420 return true from DatabaseMetaData.supportsStatementPooling
JDBC-102470 IndexOutOfBoundsException when a connection string parameter option is missing
JDBC-103542 Prep stmt batch: setObject/Types.TINYINT and setByte or setObject for same parameter throws exception w/error 857
JDBC-106528 ResultSet methods isBeforeFirst and isLast return incorrect values for empty result set
JDBC-108938 Change DatabaseMetaData.getColumns to use the current USEXVIEWS setting
JDBC-109268 exception with V2R6.0 and earlier when trying to CALL an SP with an OUT parameter with leading spaces in its name
JDBC-110190 PreparedStatement.execute throws exception for Execute Macro with '?' in macro name
JDBC-110895 JDBC returns IndexOutOfBoundsException when getObject(index) and other get methods are called with an invalid index
JDBC-113199 ArrayIndexOutOfBoundException from a reused CallableStatement.setNull with OUT parameter
JDBC-113547 DBS Error 3130 "Response limit exceeded" while executing Statement.executeBatch() method
JDBC-113577 scrollable ResultSet not returned as requested from Statement.executeQuery after Statement.executeBatch
JDBC-113847 SQLException w/error 3760 when attempting to call SP with a space in its name on V2R6.0 and earlier 
JDBC-114195 {fn TIMESTAMPADD(SQL_TSI_MONTH,count,ts)} returns error when input day-of-month exceeds target month's number of days
JDBC-115508 NullPointerException from executeXXX methods when invalid charset specified for Java Stored Procedure default connection
JDBC-116004 JDBC Driver not following Java naming standards or interfaces causing rework
JDBC-116442 support DNS hostname aliases with Kerberos authentication
JDBC-120323 BatchUpdateException does not return correct update count while using SELECT statement in Statement.executeBatch
JDBC-121210 JDBC Driver support for NoPI tables
JDBC-124418 Throw SQLException chain for DBS error 7980 from CALL to SQLJ stored procedure
JDBC-125135 provide JDBC sample program to demonstrate use of Geospatial data
JDBC-126018 additional support for select-list parameter markers
JDBC-129058 DatabaseMetaData.getColumns support for object names with leading spaces in Data Dictionary
JDBC-129638 support KANJISJIS_0S, KANJIEUC_0U, LATIN1252_0A with MONITOR partition

This release includes changes to address the following issues, originally included
in release 12.00.00.111:

JDBC-92048 Add COP connection parameter and DataSource property
JDBC-113453 CONNECT_FAILURE_TTL connection parameter
JDBC-126776 connectivity changes
JDBC-131226 provide connection parameters for TCP socket options
JDBC-131929 Enable TCP connection parameter to control TCP send and receive buffer sizes

This release includes changes to address the following issues, originally included
in release 12.00.00.110:

JDBC-132603 Login timeout may wait too long

This release includes changes to address the following issues, originally included
in release 12.00.00.109:

JDBC-132157 support PreparedStatement batch update with no parameter markers

This release includes changes to address the following issues, originally included
in release 12.00.00.106:

JDBC-129949 Conditional connection is not terminated by JDBC driver if NEW_PASSWORD is invalid

This release includes changes to address the following issues, originally included
in release 12.00.00.105:

JDBC-105976 getColumns & getBestRowIdentifier return incorrect values for COLUMN_SIZE for char types on Japanese-enabled DBS
JDBC-125463 remove unneeded trailing semicolons in SQL request text in sample programs
JDBC-127065 DatabaseMetaData.getIndexInfo fails to return Unique Primary Index when using UTF8 session character set

This release includes changes to address the following issues, originally included
in release 12.00.00.104:

JDBC-69205 send DATE, TIME, and TIMESTAMP type codes to DBS for better implicit data type conversions
JDBC-97560 provide Teradata-specific escape syntax to set JDBC driver log level
JDBC-101194 driver should downgrade scrollable result set to forward-only if LOB_SUPPORT=off
JDBC-102357 PreparedStatement.addBatch exception: setTime/Timestamp & setNull TIME/TIMESTAMP
JDBC-107027 implement login timeout functionality - use value set by DriverManager.setLoginTimeout or DataSource.setLoginTimeout
JDBC-108348 support returning dynamic result sets from a Java stored procedure
JDBC-110511 Modify the Teradata JDBC driver to send StatementInfo parcels from the client in a request message
JDBC-111264 support FastExport
JDBC-112298 JDBC FastLoad data validation
JDBC-112564 Change ClearCase directory structure, and change all package statements to remove "ncr"
JDBC-112565 Change all copyright comments that contain 'NCR'
JDBC-112566 Change error message prefixes that contain '[NCR]'
JDBC-112569 Put the tdgssjava classes into the terajdbc4.jar file
JDBC-112572 Change the SQL connection Logon & Logoff to use the 'Generic' classes
JDBC-113344 add a reason for not invoking JDBC FastLoad to the PreparedStatement SQLWarning chain
JDBC-113678 provide SQLException chain and SQLWarning chain for create/replace XSP
JDBC-114956 support user impersonation with QueryBand
JDBC-114981 provide error code and SQLState at the beginning of all SQLException messages
JDBC-115170 avoid sending Continue/Cancel with RPO=S if Resp/BigResp was sent and EndRequest was received
JDBC-115627 Support Java User-Defined Functions (UDFs)
JDBC-115664 support Novell eDirectory for use with the LDAP mechanism
JDBC-115855 PreparedStatement and CallableStatement setObject should send fractional seconds of Time value to database
JDBC-116276 support TDGSS mechanism attribute GenerateCredentialFromLogon - move username@@password into mechdata
JDBC-116279 Translate new JDBC 13.0 error messages into Japanese
JDBC-116489 SQL keyword changes and SQLState mappings for TD 13.0
JDBC-116761 Support the consumption of dynamic result sets in an SQL stored procedure
JDBC-118803 KATAKANAEBCDIC session character set is not supported - omit from JDBC Driver User Guide
JDBC-120309 support data encryption and user authentication for high-level JDBC FastLoad and FastExport
JDBC-120378 support a literal IP address as a Teradata Database hostname
JDBC-120705 Test case prepareNull.java failed with the following exception message against TD 13d build (WS 03)
JDBC-121130 getParameterMetaData() fails with multi-statement macro and multi-statement requests
JDBC-121311 if DBS error occurs when inserting LOBs using PreparedStatement batch, driver violates protocol and DBS ends connection
JDBC-121952 avoid SQLException from Statement.close if connection is already closed
JDBC-122425 JDBC Driver sent Abort request message for completed request while subsequent ET request was in progress
JDBC-122427 NullPointerException thrown if LOB length is 0 and a read(data) is performed with data array having nonzero length
JDBC-123376 Modify JDBC DatabaseMetaData.getColumnPrivileges to handle new access rights added for DBS 13.0
JDBC-123428 WebSphere Application Server 6.1 DataSource Test Connection failed
JDBC-123694 Test cases PersistDataSource.java and PersistPoolDataSource.java unable to lookup datasource
JDBC-124800 NullPointerException when connecting to V2R5.0

This release includes changes to address the following issues, originally included
in release 12.00.00.01:

JDBC-118048 IndexOutOfBoundsException from ResultSet positioning methods for large scrollable result set with V2R6.2 and earlier
JDBC-118571 WebSphere DataSource custom property CHARSET not working for PreparedStatement.setString non-ASCII characters
JDBC-119329 TeraEncrypt: Error tdgss-stack-trace-begin>>> java.lang.ArrayIndexOutOfBoundsException (shipped with tdgssjava 12.0.1.2)

This release includes changes to address the following issues, originally included
in release 12.00.00.00:

JDBC-51544 Updateable result sets. 
JDBC-58075 Blob and Clob update methods added by the JDBC 3.0 specification. 
JDBC-92927 handle database password expiration. 
JDBC-92937 add connection parameter to choose X views or non-X views for metadata. 
JDBC-94241 provide getMoreResults (KEEP_CURRENT_RESULT) for multistmt req cursor positioning. 
JDBC-99338 certify WebLogic 9.1 on Windows. 
JDBC-99339 certify WebLogic 9.1 on Solaris/SPARC. 
JDBC-99341 certify WebLogic 9.1 on Linux. 
JDBC-99343 certify ColdFusion MX 7 on Windows. 
JDBC-101800 support "jdbc:default:connection" URL for use in a Java Stored Procedure. 
JDBC-102453 JDBC support for Stored Procedure Dynamic Result Sets. 
JDBC-102730 support full ANSI MERGE statement. 
JDBC-102732 support the SET QUERY_BAND statement. 
JDBC-102852 add TD 12.0 reserved words to DatabaseMetaData.getSQLKeywords. 
JDBC-103778 certify with JBoss 3.2.3 on Windows.
JDBC-103780 certify with WebSphere 6.1 on Windows. 
JDBC-103781 certify with WebSphere 6.1 on AIX. 
JDBC-103782 certify with WebSphere 6.1 on Solaris/SPARC. 
JDBC-104096 update application server documentation for TTU 12.0 release. 
JDBC-104748 certify Windows XP Professional x64 on EM64T with JDK 5.0 32-bit. 
JDBC-104749 certify Windows XP Professional x64 on EM64T with JDK 5.0 64-bit. 
JDBC-104750 certify 32-bit Windows Server 2003 on EM64T with JDK 5.0 32-bit. 
JDBC-107100 ResultSet and CallableStatement getString for BYTE/VARBYTE value to use session charset instead of JVM default charset.
JDBC-107197 JDBC-related corrections to the Introduction to Teradata Warehouse.
JDBC-108118 UNIX-Kerberos target name is case-sensitive, so Teradata JDBC Driver must change Teradata@m/c to TERADATA@m/c. 
JDBC-108385 Change Teradata JDBC Driver version to 12.0.0.1. 
JDBC-108390 accommodate DBS version change from V2R7.0 to 12.0. 
JDBC-109658 support CHARSET= connection parameter for jdbc:default:connection for Java Stored Procedures. 
JDBC-109689 Corrections for UNIX classpath listed in Chapter 2 section "Running a Sample Application".
JDBC-109728 Certify TTU 12.0 JDBC Driver with JBoss 4.0 and JDK 5.0. 
JDBC-110204 Statement.getMoreResults (KEEP_CURRENT_RESULT) to support only TYPE_SCROLL_INSENSITIVE.
JDBC-110539 Statement.execute fails for a CALL to a stored procedure.
JDBC-112657 SQLState mappings for External Stored Procedure error codes.
JDBC-112978 accommodate 12m DBS DR 110445 change to DBC.Columns.ColumnName value 'RETURN' is now 'RETURN0'.

This release includes changes to address the following issues, originally included
in release 03.04.00.06:

JDBC-131684 add JDBC FastLoad support for EJB transactions with multiple PreparedStatements

This release includes changes to address the following issues, originally included
in release 03.04.00.05:

JDBC-131418 support DBS_PORT connection parameter with TYPE=FASTLOAD and FASTEXPORT

This release includes changes to address the following issues, originally included
in release 03.04.00.03:

JDBC-96980 GtwConfigParcel could fail when new gateway features added
JDBC-97103 improve correlation of TDSession objects with log messages
JDBC-98176 avoid sending cancel request if RESP/BIGRESP is used and ENDREQUEST received
JDBC-100090 modify driver to avoid DBS crash when using LOB_SUPPORT=off and large result set
JDBC-106708 add LOG=TIMING measurements
JDBC-114154 CallableStatement batch support to execute CALL sequentially to work within DBS restriction of single CALL at a time
JDBC-114470 TTU 8.1 Teradata JDBC Driver 3.3 to support TD 12.0 (backport DR 108390)
JDBC-115269 improve JDBC FastLoad exception handling of PreparedStatement.executeBatch and Connection.rollback
JDBC-115914 Customer gets errors on jdbc connection attempts originating from TdgssConfigApi (shipped with tdgssjava 6.2.2.19)
JDBC-118851 Java TDGSS_6.1.1.93_GCA fails against a 12.00.00.04 DBS for Kerberos (shipped with tdgssjava 6.2.2.22)
JDBC-119000 ResultSetMetaData.isAutoIncrement should return true for identity column
JDBC-119320 Add ActivityType 123 for REPLACE UDF
JDBC-120597 force connection failure for invalid response message header
JDBC-120929 DatabaseMetaData.getColumns returns incorrect information when using UTF8 session character set

This release includes changes to address the following issues, originally included
in release 03.04.00.02:

JDBC-107900 support ambiguous data type for ResultSet columns with SIP-enabled prepare of select-list parameter markers
JDBC-110436 provide consistency for ACCOUNT connection parameter
JDBC-112806 PreparedStatement: treat Types.FLOAT & Types.REAL as Types.DOUBLE in setObject and preserve float precision in setFloat
JDBC-113069 executeQuery may return error 1182 if URL param CLIENT_CHARSET is set and the DBS is running V2R6.1 or earlier

This release includes changes to address the following issues, originally included
in release 03.04.00.01:

JDBC-100351 support the MONITOR partition
JDBC-100352 support the DBCCONS partition
JDBC-103835 return actual update count for MERGE insert, MERGE update, and MERGE mixed SQL statements
JDBC-104893 provide high-level JDBC FastLoad connection for automatic management of multiple low-level connections
JDBC-106917 CallableStatement.getObject fails for INOUT Clob parameter when input value was sent to 6.2 DBS as VARCHAR
JDBC-108500 ResultSetMetaData.getSchemaName to return database name with Teradata Database 6.2
JDBC-108926 enable JDBC Load and Export sessions to be identifiable by TASM
JDBC-109424 Make Elicit File protocol work with the JDBC driver and 64 bit Windows DBS
JDBC-109760 Change sample program T21400JD to demonstrate call to corrected UDF Judf01
JDBC-110059 Return correct values for getColumnDisplaySize for temporal data types
JDBC-110112 provide pre-V2R6.2 high-level JDBC FastLoad connection for automatic management of multiple low-level connections
JDBC-111254 JDBC FastLoad support for BIGINT and large DECIMAL, JDBC FastLoad support for EJB transactions

This release includes changes to address the following issues, originally included
in release 03.04.00.00:

JDBC-58028 JDBC 3.0 ParameterMetaData methods.
JDBC-94704 RFC: Support the retrieval of auto-generated keys from an insert statement.
JDBC-95968 Add support for BIGINT and DECIMAL(38).
JDBC-96457 certify JDBC driver with Teradata Database on Windows x64.
JDBC-96467 update application server documentation for TTU 8.2 / JDBC 3.4 release.
JDBC-97514 ResultSetMetaData methods to use actual database values rather than COMPAT_xxx.
JDBC-97554 provide User Defined Type (UDT) information from DatabaseMetaData methods.
JDBC-99270 certify Solaris 10 64-bit on AMD64 with JDK 5.0 32-bit & 64-bit.
JDBC-99337 certify Red Hat AS 4.0 64-bit on AMD64 with JDK 5.0 32-bit & 64-bit.
JDBC-104782 setMaxFieldSize(small value) causes subsequent exceptions from getDate for ANSI date, getTime, and getTimestamp

This release includes changes to address the following issues, originally included
in release 03.03.00.04:

JDBC-87473 getColumnDisplaySize returns number of bytes for Character columns
JDBC-104043 DatabaseMetaData.getTableTypes should return ResultSet ordered by TABLE_TYPE
JDBC-108939 User Guide must say setAsciiStream/setCharacterStream are not supported for binding data to BYTE or VARBYTE destinations
JDBC-109213 Encryption problem message may not display an argument
JDBC-109231 TYPE_SCROLL_INSENSITIVE used with execute method causes subsequent getMoreResults to hang or throw exception
JDBC-109294 Statement.executeBatch must clear the batch
JDBC-109615 DatabaseMetaData.getColumns throws exception

This release includes changes to address the following issues, originally included
in release 03.03.00.03:

JDBC-101277 enable UDFs, XSPs, and UDMs to be created from resources on client using JDBC
JDBC-106841 improve SQLException from executeXXX when InputStream bound with setXxxStream is closed before executeXXX
JDBC-107345 TTU 8.1: Getting NullPointerException from tdgssjava (shipped with tdgssjava 6.2.0.4)
JDBC-107536 CallableStatement executeUpdate: error 6906 (iterated request disallowed) occurs after error 1184 (invalid parameter)
JDBC-107987 workaround for Java 2 security Sun Bug ID 6205384 - SocketPermission ignored for unknown host 
JDBC-108260 restrict printed characters to 7-bit ASCII in debug log message dumps

This release includes changes to address the following issues, originally included
in release 03.03.00.02:

JDBC-101381 scalar functions (TIMESTAMPADD, TIMESTAMPDIFF) need SQL_TSI_HOUR
JDBC-103411 Add support for inserting NULL, Unicode characters, and remaining data types to be supported by JDBC FastLoad
JDBC-103740 with CHARSET=UTF16, PreparedStatement.executeBatch should accept TIMESTAMP values w/varying number of fractional digits
JDBC-103772 send millisecond portion of java.sql.Time values to DBS with omitted TNANO connection parameter, & with TNANO=1 or more
JDBC-104020 getTime & getObject methods: return TIME values w/fractional seconds as java.sql.Time values w/milliseconds precision
JDBC-104370 throw SQLException when DBS says 'n' characters are coming but really only sends a fraction of 'n'
JDBC-104825 insert trailing zeros before TIME ZONE for TIME or TIMESTAMP values with varied precisions and no TNANO or TSNANO
JDBC-105073 Modify setBinary/Ascii/CharacterStream methods to determine when to send Deferred LOB/VARCHAR/VARBYTE values
JDBC-105265 Ensure driver is registered only once with DriverManager
JDBC-105633 non-prepared Statement.executeBatch is limited to fewer statements with V2R6.x than with V2R5.x
JDBC-105834 PreparedStatement.setAsciiStream drops trailing spaces
JDBC-106091 stream/reader from Clob.getAsciiStream/getCharacterStream should remain valid for Connection lifetime 
JDBC-106115 Clob.getSubString truncates data when a multi-byte character set is used
JDBC-106116 cannot execute more than once a CallableStatement with OUT parameters on V2R6.0 and earlier
JDBC-106118 Incorrect data is returned if the ResultSet is closed while reading a Blob
JDBC-106136 A finalize statement needs to be implemented for LobStatement 
JDBC-106243 ResultSet.getAsciiStream returns invalid data on mainframe z/OS USS

This release includes changes to address the following issues, originally included
in release 03.03.00.01:

JDBC-58030 RFC: JDBC3.0: DatabaseMetaData methods (New in JDBC 3.0)
JDBC-58032 RFC: JDBC3.0: DatabaseMetaData methods (MODIFIED from JDBC2.0)
JDBC-96462 certify Teradata JDBC Driver with SAP Web Application Server 6.40
JDBC-97255 document Teradata JDBC Driver configuration with SAP Universal Data Connector
JDBC-98047 DatabaseMetaData.getProcedures returns ResultSet that differs from API javadoc
JDBC-98048 DatabaseMetaData.getProcedureColumns returns ResultSet differs from API javadoc
JDBC-98050 DatabaseMetaData.getColumns fails when a database name contains a quote
JDBC-98051 PreparedStatement.setCharacterStream and setAsciiStream drop trailing spaces
JDBC-98053 DatabaseMetaData.getColumns returns RS w/RSMD.getColumnTypeName null for all columns
JDBC-98055 DatabaseMetaData.getPrimaryKeys returns ResultSet that differs from API javadoc
JDBC-98855 setBigDecimal throw DataTruncation for >18 integral digits; & round frac. digits
JDBC-99578 implement JDBC 1.0 DatabaseMetaData methods
JDBC-99720 low-level FastLoad connection with PreparedStatement batch update
JDBC-99760 AppServer-HowTo HTML doc needs modification for JRun datasource definition
JDBC-100404 use 24-hour values rather than 12-hour for JDBC driver log message timestamps
JDBC-100902 automatic close of garbage-collected Statement and ResultSet objects
JDBC-101115 PreparedStatement.setLong to throw DataTruncation when long value has 19 digits
JDBC-101767 ResultSet.absolute fails for negative row numbers
JDBC-102405 thread deadlock for concurrent calls to Statement.executeQuery & ResultSet.close
JDBC-103173 securerandom.source and/or java.security.egd dont work in 1.5.0_05 (tdgssjava 6.1.0.18)

This release includes changes to address the following issues, originally included
in release 03.03.00.00:

JDBC-50036 RFC: JDBC1.0: Escape syntax support
JDBC-83850 RFC: JDBC2.0: PreparedStatement.getMetaData()
JDBC-89445 ResultSetMetaData.getColumnClassName should return class name, not null
JDBC-89449 Need to add COMPAT_xxx URL parameters for three ResultSetMetaData methods 
JDBC-91121 disallow specification of a username and password when LDAP or Kerberos is used
JDBC-91636 Implement Denial of services feature as documented in TRP 541-0004949 
JDBC-91796 update application server documentation for TTU 8.1 / JDBC 3.3 release
JDBC-92136 Enable transaction isolation level TRANSACTION_READ_UNCOMMITTED
JDBC-92143 DatabaseMetaData: obtain DBS limits from Config Response parcel
JDBC-92146 obtain DBS version/release from new feature item in Config Response parcel
JDBC-92212 testing: support V2R6.1 feature: external security clause for sprocs/UDFs
JDBC-92216 J2SE 5.0 (JDK 1.5) certification
JDBC-92219 Solaris 10/SPARC 32-bit and 64-bit certification
JDBC-92221 AIX 5.3 32-bit and 64-bit certification
JDBC-92222 SuSE Linux 32-bit certification
JDBC-92223 WebSphere 6.0 Certification
JDBC-92228 WebLogic 8.1 with both Sun JVM and JRockit JVM Certification
JDBC-92230 ColdFusion MX 6.1 Certification
JDBC-92231 JBoss 4.0 Certification
JDBC-92449 Implement UTF16 support for tdgss as documented in TRP 541-0005061
JDBC-92450 eliminate HELP PROCEDURE before calls to sprocs with OUT params
JDBC-92648 translate new JDBC 3.3 error messages into Japanese
JDBC-92693 TTU 8.1 / JDBC 3.3 User Guide: no support for V2R6.1 User Defined Types (UDTs)
JDBC-92736 Include info for the sample files in samples.jar for MVS in the JDBC Users Guide
JDBC-92919 DatabaseMetaData APIs should support patterns containing single quotes
JDBC-93293 Single quote in comment throws invalid error via JDBC
JDBC-93890 getHoldability APIs should return HOLD_CURSORS_OVER_COMMIT, not throw exception
JDBC-94311 testing: support V2R6.1 feature: activity count overflow warning
JDBC-94816 JDBC User Guide section "Improving Performance": list use of PreparedStatement
JDBC-95061 TTU 8.1 JDBC User Guide addition: CALL statements not using Escape Syntax
JDBC-95334 corrections for JDBC User Guide Appendix D - Data Type Conversions
JDBC-95741 JDBC User Guide changes to Chapter 1 section "Support for Internationalization"
JDBC-95961 database error in TERA mode with autocommit off incorrectly turns autocommit on
JDBC-95969 incomplete update count array in TERA mode w/autocommit off for failed batch req
JDBC-96149 Provide warning message from SuccessParcel to Statement.getWarnings method
JDBC-96253 Package TdgssUserConfigFile.xml in a jar file
JDBC-96653 Revamp JDBC Connection Pool Orange Book as HTML docs in appserver-howto.jar
JDBC-96824 JDBC User Guide change: discontinued CASE_SENSITIVE connection parameter
JDBC-96914 TTU 8.1 JDBC User Guide addition: new section: "Planned Future Changes"
JDBC-97038 TTU 8.1 JDBC User Guide addition: new section: LogonSource Format
JDBC-97290 Large batch requests using LOB params, may fail to process all requests in batch
JDBC-97428 HPUX 11.23/Itanium-2 32-bit and 64-bit certification
JDBC-97550 corrections for COMPAT_GETSCHEMA and COMPAT_GETTABLE information in JDBC UG
JDBC-97585 TTU 8.1 JDBC User Guide: new contents for section: Response Limit Exceeded Error
JDBC-97723 fix sample programs T21301JD, T21302JD to use ConnectionPoolDataSource correctly
JDBC-97747 TTU8.1 JDBC Users Guide: need to add an explanation for DBS error 3926
JDBC-97816 DatabaseMetaData.getMaxStatements should return 16, not 1048500
JDBC-98089 TTU 8.1 JDBC User Guide changes: miscellaneous "Supported Methods" changes
JDBC-98110 TTU 8.1 JDBC UG: refer readers to appserver documentation in download package

This release includes changes to address the following issues, originally included
in release 03.02.00.03:

JDBC-56133 Implement JDBC1.0 APIs DatabaseMetaData.getExportedKeys and getImportedKeys
JDBC-90532 PreparedStatement.setBigDecimal throws java.lang.ArithmeticException exception
JDBC-92609 Wrong value in the database when PreparedStatement.setBigDecimal is being used
JDBC-97022 PreparedStatement.executeBatch throws ClassCastException: java.util.ArrayList

This release includes changes to address the following issues, originally included
in release 03.02.00.02:

JDBC-84637 RFC: Statement.execute() should not retrieve all the data before returning
JDBC-87267 JDBC error: ('0A'X) is not a valid Teradata SQL token
JDBC-89201 UT: NullPointerException for unbound prep stmt parameter (should be SQLException)
JDBC-90136 JDBC throws parameter error when ? occurs in 2nd quoted string
JDBC-91353 setNull does not work correctly when the sql type is a Boolean
JDBC-91951 CLIENT_CHARSET connection parameter
JDBC-92125 add LOG=TIMING connection parameter
JDBC-92294 JDBCException when creating UDF: Function 'Judf01' already exists
JDBC-92697 getTables() to get the table type, the resultset contains "T" instead of Table
JDBC-92918 map replication error code 6699 to SQLState 40001 (transaction rolled back)
JDBC-93054 Logon fails with 8019 from jdbc when ldap mechanism is used
JDBC-93156 Inserting null decimal datatypes not working when URL LOB_SUPPORT=OFF
JDBC-93157 Using PreparedStatement.setObject(int, Object) to set null value throws NPE
JDBC-93549 Type 4 driver Get-column-by-name from 2nd RS throws "column not found" exception
JDBC-94407 do not include class files in samples.jar
JDBC-94605 Statement.addBatch fails when SQL contains trailing space
JDBC-94923 row fetching too slow with >1000 rows in result set using 1MB response messages
JDBC-94970 PreparedStatement.getResultSet should return null for non-RS-returning statement
JDBC-95078 interoperability issue when Connection.close called while query is in progress
JDBC-95302 provide SQLState for V2R6.0.x retryable error codes 3231 and 3319
JDBC-95828 CLIENT_CHARSET DataSource property
JDBC-95943 DatabaseMetaData.getSQLKeywords for V2R5.0, V2R5.1, and V2R6.0

This release includes changes to address the following issues, originally included
in release 03.02.00.01:

JDBC-85852 TeraLocalPrepared/CallableStatement.getResultSetType and other incorrect methods

This release includes changes to address the following issues, originally included
in release 03.02.00.00:

JDBC-57921 RFC: JDBC Certification on Windows 2003 Server (32-bit/64-bit)
JDBC-63499 RFC: Make changes to files for JDBC to use JDK 1.4
JDBC-68162 RFC: JDBC2.0: PreparedStatement batch updates
JDBC-68625 RFC: Add more sample files to JDBC package
JDBC-68837 RFC: V2R6: 1 MB/APH Responses
JDBC-68844 RFC: V2R6: Security Improvements and Extensions
JDBC-69061 RFC: JDBC2.0: Scrollable ResultSets (bi-directional cursor positioning)
JDBC-84400 RFC: Certify Sun Microsystems RowSet implementation with JDBC driver
JDBC-84635 RFC: remove jdbc4.properties file - use connection attributes
JDBC-84672 RFC: Remove platform packaging for JDBC Type 4 driver
JDBC-84853 RFC: Test JDBC Driver with WebSphere 5.1
JDBC-84854 RFC: Test JDBC driver with WebLogic 8.1 
JDBC-85123 RFC: JDBC Certification on 64-bit Linux
JDBC-85393 RFC: Remove Type 3 driver from product
JDBC-85397 RFC: Update values for DatabaseMetaData functions for V2R6
JDBC-85434 createStatement: Downgrade RS type and concurrency, and generate SQLWarning
JDBC-85536 RFC: Enable Type 4 driver to be built on Solaris
JDBC-85980 RFC: remove sample applets
JDBC-85981 DatabaseMetaData.getIndexInfo() is not implemented correctly
JDBC-86049 JDBC was not handling nulls in where clauses correctly in releases 3.1 & earlier
JDBC-86456 RFC: support LOBs as stored procedure output parameters
JDBC-86471 TRANSACTION_READ_UNCOMMITTED(1) is not supported 
JDBC-87018 ResultSet.getConcurrency should return CONCUR_READ_ONLY
JDBC-87512 various ResultSetMetaData methods throw exceptions
JDBC-88400 RCI: Null Pointer dereference in ParcelFactory.java
JDBC-88403 RCI: Null Pointer Dereference in Statement.java
JDBC-88405 RCI: Resource leak of FileInputStream
JDBC-88409 RCI: Resource Leak ResultSets not being closed
JDBC-88581 Null Pointer exception in TDGSS interface code
JDBC-88763 Deprecate TeraStatement.getSpl and setSpl methods for TTU 8.0
JDBC-89173 STV: Statement.getXXX and PrepStmt.setXXX conversions must match User Guide


Troubleshooting Topics
----------------------


TERAJDBC4 ERROR ... The com.ncr.teradata.TeraDriver class name is deprecated
----------------------------------------------------------------------------
New Teradata JDBC Driver class names are available.

   - For JDBC URL connections: com.teradata.jdbc.TeraDriver
   - For WebSphere Data Sources: com.teradata.jdbc.TeraConnectionPoolDataSource

The old class names will continue to work; however, a warning message
will be printed as a reminder to switch over to the new class names.

   TERAJDBC4 ERROR ... The com.ncr.teradata.TeraDriver class name is deprecated.
   Please use the com.teradata.jdbc.TeraDriver class name instead.

   TERAJDBC4 ERROR ... The com.ncr.teradata.TeraConnectionPoolDataSource class name is deprecated.
   Please use the com.teradata.jdbc.TeraConnectionPoolDataSource class name instead.


Solution:

Please change your applications and data source definitions at your
earliest convenience, because the old class names will only be supported
for a limited number of future releases.


Installation
------------

This release of the Teradata JDBC Driver is distributed as platform-independent 
jar files. For downloading convenience, the platform-independent jar files are 
bundled together and provided in both zip format and tar format.

TeraJDBC__indep_indep.16.20.00.10.zip and TeraJDBC__indep_indep.16.20.00.10.tar
both contain the same set of platform-independent files:

  readme.txt               - this file
  terajdbc4.jar            - the Teradata JDBC Driver
  tdgssconfig.jar          - the Teradata security configuration

Download either the zip file or the tar file, and unzip (or untar) the downloaded
file into a directory of your choice, and then set your classpath to refer to the
necessary jar files.

Your classpath must include:

  terajdbc4.jar
  tdgssconfig.jar

Your classpath must NOT include any jar files from any previous releases of
the Teradata JDBC Driver. It is recommended, but not required, that any
previous release of the Teradata JDBC Driver be uninstalled prior to
downloading and using this release of the Teradata JDBC Driver.


Documentation
-------------

Documentation for how to use the Teradata JDBC Driver is available at
http://developer.teradata.com/connectivity/reference/jdbc-driver
