# property
Project for Spring Boot Rest API with authorization

#Configuration
* Port: 8080
* DatabaseName: property_db
* Connection username=root 
* Connection password=root

--- 

* Framework : Java Spring boot 2.5.0-M3
* Database : mysql 5.x 
* ORM tool : Hibernate With JPA

# API Collection
### Create property API

URL: localhost:8080/create-property

---
Header: 
* APIKey:ValidApiKeyFromDB
* Content-Type:application/json

Body(Row): 
* {
  "name": "property Name",
  "address": "Property Address",
  "approved": false,
  "ownerName": "Property Owner Name",
  "city": "City Name"
}

---

Response:
* SUCCESS: {
	    "status": <Response Code>,
	    "data": "<value of saved property as Json>",
	    "message": "<Success/Internal Error>"
	}

---

### Update property API

URL: localhost:8080/update-property

---
Header: 
* APIKey:ValidApiKeyFromDB
* Content-Type:application/json

Body(Row): 
* {
  "id":1
  "name": "property Name",
  "address": "Property Address",
  "approved": false,
  "ownerName": "Property Owner Name",
  "city": "City Name"
}

---

Response:
* SUCCESS: {
	    "status": <Response Code>,
	    "data": "<value of updated property as Json>",
	    "message": "<Success/Internal Error>"
	}
	
---

### Approve property API

URL: localhost:8080/approve-property

---
Header: 
* APIKey:ValidApiKeyFromDB

Param:
* id=1

---

Response:
* SUCCESS: {
	    "status": 200,
	    "message": "<Approved/Not Approved>"
	}

---

### Search property API

URL: localhost:8080/search-property

---

Header: 
* APIKey:ValidApiKeyFromDB
* Content-Type:application/json

Body(Row): 
* {
  "id":1
  "name": "property Name To Search",
  "address": "Property Address To Search",
  "approved": false, // To Search
  "ownerName": "Property Owner Name To Search",
  "city": "City Name To Search"
}

---

Response:
* SUCCESS: {
    "status": 200,
    "data": "<Json Array of Filtered data>",
    "message": "Success"
}

### In case of Unauthorized Access Response will be
* Unauthorized: {
    "timestamp": "<Current Time>",
    "status": 401,
    "error": "Unauthorized",
    "message": "<Reason>",
    "path": "<requested path>"
}

###property
Below fields are defined for property :

* Long id;	
* String name;
* String address;
* String ownerName;
* String city;
* Boolean approved;
 
