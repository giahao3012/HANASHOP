
IF EXISTS (Select * from sys.databases where name='hanaShopManagement')
	drop database hanaShopManagement
go

create database hanaShopManagement
Use hanaShopManagement

CREATE TABLE AccountTBL(
	username varchar(50) PRIMARY KEY,
	password varchar(50) DEFAULT '123456',
	lastname varchar(50),
	email varchar(50) UNIQUE,
	role varchar(50),
	isStillWorking bit DEFAULT 1,
)
CREATE TABLE productCategoryTBL(
    productCategoryID varchar(10) PRIMARY KEY,
	name varchar(200),
)
CREATE TABLE productTBL
(
    productID varchar(10) PRIMARY KEY,
	productName varchar(200),
	productImg varchar(200),
	description varchar(4000),
	price decimal(18,2),
	quantity int,
	dateOfCreate datetime DEFAULT GETDATE(),
	publishingCompany varchar(400),
	productCategoryID varchar(10) FOREIGN KEY REFERENCES productCategoryTBL(productCategoryID),
	isDisable bit DEFAULT 0,
	stillProducting bit DEFAULT 1,
)
--CREATE TABLE OrderTBL(
--    orderID varchar(100) PRIMARY KEY,
--	order_by varchar(50) FOREIGN KEY REFERENCES AccountTBL(username),
--	paymentMethod varchar(50),
--	shipAddress nvarchar(500),
--	total decimal(18,2),
--	phone varchar(50),
--	order_date datetime DEFAULT GETDATE(),
--)
--CREATE TABLE OrderDetailTBL(
--    orderDetailID varchar(100) PRIMARY KEY,
--    orderID varchar(100) FOREIGN KEY REFERENCES OrderTBL(orderID),
--	productID varchar(10) FOREIGN KEY REFERENCES productTBL(productID),
--	quantity int, 
--	price decimal(18,2), 
--)

CREATE TABLE OrderTBL(
orderID int PRIMARY KEY,
username varchar(50) FOREIGN KEY REFERENCES AccountTBL(username),
paymentMethod varchar(50),
shipAddress nvarchar(500),
total decimal(18,2),
DateOrder datetime DEFAULT GETDATE()
)

CREATE TABLE OrderDetailTBL(
orderID int FOREIGN KEY REFERENCES OrderTBL(orderID),
productID varchar(10) FOREIGN KEY REFERENCES productTBL(productID),
Quantity int,
price decimal(18,2)
)

Insert into productCategoryTBL values('F','Foods')
Insert into productCategoryTBL values('D','Drinks')

