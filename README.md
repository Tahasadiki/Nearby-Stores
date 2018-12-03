![alt text](https://raw.githubusercontent.com/Tahasadiki/Nearby-Stores/dev/NearbyShopsAppPreview.png)
# Nearby Shops

The project is about implementing an app that lists shops nearby. 

- As a User, I can sign up using my email & password
- As a User, I can sign in using my email & password
- As a User, I can display the list of shops sorted by distance
- As a User, I can like a shop, so it can be added to my preferred shops
  - Acceptance criteria: liked shops shouldn’t be displayed on the main page
- As a User, I can dislike a shop, so it won’t be displayed within “Nearby Shops” list during the next 2 hours
- As a User, I can display the list of preferred shops
- As a User, I can remove a shop from my preferred shops list

## Architecture

![alt text](https://raw.githubusercontent.com/TahaSadiki/Nearby-Stores/master/Architecture.PNG)

## Technical spec

* PostgreSQL
* Java + spring boot + thymeleaf  

## Deployment

* Create "NearbyShops" database 
* Configure ports as well as username and password to access the created database
* Launch shopService (default port = 9001)
* launch UserService (default port = 9002)

## Front-end

I used the [MaterialKit](https://www.creative-tim.com/product/material-kit) template to get up and running quicly

## TomTom search API

[TomTom](https://developer.tomtom.com/) provides developpers, throught there search API, with list of places based on the passed location and keywords.
For our project the keyword used is "shop"


## Features

- [x] As a User, I can sign up using my email & password
- [x] As a User, I can sign in using my email & password
- [x] As a User, I can display the list of shops sorted by distance
- [x] As a User, I can like a shop, so it can be added to my preferred shops
  - [x] Acceptance criteria: liked shops shouldn’t be displayed on the main page
- [x] As a User, I can dislike a shop, so it won’t be displayed within “Nearby Shops” list during the next 2 hours
- [x] As a User, I can display the list of preferred shops
- [x] As a User, I can remove a shop from my preferred shops list


## To do

- [ ] As a User, I can filter results by shop categories
- [ ] As a User, I can add more keywords to search
- [ ] Configure Eureka server to manage the microservices

## Notes

