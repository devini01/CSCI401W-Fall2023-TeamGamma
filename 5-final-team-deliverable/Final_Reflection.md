# Software Engineering Class Final Reflection

## Table of Contents

- [Product Vision](#product-vision)
- [Learning and Growth Journey](#learning-and-growth-journey)
  - [Reflection](#reflection)
- [Product Showcase](#product-showcase)
  - [Elevator Pitch](#elevator-pitch)
  - [Product Demo](#product-demo)
  - [Technical Architecture Overview](#technical-architecture-overview)
  - [Codebase Exploration](#codebase-exploration)
  - [Access Your Work](#access-your-work)
- [Final Reflection Presentation](#final-reflection-presentation)
- [Career Readiness Assessment](#career-readiness-assessment)

## Product Vision

- **Product Vision Statement:** For sneaker enthusiasts seeking a chance to buy their desired pair of shoes. Our app distinguishes its self by offering users an opportunity to engage in fair and exciting raffles. While the app currently focuses on providing users with a user-friendly experience and access to exclusive sneaker releases, our vision includes future enhancements to implement advanced bot detection mechanisms. We aspire to continuously evolve Sole Seeker, ensuring a level playing field for all users by preventing automated entries in our raffle system.


## Learning and Growth Journey

### Reflection

Reflect on your journey in learning software engineering through concrete scenarios:

1. **Team Collaboration Approach:**
   Describe how your team used tools like Slack and Trello to coordinate tasks. Share an example of how assigning tasks in Trello helped streamline your group projects and fostered effective communication.
    - **Devin:** Utilized Microsoft Teams to coordinate and meet with one another throughout the entire semester. It allowed us to also share information like helpful YouTube videos to assist with issues we had or if we did not know where to start.
    - Used Trello to delegate tasks to team members and provide each other with a better understanding of our progress throughout the semester.
    - Took advantage of GitHub's features and shared/expanded upon each other's code throughout the semester to work off of one another.
    - **Chayenne:** We used Trello to help keep everyone on the same page about what was to be worked on during a specific timeframe. We also used it for individual assignments which helped with dividing the work and avoiding too much overlap.
    - **Alixson:** With our team consisting of 5 people, it was hard to coordinate a time when all of us could meet and discuss what our next steps were going to be. Trello helped us keep track of who was working on what and it helped everyone take accountability for their portions of the workload.

2. **Challenges and Overcoming Them:**
   Recall a specific challenge, like debugging a code issue together. Explain how you collaborated to identify the bug's source and successfully resolved it. This experience showcases your problem-solving and teamwork skills.
    - **Devin:** When it came to the later part of the semester, there were many cases of us all getting onto teams and having meetings about the best way to merge. We would work through the errors that came up, like our raffle system not working with the payment screen together.
    - **Chayenne:** A challenge we faced was deciding on how we wanted certain features to function exactly (ex. raffle system). There were many things/restrictions to consider. Luckily we were able to meet frequently to clarify things which helped with productivity.
    - **Alixson:** My biggest challenge I would say was towards the last couple weeks of class I wanted to have a way we could navigate from one screen to the next with a simple click of a button. We had an idea of how we wanted to implement that feature but it did not work like we wanted it to. We had to quickly come together and find another way to implement that feature. We got lucky and figured it out just in time

3. **Accomplishments and Pride:**
   Highlight a feature you contributed to, such as creating a login system. Discuss how your combined skills enabled the team to deliver a functional feature that enhances user experience.
   - **Devin:** Working together we were able to create a login system. The UI aspect and part of the functionality was done by Chayenne and the authentication to Firebase was done by me, so a user would have a successful and secure login.
   - **Chayenne:** I was able to come up with a raffle example for us to go off of. Devin and I were able to work together to get the raffle system from the example integrated into our project.
   - **Alixson:** Together with the help of the others we were able to set up the different classes needed to display the shoes. The UI ended up looking much better than I had anticipated. Everyone towards the end was able to use their creativity to give the app a unique feel to it. 
      
4. **Learning and Growth:**
   Provide an example of how you applied a concept learned in class to a practical scenario. Describe how you used version control (like Git) to collaborate on a coding assignment, improving code organization and collaboration.
   - **Devin:** Trello allowed me to update team members of progress when working with Firebase and the login for our app. My team members could see at a glance what I had progressed with, as well as what I was doing/stuck on throughout the development process.
   - **Chayenne:** I gained experience with using GitHub. I learned how to commit files and create folders to place my code into for collaborative purposes. It was helpful to have everyone’s code in one place that was easily viewable.
   - **Alixson:** Learning how to use GitHub took a little getting used to be it was useful along the way. It allowed us to see what changes were made and who made them. If something stopped working or was not functioning properly, we could simply go back and look at the original code. 

## Product Showcase

### Elevator Pitch

Summarize your product's value proposition with relatable examples. For instance, explain how your app's streamlined user interface improves navigation for users, enhancing their overall experience.

_Meet Sole Seeker, your passport to hassle-free sneaker wins! With a seamless user journey, start by creating an account effortlessly. Once in, our sleek login screen welcomes you to a curated selection of exclusive sneakers. Are you ready to elevate your sneaker game? Enter the raffle, and if you're the lucky winner, securely purchase your dream sneakers right within the app. No frills, just thrills – that's Sole Seeker, your go-to for a straightforward path to coveted sneaker victories. Step into style, step into Sole Seeker._

### Product Demo

Share simple examples of your product's functionality:

  - **Example 1:** The user login accesses Firebase to authenticate our users, ensuring that the person accessing the account is the correct individual.
  - **Example 2:** When the user clicks on a shoe with a release date they are brought to that shoe's screen. The countdown timer will display how long until the shoe releases, as well as how long it is until the raffle closes and denies entry.
  - **Example 3:** When the user enters a raffle, they are given a number. If that number matches the winning number then they are informed through a pop up and can purchase the shoe directly from the pop up screen.

### Technical Architecture Overview

Simplify a technical concept with an example:

 - **Example 1:** Explain the client-server architecture by comparing it to a waiter taking orders (client) and a kitchen preparing food (server).
  - **Example 2:** To log in to our system, our app is connected to Firebase Authentication (server). The user must type in their username and password into our application (client) and it is verified when the data is sent to the server. 


### Codebase Exploration

Illustrate a coding concept with a relatable analogy:

  - **Example 1:** If the release date AND raffle end date AND release time AND raffle end time are not empty, a countdown timer is set up. If the current time is less than the release date time, it displays the time until the release date. If the current time is less than the raffle end time, it displays the time until the raffle will close. Otherwise, the raffle end time has passed the application displays that the dates have passed.

### Access Your Work

- **[Presentation Slides](link-to-presentation):** Share a link to your final presentation slides.
- **[Source Code Repository](link-to-repo):** Provide access to your source code repository.
- **Other Materials:** Include links to diagrams or documents you created for your project.

## Final Reflection Presentation

- **Duration:** 25-minute minimum, 40-minute maximum

## Career Readiness Assessment

Answer the following questions with practical examples:

1. **Team Collaboration Skills:** Reflect on a time when coordinating with team members improved a project's outcome or efficiency.
    - **Devin:** Meeting with Chayenne while we built the login screen was essential for me to successfully incorporate my code into hers, and make sure that what I coded worked with her code such as checking if an email was valid, but also make that email be communicated correctly to Firebase for authentication.
    - **Chayenne:** I was able to meet with Devin to go over the raffle example and how to possibly integrate it into our project. From there Devin was able to integrate the raffle system and showed me how he was able to do so. This helped me understand the integration process a little more which was something I had struggled with in this case.
    - **Alixson:** Communication between team members was very crucial in the last few weeks of school. When I stumbled across any problems someone was always available to help and debug. Whenever I was stuck someone was always willing to make time and help. 

3. **Problem-Solving Abilities:** Share a situation where you had to troubleshoot a technical issue and how you approached the problem-solving process.
    - **Devin:** I had never worked with UI before, just backend work. I took some example XML files from StackOverflow and pasted them into ChatGPT and had it explain the code to me, which allowed me to fully grasp how I could build UI within the application and make necessary edits.
    - **Chayenne:** In the beginning I had an issue with running code in Android Studio. I wasn’t familiar with the error messages so I looked them up and went through some forums. Through them I was able to eventually resolve the issues.
    - **Alixson:** For the first couple of weeks I had issues setting up Android Studios. It took me quite a bit to figure out what I was missing or what I was doing wrong. 
5. **Contributions to the Project:** Discuss a specific task you contributed to and how your involvement positively impacted the project's development.
    - **Devin:** Setting up the time/date for group meetings and ensuring everybody was available and kept up to speed was a way I helped foster communication with my group mates.
    - **Chayenne:** I contributed to the login system which was one of the main features of our app. It was important to get it ready early on so that it could get connected to the database. Having it done earlier on in the project’s development gave us more time to focus on other features.
    - **Alixson:** I contributed to setting up the raffle screen and storefront screen. Both Devin and Chayenne were able to get their tasks done early and they were able to integrate it with what I had. 
7. **Applied Knowledge:** Describe a technical concept learned in class that you've used in your project, highlighting its practical relevance.
    - **Chayenne:** We used user stories to help us have a clearer picture of how we wanted our app to function. User stories also allowed us to view things from the user's perspective, allowing for a more user-friendly interface.
    - **Devin** Learning about good development practices such as commenting more often, providing a uniform way to name methods and variables, and things of that nature allowed our code to easily be readable by anyone looking at the code.
    - **Alixson** Learning about Agile development and how much of a difference it could make in our end product. I have read that some companies use Agile to get a working product to a user and I can now see how much of a difference it can make for all the parties involved.
9. **Adaptability and Learning:** Provide an example of a challenge you faced that required learning a new skill or concept, and how you adapted to overcome it.
    - **Devin:** At first the idea of working with a database was a daunting task, as I was responsible for finding a way to authenticate users. In order to overcome it, I looked at YouTube videos and used StackOverflow to understand not only how to connect the database, but also how to add/remove and authenticate users for our login system. I also learned at the very beginning how to build a database (albeit in very simple terms) by communicating from the app to the database with code.
    - **Chayenne:** A challenge I faced was figuring out how to set up a timer in Android Studio. I had never used Android Studio prior to this project so I wasn’t familiar with all of the built-in classes. I watched some tutorials on youtube which helped me understand how to go about things. I also referred Android Studio’s developer guides online.
    - **Alixson:** I would say the hardest part for me was learning how to integrate other people's code into what I had. It was very overwhelming to see how many methods or classes were conflicting with one another. It took a lot of renaming and patience in order to get everything functioning properly.
