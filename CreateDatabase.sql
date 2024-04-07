CREATE DATABASE FinalSourceDatabase;

Use FinalSourceDatabase;
CREATE TABLE ACCOUNT(
	LoginName varchar(12)not null,
	Password varchar(20)not null,
	Accounttype varchar(12)not null,
	AccountID char(6) PRIMARY KEY not null,
);

CREATE TABLE Admin_(
	AdminEmail varchar(30)not null,
	AdminPhone varchar(12) not null ,
	AdminName varchar(50)not null,
	AdminID char(6) PRIMARY KEY not null,
	AccountID char(6) foreign key references ACCOUNT(AccountID),
	
);


INSERT INTO Admin_ VALUES
(N'manhtoan203@gmail.com', '0949382892', 'Toan Manh', 'Admin1', 'toanmanh19', 'Nhacuamanh320'),
(N'tyhoang195@gmail.com', '0945682122', 'Hoang Ty', 'Admin2', 'hoangty53', 'Nguyenty5101'),
(N'nganguyen093@gmail.com', '0923682555', 'Nguyen Hoang Nga', 'Admin3', 'nganguyen01', 'Hoanghasonshine109'),
(N'thigung909@gmail.com', '0923682868', 'Tran Thi Gung', 'Admin4', 'thigung01', 'Gunggiare199k'),
(N'vancau123@gmail.com', '0926682999', 'Doan Van Cau', 'Admin5', 'vancau78', 'conchimxanh1999');


CREATE TABLE Customers (
    CusID char(6)  PRIMARY KEY not null,
    CusName nvarchar(50)not null,
    CusAddress varchar(255)not null,
	CusPhone varchar(12) not null,
	CusEmail varchar(255)not null,
	AccountID char(6) foreign key references ACCOUNT(AccountID),
	
);

INSERT INTO Customers VALUES
('QEW2AY', N'Đường Ðắc Nhuận', '54 Luong Dinh Cua Dist.1,Khanh Hoa,Vietnam', '0565574275', 'jrkniwi@gmail.com','mdc29fEgHOv5', 'WmJu0K'),
('L3R0DX', N'Sùng Lien Võ', '120/29 Thich Quang Duc Ward 4,Ho Chi Minh City,Vietnam', '0673834617', 'bpuwqmg@gmail.com','G6UF9zjTl80f', 'sOgZUN'),
('AYEW2P', N'Lyly Oanh Thien', '60/164 Ton Duc Thang Street Lane Thinh Hao 1,Ho Chi Minh City,Vietnam', '0376629397', 'nwpxisn@gmail.com','KXi0Qw5aDGhw', 'JWjO2j'),
('BCXCKQ', N'Chriêng Thượng Nhàn', '303/18/32 Tan Son Nhi St. Tan Son Nhi Ward,Thua Thien Hue,Vietnam', '0164706386', 'uklxnnm@gmail.com','4z29rwc3DXnp', '9JZSAg'),
('RTEHL4', N'Hán Vu Duy', '42 Dao Duy Anh St. Ward 9,Ho Chi Minh City,Vietnam', '0480721043', 'dahlyay@gmail.com','rEQPsie15Ljl', '2jOplf'),
('DP95G0', N'Vạn Phúc Khúc', '50 Mai Hac De Street,Hanoi,Vietnam', '0964687871', 'lmhuzpi@gmail.com','woDscQyelcNM', 'c1NiPy'),
('VZKI32', N'Trần Khiết Quý', '500/96 Pham Van Hai Ward 3,Ho Chi Minh City,Vietnam', '0585545657', 'clsegvj@gmail.com','VYYYmyvg6eSO', 'Gr4re4'),
('FCNS08', N'Anh Cát Tu', '288 Highway 14 Phu Loc Block,Hanoi,Vietnam', '0820873326', 'ijddwdw@gmail.com','wz7Vc2mea9B7', 'CfiEfe'),
('742P4O', N'Thục Sương Ngon', '16 Quach Van Tuan Street P12,Ho Chi Minh City,Vietnam', '0204954334', 'srhfdyo@gmail.com','UWS8KY3gb2X8', '17RyPI'),
('BIKI33', N'Liêu Long Loi', '129 Khanh Hoi St. Ward 3 Dist. 4,Ho Chi Minh City,Vietnam', '0126452576', 'dojgqrp@gmail.com','AObtmbxcJD4p', 'mwPO8u'),
('LOOWTZ', N'Khu Khuc Hải', '43 Giai Phong Street Ward 14,Ho Chi Minh City,Vietnam', '0223438022', 'ljezhmv@gmail.com','7hBYORnSnnX1', '62yuTN'),
('5Q7ECR', N'Xung Như Hau', '2C Tran Khanh Du Street Tan Dinh Ward District 1,Ho Chi Minh City,Vietnam', '0725685309', 'dkzkvwz@gmail.com','LzjhlBFY3n7a', 'i8VxfU'),
('JNYN9Y', N'Phương Phụng Liêm', '203/9 Chua Boc Street,Hanoi,Vietnam', '0522291196', 'vpirhon@gmail.com','UyYzA3sfraOQ', 'CojzLK'),
('HXYIHA', N'Sùng Đức Loc', '38 cau go,Hanoi,Vietnam', '0438126740', 'ktahpco@gmail.com','Gmznui75vQ7s', 'Up0jXc'),
('U147T3', N'Chế Ly Cương', '100/564 Thich Quang Duc Ward 5,Ho Chi Minh City,Vietnam', '0918964270', 'nmwrveu@gmail.com','HoB33rkNNM7u', 'bPE7Q9'),
('1RWA2T', N'Ha Thuy Duc', '46/7 Tan Thoi Hiep Ward Dist.12,Ho Chi Minh City,Vietnam', '0843966955', 'sthvguh@gmail.com','f7t6ycTPMXbH', 'zhkG5t'),
('8C1EEB', N'Châu thùy Kiếm', '16 Huyen Quang St. Tan Dinh Ward Dist. 1,Ho Chi Minh City,Vietnam', '0912228825', 'lvjpiho@gmail.com','gfCdYqPSOJdA', '3u07P4'),
('9OXD1K', N'Mai Phương Kiên', '11th Floor  146 Nguyen Cong Tru street Nguyen Thai Binh Ward,Ho Chi Minh City,Vietnam', '0059588882', 'zpnxxyn@gmail.com','6yYN2VTT28Cz', 'aIION5'),
('S0G6V3', N'Ngân Chấn Nam', '71 Hang Trong Street,Hanoi,Vietnam', '0443028370', 'jvfjuzm@gmail.com','qop5qoYsxCLA', 'Xoc16Q'),
('8YIODR', N'Cù Dạ Tùng', '107 Hoa Hung St. Ward 12 Dist. 10,Ho Chi Minh City,Vietnam', '0347290676', 'xkpfowz@gmail.com','E3pMEQ5KWOqy', 'xyvBu2');


