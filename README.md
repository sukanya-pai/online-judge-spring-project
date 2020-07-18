# online-judge-spring-project
To Develop Interviewbit like system where in user can register, login and answer a programming question based on his choice of programming language.

Currently the project includes:
- Registering User:
	1. Validate Email
	2. Validate Password
	3. Return appropriate Validation errors if field validation fails
	4. Check whether User with email ID exists in Database
	5. If user exists, throw UserAlreadyExists exception
	6. Else, proceed storing in database
