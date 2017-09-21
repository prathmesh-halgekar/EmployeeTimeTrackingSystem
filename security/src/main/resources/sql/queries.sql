create table projects(project_id varchar2(20), project_name varchar2(20),CONSTRAINT projects_pk PRIMARY KEY (project_id));
insert into projects(PROJECT_ID,PROJECT_NAME) values('1_A','EVO');
insert into projects(PROJECT_ID,PROJECT_NAME) values('2_B','TIMEWARNER');
select * from PROJECTS;
select * from emps;
drop table emps;
drop table PROJECTS;
create table emps(emp_id varchar2(20), emp_name varchar2(20), 
                  in_time varchar2(20), 
                  out_time varchar2(20), 
                  project_id varchar2(20),
                  total_pause varchar2(20),     
                  CONSTRAINT emp_PK PRIMARY KEY (EMP_ID), 
                  CONSTRAINT emp_prj_FK FOREIGN KEY (PROJECT_ID)
                  REFERENCES PROJECTS (PROJECT_ID)
                  );
insert into emps(emp_id, emp_name, in_time, out_time, project_id, total_pause) values('1', 'Bob', null, null, '1_A', '');   
commit;
exit;