Insert into productTBL values('F1','Bruschetta','https://www.inspiredtaste.net/wp-content/uploads/2016/07/Bruschetta-Recipe-2-1200.jpg','Come from Italy consisting of grilled bread rubbed with garlic and topped with olive oil and salt. Variations may include toppings of tomato, vegetables, beans, cured meat, or cheese. A popular dish is bruschetta with tomatoes; one recipe popular outside Italy involves basil, fresh tomato, garlic and onion or mozzarella. Bruschetta is usually served as a snack or appetizer. In some countries, the prepared topping is marketed as bruschetta.',88,100,'5/1/2021','Italia','F',0,1)
Insert into productTBL values('F2','Carbonnade Flamande','https://recette.supertoinette.com/151405/m/carbonade-flamande.jpg','Carbonade flamande, also spelled carbonnade[1][2] or called à la flamande[3] (in Dutch stoverij or stoofvlees) is a Flemish beef (or pork) and onion stew popular in Belgium and French Flanders, made with beer, thyme, juniper berries, mustard and spiced bread. In French, a carbon(n)ade may also be a dish of grilled pork loin and certain beef stews cooked with red wine such as beef bourguignon in the east of France,but in English, carbonnade is generally the Belgian dish. The dish is occasionally called Flemish stew, but that is a generic term, also used for waterzooi, hochepot, and so on.',126,100,'6/1/2021','Belgium','F',0,1)
Insert into productTBL values('F3','Carbonara','https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Espaguetis_carbonara.jpg/1200px-Espaguetis_carbonara.jpg','Carbonara (Italian: [karboˈnaːra]) is an Italian pasta dish from Rome made with egg, hard cheese, cured pork, and black pepper. The dish arrived at its modern form, with its current name, in the middle of the 20th century.',29,100,'6/1/2021','Italia','F',0,1)
Insert into productTBL values('F4','Wiener Schnitzel','https://www.thespruceeats.com/thmb/LeyN-7W9T0KB2nl6pcuDZckHnjc=/4288x2848/filters:fill(auto,1)/wiener-schnitzel-recipe-1447089-Hero-5b587d6c46e0fb0071b0059d.jpg','Wiener schnitzel (sometimes spelled wiener schnitzel, which translates to "Viennese cutlet" in German) is one of Austria most traditional and representative dishes. So much so, in fact, that its definition is fiercely protected by Austrian law. It must be made of veal; when made with any other type of meat, it cannot technically be called wiener schnitzel.',89,100,'6/1/2021','Vienna','F',0,1)
Insert into productTBL values('F5','Rosti','https://www.telegraph.co.uk/content/dam/recipes/2020/05/27/TELEMMGLPICT000231074571_trans_NvBQzQNjv4BqpVlberWd9EgFPZtcLiMQfyf2A9a6I9YchsjMeADBa08.jpeg','Rösti or rööschti (Alemannic German: [ˈrøːʃti]) is a Swiss dish consisting mainly of potatoes, in the style of a fritter. It was originally a breakfast dish, commonly eaten by farmers in the canton of Bern, but is now eaten all over Switzerland and around the world. The French name röstis bernois makes direct reference to the origins of the dish.',88,100,'5/1/2021','Switzerland','F',0,1)
Insert into productTBL values('D1','Fernet','https://images.food52.com/-TJwukxula6mjpX8jp-B_l43Vg4=/1200x900/92dc91ef-a1ae-4e71-ac3d-56b33975a04a--2019-1206_fernet-coke_3x2_rocky-luten_041.jpg','Fernet (Italian pronunciation: [ferˈnɛt]) is an Italian type of amaro, a bitter, aromatic spirit. Fernet is made from a number of herbs and spices which vary according to the brand, but usually include myrrh, rhubarb, chamomile, cardamom, aloe, and especially saffron,[1] with a base of grape distilled spirits.',88,100,'6/1/2021','Argentina','D',0,1)
Insert into productTBL values('D2','Tequila','https://inm-baobab-prod-eu-west-1.s3.amazonaws.com/public/inm/media/image/98231385.JPG','Tequila is a distilled beverage made from the blue agave plant, primarily in the area surrounding the city of Tequila 65 km northwest of Guadalajara, and in the Jaliscan Highlands of the central western Mexican state of Jalisco.',28,100,'5/1/2021','Mexico','D',0,1)
Insert into productTBL values('D3','Single Malt Whisky','https://cdn.thegentlemansjournal.com/wp-content/uploads/2016/11/whisky3-664x442-c-center.jpg','Single malt whisky is malt whisky from a single distillery. Single malts are typically associated with single malt Scotch, though they are also produced in various other countries.',18,100,'7/1/2021','Scotch','D',0,1)
Insert into productTBL values('D4','Pastis','https://i0.wp.com/www.sippitysup.com/wp-content/uploads/2016/09/PastisTEXT.jpg?fit=600%2C900&ssl=1','Pastis (French pronunciation: ​[pastis]; Occitan: Pastís, pronounced [pasˈtis]; UK: /ˈpæstɪs/ or US: /pæsˈtiːs/) is an anise-flavoured spirit and apéritif traditionally from France, typically containing less than 100 g/l sugar and 40–45% ABV (alcohol by volume)',12,100,'8/1/2021','Unistate','D',0,1)
Insert into productTBL values('D7','BTS','https://ibighit.com/bts/images/bts/profile/profile-kv-m.png','hahahaha',12,100,'1/10/2021','Unistate','D',0,1)


Insert into AccountTBL values('haohao','123456','Cao Gia Hao','hah@gmail.com','admin',1)
Insert into AccountTBL values('hihi','123456','Nguyen Van A','hih@gmail.com','user',0)

Select * from productTBL
where productCategoryID='F'
Select * from productCategoryTBL
Select * from productTBL
where productID='F1'

Select username,password
from AccountTBL

Update productTBL set
productName='',
productImg='',
description='',
price=0,
dateOfCreate='',
publishingCompany='',
productCategoryID='',
isDisable=0,
stillProducting=1 where productID=''

select count(*) from productTBL
where productCategoryID='F' AND isDisable=0 

Select * from productTBL
order by dateOfCreate DESC
OFFSET 0 ROWS
FETCH FIRST 5 ROWS ONLY;

Select * from productTBL
where productCategoryID='F' AND isDisable=0 
order by dateOfCreate DESC
OFFSET 0 ROWS
FETCH FIRST 6 ROWS ONLY;

delete from OrderTBL
where username='lalala'

Update productTBL set quantity = 100 Where productID ='F1'

Select p.productName as NameP,p.price as PriceP, od.Quantity as QuantityP, o.DateOrder as Date From OrderTBL as o, OrderDetailTBL as od , productTBL as p , AccountTBL as ac
       Where o.orderID = od.orderID and o.username like 'lalala' and p.productID = od.productID and o.username = ac.username

Select p.productName as NameP,p.price as PriceP, od.Quantity as QuantityP, o.DateOrder as Date From OrderTBL as o, OrderDetailTBL as od ,productTBL as p, AccountTBL as ac
                  Where o.orderID = od.orderID and o.username like 'lalala' and p.productID = od.productID and o.username = ac.username and p.productName like ''

Select p.productName as NameP,p.price as PriceP, od.Quantity as QuantityP, o.DateOrder as Date
                    From OrderTBL as o, OrderDetailTBL as od , productTBL as p , AccountTBL as ac
                    Where o.orderID = od.orderID and o.username like ? and p.productID = od.productID and o.username = ac.username
                    and o.DateOrder BETWEEN ? AND ?

select * from AccountTBL
where username='GiaHao'

Insert into productTBL values('F11','Pizzaaa','pizza.png','hahahaha',12,100,'1/21/2021','Unistate','F',0,1)