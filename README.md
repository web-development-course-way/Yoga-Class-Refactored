# About
- Backend application demo using Spring Boot
- Application to manage Yoga classes
- Refactored of [old version](https://github.com/web-development-course-way/Yoga-Class)
# Tech Stack
- Docker
- PostgreSQL & pgAdmin 
- Java & Spring boot
# Installation
01. Clone Repository and open project in IDE
02. [Set up database](https://github.com/web-development-course-way/Yoga-Class-Refactored/tree/enhancement/docs?tab=readme-ov-file#setting-up-database)
03. Run application
## Setting up database
01. Run Docker
02. Run Docker compose using following command `docker compose up` from the root of the project
03. Open [pgAdmin](http://localhost:5050/browser/)
04. Set master password for pgAdmin
05. Add a new server in pgAdmin:
    - Set server name in general tab
    - Set Host name/address in connection tab (get the address using command `docker inspect postgres_container | grep IPAddress`)
    - Set username = `mustafa` & password = `123456789` in connection tab
06. Create database with name `yoga-class-app`
# API Documentation
1. Open [Swagger](http://localhost:8080/swagger-ui/index.html#) to test CRUD operations
2. [Create operation](https://github.com/web-development-course-way/Yoga-Class-Refactored/tree/enhancement/docs?tab=readme-ov-file#creating)
3. [Read operation](https://github.com/web-development-course-way/Yoga-Class-Refactored/tree/enhancement/docs?tab=readme-ov-file#reading)
4. [Update operation](https://github.com/web-development-course-way/Yoga-Class-Refactored/tree/enhancement/docs?tab=readme-ov-file#updating)
5. [Delete operation](https://github.com/web-development-course-way/Yoga-Class-Refactored/tree/enhancement/docs?tab=readme-ov-file#deleting)
## Creating
- **Enter body in POST request then execute**

![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/a6b97af7-7dac-4bb8-88eb-396435017095)

- **Sample #1 Body**
```
{
    "firstName": "Ahmad",
    "lastName": "Al-Deeb",
    "phone": "01211223344",
    "email": "ahmad@yahoo.com",
    "nationality": "Egyptian",
    "dateOfBirth": "2012-12-12",
    "role": "STUDENT"
}
```
- **Expected Response for Sample #1**
  
![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/fe069e7c-4bec-4638-be57-6a9f2c4ecfab)


- **Sample #2 Body**
```
{
    "firstName": "Andrew",
    "lastName": "Seif",
    "phone": "01266778899",
    "email": "andrew@gmail.com",
    "nationality": "Egyptian",
    "dateOfBirth": "2000-01-10",
    "role": "INSTRUCTOR"
}
```
- **Expected Response for Sample #2**
  
![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/97109417-2828-440e-bd65-7737dcfd9e3e)


- **View results in database using below query in pgAdmin**
```
SELECT id, first_name, last_name, role, email, phone, date_of_birth, nationality, created_by, created_date, last_modified_by, last_modified_date
FROM public.yoga_user;
```
| id                                  | first_name | last_name | role       | email            | phone       | date_of_birth         | nationality | created_by | created_date                 | last_modified_by | last_modified_date          |
|-------------------------------------|------------|-----------|------------|------------------|-------------|-----------------------|-------------|------------|------------------------------|------------------|-----------------------------|
| c65d94c8-0646-4803-98d6-dffdf122c824 | Ahmad      | Al-Deeb   | STUDENT    | ahmad@yahoo.com | 01211223344| 2012-12-12 02:00:00   | Egyptian    | Test User  | 2024-04-05 11:51:35.289056 | Test User        | 2024-04-05 11:51:35.289056 |
| 914a4c5d-9916-4a07-a626-edc35dcc1226 | Andrew     | Seif      | INSTRUCTOR | andrew@gmail.com| 01266778899| 2000-01-10 02:00:00   | Egyptian    | Test User  | 2024-04-05 11:52:17.970292 | Test User        | 2024-04-05 11:52:17.970292 |




## Reading
### Reading One Uesr
- **Copy one user's id and use it to execute GET request**
  
![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/b793848e-d710-4b8c-9a9b-589c23f275a2)

- **Expected Response**

![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/39268147-a119-4a52-acbd-ffca685979cd)


### Reading All Users
- **Just execute GET request**
  
![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/40df490c-bfe6-4bc3-aa8c-793ed106deea)


- **Expected Response**

![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/d33d77b6-4317-4cd3-a582-2d863514eee2)

## Updating
- **Copy one user's id and use it to execute PUT request**
- **Updating `lastName` & `Role` fields**
```
{
    "lastName": "Deeb",
    "role": "INSTRUCTOR"
}
```
![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/d1ad9eb4-f4b6-4f0f-8d88-1d1a69aa0eeb)

- **Expected Response**

![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/b26c9b07-a7c8-4da5-9ca6-783acabac0c5)


- **View results in database using below query in pgAdmin**
```
SELECT id, first_name, last_name, role, email, phone, date_of_birth, nationality, created_by, created_date, last_modified_by, last_modified_date
FROM public.yoga_user;
```
| id                                  | first_name | last_name | role       | email            | phone       | date_of_birth         | nationality | created_by | created_date                 | last_modified_by | last_modified_date          |
|-------------------------------------|------------|-----------|------------|------------------|-------------|-----------------------|-------------|------------|------------------------------|------------------|-----------------------------|
| 914a4c5d-9916-4a07-a626-edc35dcc1226 | Andrew     | Seif      | INSTRUCTOR | andrew@gmail.com| 01266778899| 2000-01-10 02:00:00   | Egyptian    | Test User  | 2024-04-05 11:52:17.970292 | Test User        | 2024-04-05 11:52:17.970292 |
| c65d94c8-0646-4803-98d6-dffdf122c824 | Ahmad      | Deeb      | INSTRUCTOR | ahmad@yahoo.com | 01211223344| 2012-12-12 02:00:00   | Egyptian    | Test User  | 2024-04-05 11:51:35.289056 | Test User        | 2024-04-05 11:56:21.676482 |





## Deleting
- **Copy one user's id and use it to execute DELETE request**

![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/2fc5d600-114d-4383-91f4-54d3f523c503)

- **Expected Response**

![image](https://github.com/web-development-course-way/Yoga-Class-Refactored/assets/122436546/a60fe906-e54d-4563-9009-268ddac2933e)

- **View results in database using below query in pgAdmin**
```
SELECT id, first_name, last_name, role, email, phone, date_of_birth, nationality, created_by, created_date, last_modified_by, last_modified_date
FROM public.yoga_user;
```
  
| id                                  | first_name | last_name | role       | email            | phone       | date_of_birth         | nationality | created_by | created_date                 | last_modified_by | last_modified_date          |
|-------------------------------------|------------|-----------|------------|------------------|-------------|-----------------------|-------------|------------|------------------------------|------------------|-----------------------------|
| 914a4c5d-9916-4a07-a626-edc35dcc1226 | Andrew     | Seif      | INSTRUCTOR | andrew@gmail.com| 01266778899| 2000-01-10 02:00:00   | Egyptian    | Test User  | 2024-04-05 11:52:17.970292 | Test User        | 2024-04-05 11:52:17.970292 |
