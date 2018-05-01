USE pawtify_db;

INSERT INTO pawtifications(age, gender,size,color,user_id,cat_breed_id,dog_breed_id) VALUES
  ('less than a year', 'female', 'Large', 'Black', 1, 1, null),
  ('more than a year', 'male', 'small', 'Brown', 2, null, 1),
  ('less than a year', 'female', 'Large', 'White', 3, 2, null);


#   ('more than a year', 'male', 'medium', 'Brown', 4, null, 2),
#   ('less than a year', 'female', 'Large', 'Black', 5, 3, null),
#   ('more than a year', 'male', 'small', 'White', 6, null, 3);