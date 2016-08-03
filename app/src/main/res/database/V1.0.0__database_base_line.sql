DROP TABLE IF EXISTS "appointment";
CREATE TABLE "appointment" (
  "id"           INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "event_id"     INTEGER                            NOT NULL,
  "doctor_id"    INTEGER                            NOT NULL,
  "notification" INTEGER
);

DROP TABLE IF EXISTS "calendar";
CREATE TABLE "calendar" (
  "id"        INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "event_id"  INTEGER                            NOT NULL,
  "date_time" DATETIME                           NOT NULL
);

DROP TABLE IF EXISTS "doctor";
CREATE TABLE "doctor" (
  "id"            INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "specification" VARCHAR(30)                        NOT NULL,
  "name"          VARCHAR(50)                        NOT NULL,
  "image"         VARCHAR(30),
  "phone"         NUMERIC,
  "email"         VARCHAR(30)
);

DROP TABLE IF EXISTS "event";
CREATE TABLE "event" (
  "id"              INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "type"            INTEGER                            NOT NULL,
  "description"     VARCHAR,
  "start_date_time" DATETIME                           NOT NULL,
  "end_date_time"   DATETIME,
  "location"        VARCHAR(20)
);

DROP TABLE IF EXISTS "measurement";
CREATE TABLE "measurement" (
  "id"                      INTEGER PRIMARY KEY  NOT NULL,
  "event_id"                INTEGER              NOT NULL,
  "measurement_template_id" INTEGER              NOT NULL,
  "measurement_shape_id"    INTEGER              NOT NULL
);

DROP TABLE IF EXISTS "measurement_shape";
CREATE TABLE "measurement_shape" (
  "id"   INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "name" VARCHAR(20)                        NOT NULL,
  "icon" VARCHAR(20)                        NOT NULL
);

DROP TABLE IF EXISTS "measurement_template";
CREATE TABLE "measurement_template" (
  "id"                   INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "name"                 VARCHAR(50)                        NOT NULL,
  "measurement_template" VARCHAR                            NOT NULL
);

DROP TABLE IF EXISTS "medication";
CREATE TABLE "medication" (
  "id"                  INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "event_id"            INTEGER                            NOT NULL,
  "medication_list_id"  INTEGER                            NOT NULL,
  "medication_shape_id" INTEGER                            NOT NULL
);

DROP TABLE IF EXISTS "medication_list";
CREATE TABLE "medication_list" (
  "id"                INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "global_servise_id" INTEGER                            NOT NULL,
  "name"              VARCHAR(50)                        NOT NULL
);

DROP TABLE IF EXISTS "medication_shape";
CREATE TABLE "medication_shape" (
  "id"   INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "name" VARCHAR(20),
  "icon" VARCHAR(20)
);

DROP TABLE IF EXISTS "profile";
CREATE TABLE "profile" (
  "id"        INTEGER PRIMARY KEY  NOT NULL  CHECK (typeof("id") = 'integer'),
  "user_name" VARCHAR(15)          NOT NULL,
  "password"  VARCHAR(20)          NOT NULL,
  "name"      VARCHAR(20)          NOT NULL,
  "last_name" VARCHAR(30)          NOT NULL,
  "sex"       BOOL                 NOT NULL,
  "birthday"  DATETIME,
  "zip_code"  NUMERIC,
  "email"     VARCHAR(30)          NOT NULL,
  "image"     VARCHAR(20)
);
INSERT INTO "profile"
VALUES (1, 'davit', '123456', 'Դավիթ', 'Տեր-Առաքելյան', 0, '12/03/1992', NULL, 'davitterar@gmail.com', NULL);
DROP TABLE IF EXISTS "schedule";

CREATE TABLE "schedule" (
  "id"                INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "event_id"          INTEGER                            NOT NULL,
  "repeat_type"       BOOL                               NOT NULL,
  "repeat_count"      INTEGER,
  "interval"          INTEGER,
  "repeat_type_statr" DATETIME,
  "repeat_type_end"   DATETIME
);
DROP TABLE IF EXISTS "settings";
CREATE TABLE "settings" (
  "key"   VARCHAR(20) PRIMARY KEY  NOT NULL,
  "value" VARCHAR(500)
);

DROP TABLE IF EXISTS "week_day";
CREATE TABLE "week_day" (
  "id"          INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,
  "schedule_id" INTEGER                            NOT NULL,
  "day"         INTEGER                            NOT NULL
);