show databases;

use spring5fs;

insert into `MEMBER`(EMAIL, PASSWORD, NAME, REGDATE)
values ('madvirus2@madvirus.net', '1234', 'cbk', now());

select * from `MEMBER`;

SELECT @@global.time_zone, @@session.time_zone;
