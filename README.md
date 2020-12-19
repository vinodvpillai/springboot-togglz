# Spring boot and Togglz

The Togglz library provides an implementation of the Feature Toggles design pattern. 

This pattern refers to having a mechanism that allows determining during the runtime of an application whether a certain feature is enabled or not based on a toggle.

Disabling a feature at runtime may be useful in a variety of situations such as working on a new feature which is not yet complete, wanting to allow access to a feature only to a subset of users or running A/B testing.

In the following sections, we will create an aspect that intercepts methods with an annotation that provides a feature name, and determine whether to continue executing the methods depending on if the feature is enabled or not.

##
### Prerequisites
- JDK 1.8
- Maven

## Quick Start

### Clone source
```
git clone https://github.com/vinodvpillai/springboot-togglz.git
cd springboot-togglz
```

### Build
```
mvn clean package
```

### Run
```
java -jar target/springboot-togglz.jar
```

### Endpoint details:

##### 1. Add new employee (CURL Request):

```
POST /employees HTTP/1.1
Host: localhost:8081
Content-Type: application/json
cache-control: no-cache
Postman-Token: ad9c6d5d-7fd4-45f6-bc36-374d7f68cee5
{
	"firstName":"Vinod",
	"lastName":"Pillai",
	"emailId":"vinod@yopmail.com",
	"password":"vinod"
}------WebKitFormBoundary7MA4YWxkTrZu0gW--
```

##### 2. Get employee details by ID (CURL Request):

```
GET /employees/5 HTTP/1.1
Host: localhost:8081
cache-control: no-cache
Postman-Token: 608e34ab-0d7f-4bca-9443-21f1897d7202
```

##### 3. Delete employee by ID (CURL Request):

```
DELETE /employees/5 HTTP/1.1
Host: localhost:8081
cache-control: no-cache
Postman-Token: b18ef76a-ab31-43d5-afae-2303e8633727
```