CREATE TABLE Employees(
	EmpEmail varchar(30)not null,
	EmpID char(6) not null PRIMARY KEY,
	EmpName nvarchar(50)not null,
	EmpPhone varchar(12)not null,
	AdminID char(6) FOREIGN KEY REFERENCES Admin_(AdminID),
	AccountID char(6) foreign key references ACCOUNT(AccountID),
);

INSERT INTO Employees (EmpID, EmpName, EmpPhone, EmpEmail, EmpPassword, EmpLoginName, AdminID) VALUES
('8APIL3', 'Chử Tuong Án', '0836643037', 'slesqvz@gmail.com','CsnJ1QCnYeArZLEw', 'V8rmcI', 'Admin1'),
('154QPU', 'Đặng To Hào', '0734789255', 'kdvwwou@gmail.com','MLgYPC3sj', 'm1005s', 'Admin2'),
('US82Z0', 'Hia Tran Ðao', '0301868211', 'hcpsbtj@gmail.com','WZIYZJFmrTNJE', 'j8iQHt', 'Admin1'),
('XT5THW', 'Khương Hà Hạnh', '0212900383', 'icpgkok@gmail.com','UdmgOW6UPX4s4LJ7lq', 'L2W1GK', 'Admin1'),
('VNHC5F', 'Lô Tâm Nhi', '0257820291', 'wprpvsi@gmail.com','Fin3jb5t0S4Llo', '0GArFG', 'Admin2'),
('OBQMOV', 'Ung Thúy Huệ', '0718842470', 'telellm@gmail.com','lvV14qcV5DPF9XoX', 'BLjq3A', 'Admin1'),
('1HDWON', 'Ông Mỹ Toản', '0351060647', 'mezhqtn@gmail.com','wnTeFbmzHSivleKzo', 'LuBDMf', 'Admin2'),
('04I6V9', 'Lỗ Hoang Lạc', '0422438699', 'dppdqeb@gmail.com','ainJBKnenZzsL7x', 'qvC0RM', 'Admin2'),
('J9292K', 'Khưu Nhu Kiet', '0822174420', 'cdsqgfd@gmail.com','Ob8rdnMyh', 'EvCvrx', 'Admin2'),
('E7A8W3', 'Hàn Ban Tuấn', '0844553226', 'lyakmso@gmail.com','d182IVwVMweLx5AK0rG', '12mPsa', 'Admin1');


