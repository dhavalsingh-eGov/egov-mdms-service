alter table egeis_attendance_type add column tenantid character varying(256);
update egeis_attendance_type set tenantid='default' where tenantid is null;
alter table egeis_attendance_type alter column tenantid set not null;

ALTER TABLE egeis_attendance_type DROP CONSTRAINT pk_egeis_attendance_type;
ALTER TABLE egeis_attendance_type ADD CONSTRAINT pk_egeis_attendance_type PRIMARY KEY (id, tenantId);

