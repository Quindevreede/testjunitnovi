
INSERT INTO users (username, password, enabled)
VALUES
('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
     ,('customerComplaintDetails', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
     ,('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
     ,('customerService', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
     ,('production', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
     ,('management', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES
('user', 'ROLE_USER')
     ,('customerComplaintDetails', 'ROLE_USER')
     ,('admin', 'ROLE_ADMIN')
     ,('customerService', 'ROLE_ADMIN')
     ,('production', 'ROLE_ADMIN')
     ,('management', 'ROLE_ADMIN');

INSERT INTO customer_complaint_details (order_number_customer, first_name, last_name, email, customer_commentary)
VALUES
('12345', 'Yvonne', 'de Boer', 'yvonne@hotmail.com', 'The print has smudges')
     ,('23456', 'Ali', 'Azdad', 'ali@hotmail.com', 'The colours are greyish')
     ,('34567', 'Henny', 'Huismans', 'henny@hotmail.com', 'The image is pixelated')
     ,('45678', 'Richard', 'Richardson', 'richard@hotmail.com', 'The paper is moist')
     ,('56789', 'Noonien', 'Singh', 'noonien@hotmail.com', 'The print is too dark')
     ,('67890', 'Bianca', 'al Gris', 'bianca@hotmail.com', 'The paper has a tear');

INSERT INTO production_complaint_details (order_nr_customer, code, name, production_commentary)
VALUES
('101', 'BadCOLOR', 'Dog picture', 'Black is grey PRINT AGAIN with better ink')
     ,('120', 'BadPAPER', 'Family photo', 'Too much ink for paper PRINT AGAIN with better paper ')
     ,('123', 'BadPRINT', 'Car painting', 'Glitch in print PRINT AGAIN')
     ,('137', 'BadMISC', 'Disney art', 'Borders too wide PRINT AGAIN without borders')
     ,('237', 'BadCOLOR', 'Business sticker', 'Ink is running in top left corner PRINT AGAIN with better ink');

/* INSERT INTO complaints (order_number_customer_log, receipt_valid, file_name, re_print, extra_costs_estimate, production_commentary)
VALUES
('12345', 'TRUE', 'picture7.jpg', 'improveMISC', '0.00', 'Smudges happened on transport')
     ,('23456', 'TRUE', 'disney.jpg', 'improveCOLOUR', '4.50', 'Grey colours because of RBG settings')
     ,('34567', 'TRUE', 'chucknorrisportrait.pdf', 'improveMISC', '2.99', 'Image size was only 26KB')
     ,('45678', 'TRUE', 'snuffphoto.jpg', 'improvePAPER', '9.10', 'Print was a square of pure black on most basic paper')
     ,('56789', 'TRUE', 'picture222.jpg', 'improveCOLOUR', '0.00', 'Wrong printer settings')
     ,('67890', 'TRUE', 'img8766.pdf', 'improvePAPER', '0.00', 'Not sure where the damage to paper occurred');

INSERT INTO customer_complaint_results (complaint_id, customer_id, date, extra_costs)
VALUES
      ('1', '1', 'now' , 12.22)
     ,('2', '1', 'now', 0.90)
     ,('3', '3', 'now', 0.00)
     ,('4', '4', 'now', 2.88)
     ,('5', '5', 'now', 4);

INSERT INTO user_customer_complaint_details_results (user_id, customer_complaint_details_id, date, extra_costs)
VALUES
('1', '1', 'now' , 12.22)
     ,('2', '1', 'now', 0.90)
     ,('3', '3', 'now', 0.00)
     ,('4', '4', 'now', 2.88)
     ,('5', '5', 'now', 4);
*/

INSERT INTO production_employees (last_name, production_department, company_phone_number)
VALUES
('de Vreede', 'Posters & Stickers', '201')
     ,('van de Berg', 'Books', '202')
     ,('Meyers', 'Small Prints', '203')
     ,('Ruyters', 'Postcards', '204');

INSERT INTO customer_assist_employees (last_name, position, company_phone_number)
VALUES
('van Dongen(M)', 'Head of Service', '101')
     ,('van Dongen(R)', 'Service Representative', '102')
     ,('Wong', 'Phone/Email Representative', '103');

insert into teams (id, naam, land, jaar)
values
    (1, 'Oranje', 'NL', 2020),
    (2, 'Oranje', 'NL', 2016),
    (3, 'Oranje', 'NL', 2012);

insert into spelers (rugnummer, naam, positie, team_id)
values
    (1, 'Justin Bijlow', 'GK', 1),
    (13, 'Tim Krul', 'GK', 1),
    (23, 'Joël Drommel', 'GK', 1),
    (2, 'Jurriën Timber', 'DF', 1),
    (3, 'Matthijs de Ligt', 'DF', 1),
    (4, 'Virgil van Dijk (captain)', 'DF', 1),
    (5, 'Tyrell Malacia', 'DF', 1),
    (6, 'Stefan de Vrij', 'DF', 1),
    (17, 'Daley Blind', 'DF', 1),
    (18, 'Devyne Rensch', 'DF', 1),
    (22, 'Denzel Dumfries', 'DF', 1),
    (8, 'Georginio Wijnaldum (vice-captain),', 'MF', 1),
    (12, 'Guus Til', 'MF', 1),
    (14, 'Davy Klaassen', 'MF', 1),
    (15, 'Marten de Roon', 'MF', 1),
    (16, 'Ryan Gravenberch', 'MF', 1),
    (20, 'Teun Koopmeiners', 'MF', 1),
    (21, 'Frenkie de Jong', 'MF', 1),
    (7, 'Steven Bergwijn', 'FW', 1),
    (9, 'Donyell Malen', 'FW', 1),
    (10, 'Memphis Depay', 'FW', 1),
    (11, 'Steven Berghuis', 'FW', 1),
    (19, 'Wout Weghorst', 'FW', 1);

INSERT INTO course (code, name) VALUES ('SPR', 'Springboot');
INSERT INTO course (code, name) VALUES ('DON', 'Database Ontwikkeling');

INSERT INTO students (first_name, last_name, student_nr)
VALUES
('Tom', 'de Boer', '345674')
     ,('Yassine', 'Azdad', '123124')
     ,('Debby', 'Huismans', '452235')
     ,('Jay', 'Richardson', '467892')
     ,('Maninder', 'Singh', '745631')
     ,('Ilias', 'al Gris', '928345')
     ,('Eghbol', 'Sarwar', '372940')
     ,('Bart', 'Heijenk', '344611')
     ,('Quincy', 'Soerkarso', '946389')
     ,('Asare', 'Twum', '329573');

INSERT INTO student_course_results (course_id, student_id, date, score)
VALUES
('1', '1', '2020-10-10', '9')
     ,('1', '2', '2020-10-10', '8')
     ,('1', '3', '2020-10-10', '7')
     ,('2', '1', '2020-10-15', '9')
     ,('2', '3', '2020-10-15', '8')
     ,('2', '4', '2020-10-15', '9')
     ,('2', '5', '2020-10-15', '8');

insert into customers (first_name, last_name, date_of_birth)
values
    ('Peter','Anema','1956-08-20'),
    ('Robert','Anema','1957-11-28'),
    ('Ted','Anema','1959-12-07'),
    ('Walter','Anema','1960-01-10');
