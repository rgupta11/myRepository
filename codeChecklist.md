### Authors Checklist
#### Authors, or developers of the Pull Request can use this checklist before submitting a pull request:

- [ ]  Commit title and description are well written and tagged to JIRA ticket number as applicable.
 
- [ ] My code compiles (if applicable to the language).
 
- [ ] My code has been developer-tested and includes unit tests.
 
- [ ] My code is tidy and well formatted(indentation, line length, no commented-out code, no spelling mistakes, location of braces, method/class/function names, comments etc).
 
- [ ] The code follows the coding standards/conventions.
 
- [ ] My code contains comments wherever needed to describe the intent of the code.

- [ ] My code does not have any commented code.

- [ ] If there are TODOs in my code then they have associated JIRA issues.
 
- [ ] My code is as modular as possible.
 
- [ ] I have considered proper use of exceptions as well as NPEs.
 
- [ ] I have made appropriate use of logging, and removed debug code except in debug logs wherever appropriate.
  
- [ ] I have eliminated unused imports and "*" imports.
 
- [ ] I have eliminated the warnings shown by IDE.
 
- [ ] My code does not contain stubs or test routines outside the unit test code.
 
- [ ] My code does not contain any hardcoded configuration parameter values that do not belong to the code and must be moved to appropriate configuration files.
 
- [ ] My code does not have any redundant or duplicate code.
 
- [ ] I have used library functions instead of rewriting same logic wherever applicable.
 
- [ ] I have considered runtime performance by applying Big-O complexity.
 
- [ ] I have considered security implications of the code.
 
- [ ] My code releases resources appropriately. (HTTP connections, DB connection, files, etc).
 
- [ ] Corner cases well documented or any workaround for a known limitation of the frameworks.
 
- [ ] My code has handled invalid parameter values.
 
- [ ] Thread safety and possible deadlocks were considered and handle wherever applicable.
 
- [ ] My code is testable.(i.e. don’t add too many or hide dependencies, unable to initialize objects, test frameworks can use methods etc.)

- [ ] I have added comprehensive unit test and overall test coverage has not reduced below 85%.
 
- [ ] My unit tests actually test that the code is performing the intended functionality.

- [ ] There are no extra spaces at the end of a statement and unnecessary new lines at the end of the line.

 
### Reviewers Checklist

- [ ] The functionality fits the current design/architecture | 
 
- [ ] Meets requirements or the acceptance criteria of JIRA story/task being implemented | 
 
- [ ] Exceptions have been used appropriately | 
 
- [ ] Libraries/Frameworks have been used appropriately – methods have all been defined appropriately (SpringBoot, junit etc)	| 

- [ ] The code complies to coding standards | 
 
- [ ] Logging used appropriately (proper logging level and details) | 
 
- [ ] Common errors have been checked for | 
 
- [ ] Types have been generalized where possible | 
 
- [ ] Parameterized types have been used appropriately | 
 
- [ ] Potential threading issues have been eliminated where possible | 
 
- [ ] The code does not use unjustifiable static methods/blocks | 

- [ ] Comments are comprehensible and add something to the maintainability of the code | 
 
- [ ] Comments are neither too numerous nor verbose | 
 
- [ ] The code is unit testable, and appropriate unit tests have been submitted in the PR | 
 
- [ ] Excessive mocking in unit tests is not used | 
 
- [ ] Code coverage is well maintained | 
 
- [ ] Any security concerns have been addressed | 
 
- [ ] Performance was considered. | 