CREATE TABLE Product1(
	Product1ID char(8) not null PRIMARY KEY,
	Product1Name varchar(100) not null,
	ProductType varchar (50) not null,
	Quantity smallint not null,
	Material varchar(100) not null,
	Price money not null,
	Condition decimal(5,2) not null,
	EmpID char(6) FOREIGN KEY REFERENCES Employees(EmpID),
	AdminID char(6) FOREIGN KEY REFERENCES Admin_(AdminID),
);

INSERT INTO Product1 VALUES
('82RXAHHW', 'table ', 'Table / chair', '8','steel', 467000, 85.49,'8APIL3', 'Admin3'),
('UFHFZOL3', 'branded teak dark box beds ', 'Bed / bedroom item', '9','veneer sheets', 9458000, 91.9,'XT5THW', 'Admin3'),
('1JSHPEQ6', 'bar stool ', 'Table / chair', '8','acetal copolymer(POM)', 526000, 91.79,'US82Z0', 'Admin4'),
('NRHMKH4P', 'l shape sofa ', 'Sofa / living room item', '9','veneer sheets', 4826000, 90.09,'J9292K', 'Admin4'),
('O7PIFA8Y', 'teak bed & hybrid mattress--60x72--tbh2407 ', 'Bed / bedroom item', '2','MDF', 169000, 91.99,'04I6V9', 'Admin3'),
('QVR55K90', 'teak dinning table with chairs--6ftx3ft--tdt1540 ', 'Table / chair', '2','veneer sheets', 423000, 92.89,'VNHC5F', 'Admin3'),
('76SKQHWH', 'sliding window ', 'Other', '1','MDF', 97000, 83.58,'E7A8W3', 'Admin3'),
('YLXO2NIA', 'teak two door base almirah--4.5x6--ttb2825 ', 'Storage', '4','particleboard', 448000, 83.34,'1HDWON', 'Admin4'),
('R00GWJNZ', 'fabric sofa set - 21 ', 'Bed / bedroom item', '3','aluminum', 256000, 81.77,'1HDWON', 'Admin4'),
('SOBH5UEB', 'bunk beds ', 'Bed / bedroom item', '1',' thermoplastic elastomer(TPE)', 424000, 87.15,'154QPU', 'Admin3'),
('RXEA6JZI', 'teak color pillows sofa & stool--tcp3011 ', 'Sofa / living room item', '0','aluminum', 9533000, 97.74,'VNHC5F', 'Admin4'),
('7CRHTKNC', 'teak two door base almirah-4.5ftx6.5ft-tt2310 ', 'Storage', '2','steel', 407000, 94.05,'VNHC5F', 'Admin4'),
('MBCLUGKT', 'cotton 3d bedsheets ', 'Bed / bedroom item', '3','thermoplastic polyurethane(TPU)', 322000, 81.93,'8APIL3', 'Admin4'),
('XH8RLM0L', 'dining table with six chairs ', 'Table / chair', '7','plywood', 678000, 87.07,'VNHC5F', 'Admin4'),
('2J0R9261', 'teak dining table with 6 chairs - tdtc051 ', 'Table / chair', '3','acrylonitrile butadiene styrene(ABS)', 4912000, 80.14,'04I6V9', 'Admin4'),
('LCXQZ9QM', 'teak dressing table ', 'Bed / bedroom item', '1','copper', 357000, 94.46,'04I6V9', 'Admin3'),
('P916YQPU', 'teak wood three door light wardrobe ', 'Bed / bedroom item', '0','cyclic olefin copolymers(COC)', 393000, 81.89,'04I6V9', 'Admin3'),
('P7LYN187', 'wall unit cupboard with tv stand ', 'TV / stereo', '6','polycarbonate(PC)', 381000, 98.22,'VNHC5F', 'Admin4'),
('BJW15BHE', 'depo teak dining table and 6 chairs code 8707 ', 'Table / chair', '9','brass', 802000, 80.88,'8APIL3', 'Admin3'),
('19MC554F', 'dining chair- im-005 ', 'Table / chair', '5','MDF', 4531000, 85.32,'154QPU', 'Admin3');

