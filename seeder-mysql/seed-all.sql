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

-- INSERT INTO animals(name,age,gender,size,color,behavior,path ,rescueshelter_id,cat_breed_id,dog_breed_id)VALUES
--   ('Lily', 'more than a year', 'female', 'large', 'brown', 'great with all animals and children', null, 1, null, 6),
--   ('Ruffus', 'more than a year', 'male', 'medium', 'brown', 'great with children and dogs, chases cats', null, 2, null, 6),
--   ('Maple', 'more than a year', 'female', 'small', 'brown', 'great with all animals and children', null, 3, 8, null),
--   ('Teddy', 'more than a year', 'male', 'small', 'black', 'great with all animals, not kid friendly', null, 1, 14, null),
--   ('Annie', 'more than a year', 'female', 'small', 'brown', 'great with children, not good with other animals', null, 2, 8, null),
--   ('Zoey', 'more than a year', 'female', 'large', 'black', 'great with children, not good with other animals', null, 2, null, 3);
  
  INSERT INTO animals(name,age,gender,size,color,behavior,path ,rescueshelter_id,cat_breed_id,dog_breed_id)VALUES
  ('Lily', 'more than a year', 'female', 'large', 'brown', 'great with all animals and children', 'https://images.pexels.com/photos/356378/pexels-photo-356378.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 1, null, 6),
  ('Ruffus', 'more than a year', 'male', 'medium', 'brown', 'great with children and dogs, chases cats', 'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg?auto=compress&cs=tinysrgb&h=650&w=940', 2, null, 6),
  ('Maple', 'more than a year', 'female', 'small', 'brown', 'great with all animals and children', 'https://images.pexels.com/photos/615369/pexels-photo-615369.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 3, 8, null),
  ('Teddy', 'more than a year', 'male', 'small', 'black', 'great with all animals, not kid friendly', 'https://images.pexels.com/photos/674570/pexels-photo-674570.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 1, 14, null),
  ('Annie', 'more than a year', 'female', 'small', 'brown', 'great with children, not good with other animals', 'https://images.pexels.com/photos/33492/cat-red-cute-mackerel.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 2, 8, null),
  ('Zoey', 'more than a year', 'female', 'large', 'black', 'great with children, not good with other animals', 'https://images.pexels.com/photos/247937/pexels-photo-247937.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 2, null, 3);

INSERT INTO pawtifications(age, gender,size,color,user_id,cat_breed_id,dog_breed_id) VALUES
  ('less than a year', 'female', 'Large', 'Black', 1, 1, null),
  ('more than a year', 'male', 'small', 'Brown', 2, null, 1),
  ('less than a year', 'female', 'Large', 'White', 3, 2, null);