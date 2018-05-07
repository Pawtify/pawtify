# Feature List

### *PLANNED FEATURES*
##### 1. Matching DB Tables - build logic that will match columns in two tables and create the event that sets Twilio in motion
- [ ] build method that matches the animal and the pawtification tables
- [ ] research Twilio API and implement text message feature that sends the user a link (or the information) for the animal the matched with
##### 2. Register Animal Form - RS users will be able to fill out a form including location, name, animal type, breed, age, gender, size, color, checkbox if animal is “good in a home with..”, and upload a picture of the pet
- [X] create rs-form.html that adds animals entered in that form to the animals table of that database
- [X] add picture upload to animal profile from this form
##### 3. Notify Form - PA users can insert information (Animal type, breed, age, gender, size, and color) to be notified of an animal
- [X] add main PA notification form that drops up and down when you click the buttons on that view
##### 4. Edit/Delete - RS users will be able to edit the information of the form, with information already filled in. RS user can delete animal from rs-form.html page
- [X] add update/edit animals functionality for the RS user on their form
- [ ] "recent additions" column on the rs-form.html view that populates in case you need to quickly edit something they just entered
- [ ] RS users can edit their user information
##### 5. Edit/Delete - PA users can update and delete notification forms 
- [ ] add edit user info functionality
- [X] add edit/delete pawtifications functionality
- [X] listed view of all pawtifications for that user to view
##### 6. Form Validation
- [X] security for page URLs
- [X] add register form validation logic for both PA and RS & error messages
- [X] add login form validation logic for both PA and RS & error messages
- [X] add PA desired animal traits entry form validation logic and error messages
##### 7. Landing Page - create home page that allows users to login/register as a PA or RS, gives some clear info on purpose of Pawtify, and gives Guests an option to browse through already available pets
- [X] purpose clear home page
- [X] About page that compliments the landing/home page
- [ ] add video to background
#### 8. Mobile Responsive Site - make all pages mobile responsive
- [ ] dynamic pages that can be used and viewed on a phone
##### 9. Navbar (can we split some of navbar options up with a footer?)
- [X] create a mobile friendly (w/ drop down on mobile), dynamic navbar for being logged in and a view for being logged out (might differ by page)
##### 10. Animal Card - Card will show animal picture with name and age. Click on animal card to be taken to individual animal page (show.html) to see more information about specific animal.
- [ ] add animal card to PA index page that updates when new animals are entered into the db and is filter/searchable from the PA index page
- [ ] add animal card to RS index page with more information for RS (see Laura's example) that updates as soon as new animals are entered and is filter/searchable
##### 11. Filter & Search Options - PA users will be able to filter the list of animals by animal type, breed, age, and gender.
- [ ] add filter options to for animal type, gender and age
- [ ] add search box and functionality for all other traits
- [ ] add filter functionality to RS index
 
### *WISH LIST FEATURES*
##### 11. Event listener pop out for notification
- [ ] add an event listener pop up on the bottom right hand of the screen (how do we do this on mobile?) that asks the user if they can't find what they're looking for and want to make a notification
#### 12. File Stack API - implement File Stack API for quicker animal uploads
- [ ] implement File Stack API so that the RS staff can upload pictures of animals easily with a mobile device
##### 12. Favorite Animals - “favorite” animals by clicking a heart which will then add it to a list of all animals you have favorited to keep track if they are still adoptable over time
- [ ] able to favorite the animal
- [ ] page or places on existing page that allows user to view all their favorited animals
##### 13. Contact the shelter - user can click on ‘send a message to us’ and they can fill out a form that sends an email to shelter employees asking more info about the animal
- [ ] add contact the shelter to the show animal page where the name and address are listed 
- [ ] link that pop up an email form with the shelter email already populated for them?
##### 14. Share an Animal on social media - Feature that lets you share the post with Facebook and Twitter
- [ ] add the the show animal page
- [ ] opens social media pop up thing to post and share directly to facebook or twitter