DELETE FROM Product1;

CREATE TABLE photo(
	Product1ID char(8) FOREIGN KEY REFERENCES Product1(Product1ID)not null,
	SequenceNo tinyint not null,
	PhotoExtends VARBINARY(MAX)not null,
	PRIMARY KEY ( Product1ID, SequenceNo)
);

INSERT INTO photo VALUES
('82RXAHHW', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634026093318_Table for sale.jpg', SINGLE_BLOB) as image)),
('UFHFZOL3', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020661096_Branded Teak Dark Box Beds for sale.jpg', SINGLE_BLOB) as image)),
('1JSHPEQ6', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634025977511_Bar Stool for sale.jpg', SINGLE_BLOB) as image)),
('NRHMKH4P', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634025325007_L Shape Sofa for sale.jpg', SINGLE_BLOB) as image)),
('O7PIFA8Y', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634027375080_Teak Bed  Hybrid Mattress60x72TBH2407 for sale.jpg', SINGLE_BLOB) as image)),
('QVR55K90', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634023945825_Teak Dinning table with Chairs6ftx3ftTDT1540 for sale.jpg', SINGLE_BLOB) as image)),
('76SKQHWH', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634023619463_Sliding window for sale.jpg', SINGLE_BLOB) as image)),
('YLXO2NIA', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634022595286_Teak Two Door Base Almirah45x6TTB2825 for sale.jpg', SINGLE_BLOB) as image)),
('R00GWJNZ', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634017241013_Fabric Sofa Set  21 for sale.jpg', SINGLE_BLOB) as image)),
('SOBH5UEB', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634022678562_Bunk Beds for sale.jpg', SINGLE_BLOB) as image)),
('RXEA6JZI', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634026548838_Teak Color Pillows Sofa  StoolTCP3011 for sale.jpg', SINGLE_BLOB) as image)),
('7CRHTKNC', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634022012869_Teak Two Door Base Almirah45ftx65ftTT2310 for sale.jpg', SINGLE_BLOB) as image)),
('MBCLUGKT', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634026205937_Cotton 3D Bedsheets for sale.jpg', SINGLE_BLOB) as image)),
('XH8RLM0L', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020364898_Dining Table with Six Chairs for sale.jpg', SINGLE_BLOB) as image)),
('2J0R9261', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634025290223_Teak Dining Table with 6 Chairs  TDTC051 for sale.jpg', SINGLE_BLOB) as image)),
('LCXQZ9QM', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634028279179_Teak Dressing Table for sale.jpg', SINGLE_BLOB) as image)),
('P916YQPU', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634024739724_Teak Wood Three Door Light Wardrobe for sale.jpg', SINGLE_BLOB) as image)),
('P7LYN187', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634018737346_Wall Unit Cupboard With TV Stand for sale.jpg', SINGLE_BLOB) as image)),
('BJW15BHE', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020702963_Depo Teak Dining Table and 6 Chairs Code 8707 for sale.jpg', SINGLE_BLOB) as image)),
('19MC554F', '1',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020137652_Dining Chair IM005 for sale.jpg', SINGLE_BLOB) as image));

DELETE FROM photo;

CREATE TABLE Product2(
	Product2ID varchar(8) primary key not null,
	CusID char(6) FOREIGN KEY REFERENCES Customers(CusID),
	Product2Name varchar(100) not null, 
	PriceSuggest money not null,
	SequenceNo2 tinyint not null,
	Quantity smallint not null,
	Product2Ext VARBINARY(MAX)not null, 
);
DROP TABLE Product2;

INSERT INTO Product2 (Product2ID, CusID, Product2Name, PriceSuggest, SequenceNo2, Quantity, Product2Ext) VALUES
('EO09HHWR', '1RWA2T', 'tv stand ', 1208000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634028426857_TV STAND for sale.jpg', SINGLE_BLOB) as image)),
('Z5LNUK07', 'AYEW2P', 'kingstar mini computer tabel ', 2177000, '1', '4',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634026810984_Kingstar Mini computer Tabel for sale.jpg', SINGLE_BLOB) as image)),
('4MIEX9PI', 'L3R0DX', 'mattress 60x72 - jbm892 ', 738000, '1', '7',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020142644_Mattress 60x72  Jbm892 for sale.jpg', SINGLE_BLOB) as image)),
('DGQUJ842', 'QEW2AY', 'teak sofa set ', 668000, '1', '6',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634023046847_Teak Sofa Set for sale.jpg', SINGLE_BLOB) as image)),
('AX9WJ0WR', '1RWA2T', 'big mesh chair ', 117000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634021385427_Big mesh chair for sale.jpg', SINGLE_BLOB) as image)),
('HPUAT56N', '1RWA2T', 'teak dressing table code 4321 ', 782000, '1', '2',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634023545455_Teak dressing table code 4321 for sale.jpg', SINGLE_BLOB) as image)),
('HQBLCSPK', 'FCNS08', 'teak dining table with 6 chairs 6x3 - tdtc897 ', 528000, '1', '8',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020139143_Teak dining table with 6 chairs 6x3  tdtc897 for sale.jpg', SINGLE_BLOB) as image)),
('ZOBNRDTZ', '5Q7ECR', 'plastic chair stretch covers colors ', 537000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634025020309_Plastic Chair Stretch Covers Colors for sale.jpg', SINGLE_BLOB) as image)),
('3GQUDC4L', 'FCNS08', 'steel fully door office cupboard ', 3758000, '1', '2',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634025098882_Steel Fully Door Office Cupboard for sale.jpg', SINGLE_BLOB) as image)),
('7SHBED9G', 'BIKI33', 'new office chair multi-function ', 7136000, '1', '5',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634016971994_New Office Chair MultiFunction for sale.jpg', SINGLE_BLOB) as image)),
('QY37GM2N', 'L3R0DX', 'bar stool ', 4136000, '1', '8',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634028515803_Bar Stool for sale.jpg', SINGLE_BLOB) as image)),
('WEIV5N98', 'AYEW2P', 'rack l study table ', 3602000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020378101_Rack L Study Table for sale.jpg', SINGLE_BLOB) as image)),
('Q6C4DFB1', 'JNYN9Y', 'bed room furniture ', 6428000, '1', '4',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634027334895_Bed Room Furniture for sale.jpg', SINGLE_BLOB) as image)),
('27HTG7RS', 'U147T3', 'new 6x6 teak box bed and hybrid mattress / 028 ', 6365000, '1', '5',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634020701300_New 6X6 Teak Box Bed and Hybrid Mattress  028 for sale.jpg', SINGLE_BLOB) as image)),
('WZDHKRCO', 'HXYIHA', 'napkin polyester ', 6963000, '1', '2',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634027476139_Napkin Polyester for sale.jpg', SINGLE_BLOB) as image)),
('VLQY2G6Q', 'U147T3', 'red 4ft lobby sofa ', 2185000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634027118433_Red 4ft lobby sofa for sale.jpg', SINGLE_BLOB) as image)),
('ECGM8JO6', '8YIODR', 'varenda chair setup ', 849000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634026356123_Varenda Chair setup for sale.jpg', SINGLE_BLOB) as image)),
('3RGZOCWS', '1RWA2T', 'brand new written table large / 004 ', 418000, '1', '5',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634018368212_Brand New Written Table Large  004 for sale.jpg', SINGLE_BLOB) as image)),
('QLNPFLFG', 'QEW2AY', 'steel bed w d/l mattress ', 4659000, '1', '2',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634013463077_Steel Bed W DL Mattress for sale.jpg', SINGLE_BLOB) as image)),
('KOBHH5DM', 'DP95G0', 'sofa set ', 8555000, '1', '3',(SELECT * FROM Openrowset(BULK 'D:\Apps\MSSQL16.MSSQLSERVER\MSSQL\Img/furniture_images/1634018594456_Sofa Set for sale.jpg', SINGLE_BLOB) as image));

​
DELETE FROM Product2;

CREATE TABLE Invoice(
	AdminID char(6) FOREIGN KEY REFERENCES Admin_(AdminID),
	Date_ date not null,
	Product2ID varchar(8) FOREIGN KEY REFERENCES Product2(Product2ID),
	Quantity tinyint not null,
	PriceProduct money not null,
	primary key(AdminID, Product2ID),
);

INSERT INTO Invoice VALUES
('Admin5', '2023/07/16', '27HTG7RS','1', 555000),
('Admin5', '2022/05/03', '3GQUDC4L','1', 475000),
('Admin5', '2022/06/11', '3RGZOCWS','2', 45000),
('Admin5', '2023/12/13', '4MIEX9PI','1', 5078000),
('Admin5', '2023/05/25', '7SHBED9G','1', 555000),
('Admin5', '2022/04/05', 'AX9WJ0WR','2', 6793000),
('Admin5', '2023/11/18', 'DGQUJ842','1', 1356000),
('Admin5', '2023/09/17', 'ECGM8JO6','1', 2201000),
('Admin5', '2023/01/01', 'EO09HHWR','1', 6911000),
('Admin5', '2022/05/21', 'HPUAT56N','2', 963000),
('Admin5', '2023/08/29', 'HQBLCSPK','1', 767000),
('Admin5', '2023/09/30', 'KOBHH5DM','2', 1374000),
('Admin5', '2023/09/19', 'Q6C4DFB1','1', 828000),
('Admin5', '2023/06/20', 'QLNPFLFG','2', 5200000),
('Admin5', '2023/06/19', 'QY37GM2N','1', 9853000),
('Admin5', '2023/03/15', 'VLQY2G6Q','1', 943000),
('Admin5', '2022/04/02', 'WEIV5N98','1', 2188000),
('Admin5', '2023/12/15', 'WZDHKRCO','1', 133000),
('Admin5', '2022/09/08', 'Z5LNUK07','2', 152000),
('Admin5', '2023/05/03', 'ZOBNRDTZ','1', 475000);


DELETE FROM Invoice;

CREATE TABLE Order_(
	Order_Date date not null,
	ExpectedDelivery date not null,
	Quantity smallint not null,
	CusID char(6) FOREIGN KEY REFERENCES Customers(CusID) not null ,
	Product1ID char(8) FOREIGN KEY REFERENCES Product1(Product1ID),
	DeliveryFee money not null,
	UnitPrice money not null,
	primary key(CusID, Product1ID),
);

INSERT INTO Order_ VALUES
('2022/07/16', '2022/07/21',2,'1RWA2T', '19MC554F', 25000, 4531000.0),
('2022/02/26', '2022/03/02',1,'5Q7ECR', '1JSHPEQ6', 25000, 26000.0),
('2023/12/21', '2023/12/26',1,'742P4O', '2J0R9261', 25000, 4912000.0),
('2022/11/19', '2022/11/24',2,'8C1EEB', '76SKQHWH', 25000, 97000.0),
('2023/09/04', '2023/09/09',1,'8YIODR', '7CRHTKNC', 25000, 407000.0),
('2022/08/04', '2022/08/09',2,'9OXD1K', '82RXAHHW', 25000, 467000.0),
('2023/05/29', '2023/06/03',1,'AYEW2P', 'BJW15BHE', 25000, 802000.0),
('2023/04/02', '2023/04/07',2,'BCXCKQ', 'LCXQZ9QM', 25000, 357000.0),
('2022/07/27', '2022/08/01',1,'BIKI33', 'MBCLUGKT', 25000, 322000.0),
('2023/11/18', '2023/11/23',1,'DP95G0', 'NRHMKH4P', 25000, 4826000.0),
('2022/05/21', '2022/05/26',2,'FCNS08', 'O7PIFA8Y', 25000, 169000.0),
('2023/05/12', '2023/05/17',2,'HXYIHA', 'P7LYN187', 25000, 381000.0),
('2023/03/12', '2023/03/17',2,'JNYN9Y', 'P916YQPU', 25000, 393000.0),
('2023/09/13', '2023/09/18',2,'L3R0DX', 'QVR55K90', 25000, 423000.0),
('2023/11/26', '2023/12/02',1,'LOOWTZ', 'R00GWJNZ', 25000, 256000.0),
('2023/12/21', '2023/12/26',2,'QEW2AY', 'RXEA6JZI', 25000, 9533000.0),
('2023/08/06', '2023/08/11',2,'RTEHL4', 'SOBH5UEB', 25000, 424000.0),
('2023/07/27', '2023/08/01',2,'S0G6V3', 'UFHFZOL3', 25000, 9458000.0),
('2022/05/12', '2022/05/17',2,'U147T3', 'XH8RLM0L', 25000, 678000.0),
('2022/12/19', '2022/12/24',1,'VZKI32', 'YLXO2NIA', 25000, 448000.0);

CREATE TABLE Search(
CusID char(6) not null foreign key references Customers(CusID),
Product1ID char(8) foreign key references Product1(Product1ID),
primary key(CusID, Product1ID)
);


