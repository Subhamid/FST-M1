# In this activity, we will be modifying the salesman table.

# Add a new column - grade - to the salesman table. The grade will be integer values.
  #  Set the value in the grade column for everyone to 100.
  #  Use SELECT command to display the results.
  
  Alter table salesman ADD grade int;
  update salesman set grade=100;
  Select * from saleman;
  
  
  -- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE city='Rome';

-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade=300 WHERE name='James Hoog';

-- Update the name McLyon to Pierre.
UPDATE salesman SET name='Pierre' WHERE name='McLyon';



