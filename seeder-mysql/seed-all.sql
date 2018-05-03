USE pawtify_db;
INSERT INTO cat_breeds(breed)VALUES
  ('American Shorthair'),
  ('American Wirehair'),
  ('Bengal'),
  ('Burmese'),
  ('Cornish Rex'),
  ('Devon Rex'),
  ('Domestic Longhair'),
  ('Domestic Shorthair'),
  ('Exotic'),
  ('Himalayan'),
  ('Persian'),
  ('Scottish Fold'),
  ('Siamese'),
  ('Sphynx');

INSERT INTO dog_breeds(breed)VALUES
  ('Beagle'),
  ('Bull Terrier'),
  ('Bulldog'),
  ('Collie'),
  ('Dalmatian'),
  ('German Shepherd'),
  ('Greyhound'),
  ('Labrador'),
  ('Papillion'),
  ('Pomeranian'),
  ('Pug'),
  ('Pit Bull'),
  ('Rottweiler'),
  ('Terrier'),
  ('Whippet'),
  ('Xoloitzcuintli'),
  ('Yorkshire Terrier');


INSERT INTO users(full_name, phone, username, email, password) VALUES
  ('emma dejong', '+13059008059', 'edejong', 'edejong@gmail.com','edejong'),
  ('laura prochaska', '+13059009059', 'lalepro', 'llprochaska@gmail.com', 'lalepro'),
  ('bettin trejo', '+13059008059', 'btrejo', 'btrejo@gmail.com', 'btrejo');

INSERT INTO rescue_shelter(name, address, phone, user_id) VALUES
  ('Animal Care Services', '4710 TX-151, San Antonio, TX 78227', '+12102074738', 1),
  ('San Antonio Humane Society', '4804 Fredericksburg Rd, San Antonio, TX 78229', '+12102267461', 2),
  ('Animal Defense League of Texas', '11300 Nacogdoches Rd, San Antonio, TX 78217', '+12106551481', 3);

INSERT INTO animals(name,age,gender,size,color,behavior,path ,rescueshelter_id,cat_breed_id,dog_breed_id)VALUES
  ('Teddy', 'less than a year', 'male', 'small', 'black', 'great with all animals, not kid friendly', 'https://images.pexels.com/photos/674570/pexels-photo-674570.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 1, 14, null),
  ('Annie', 'more than a year', 'female', 'small', 'brown', 'great with children but not good with other animals', 'https://images.pexels.com/photos/33492/cat-red-cute-mackerel.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 2, 8, null),
  ('Zoey', 'more than a year', 'female', 'large', 'black', 'great with children but not good with other animals', 'https://images.pexels.com/photos/247937/pexels-photo-247937.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 3, null, 3);

INSERT INTO pawtifications(age, gender,size,color,user_id,cat_breed_id,dog_breed_id) VALUES
  ('less than a year', 'female', 'Large', 'Black', 1, 1, null),
  ('more than a year', 'male', 'small', 'Brown', 2, null, 1),
  ('less than a year', 'female', 'Large', 'White', 3, 2, null);