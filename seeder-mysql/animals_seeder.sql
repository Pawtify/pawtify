USE pawtify_db;
INSERT INTO animals(name,age,gender,size,color,behavior,path ,rescueshelter_id,cat_breed_id,dog_breed_id)VALUES
  ('Lily', 'more than a year', 'female', 'large', 'brown', 'great with all animals and children', null, 1, null, 6),
  ('Ruffus', 'more than a year', 'male', 'medium', 'brown', 'great with children and dogs, chases cats', null, 2, null, 6),
  ('Maple', 'more than a year', 'female', 'small', 'brown', 'great with all animals and children', null, 3, 8, null),
  ('Teddy', 'more than a year', 'male', 'small', 'black', 'great with all animals, not kid friendly', null, 1, 14, null),
  ('Annie', 'more than a year', 'female', 'small', 'brown', 'great with children, not good with other animals', null, 2, 8, null),
  ('Zoey', 'more than a year', 'female', 'large', 'black', 'great with children, not good with other animals', null, 2, null, 3);