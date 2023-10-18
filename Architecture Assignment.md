# Key Architectural Decisions

## Table of Contents

- [Directions](#directions)
- [1. Introduction](#1-introduction)
  - [1.1. Purpose](#11-purpose)
- [2. System Overview](#2-system-overview)
- [3. Technical Choices](#3-technical-choices)
  - [3.1. Frontend Framework](#31-frontend-framework)
  - [3.2. Backend Framework](#32-backend-framework)
  - [3.3. Database System](#33-database-system)
- [4. Other Considerations](#4-other-considerations)
  - [4.1. Team Skills and Learning](#41-team-skills-and-learning)
  - [4.2. Community and Support](#42-community-and-support)
  - [4.3. Future Adaptability](#43-future-adaptability)
- [5. Decision Log](#5-decision-log)

## Directions:

This assignment is designed to guide you in understanding the foundational aspects of your project. Remember, in software engineering, understanding the "why" behind decisions is often as important as the decisions themselves. As you navigate these early stages of your coding journey, focus on grasping the core reasons behind each choice, and use this document to record and reflect on those reasons.

---

## 1. Introduction

### 1.1. Purpose

This document will provide a simple overview of how the app will be built and what we will use to build it.

---

## 2. System Overview

Provide a simple diagram or description of the high-level system.
Reference architecture-
	(diagram will go here)
<img width="766" alt="Screen Shot 2023-10-17 at 9 13 46 PM" src="https://github.com/devini01/CSCI401W-Fall2023-TeamGamma/assets/144073925/cbfb7eee-8a4b-4dcf-ae94-da3d2c06309d">


---

## 3. Technical Choices

### 3.1. Frontend Framework

Android Studios-  Everyone on the team is most comfortable coding in Java so we decided to use Android Studios since it supports it. Another thing that influenced our decision was the fact that the example we were given from a previous team used the same IDE and we as a team really liked their final deliverable. 

### 3.2. Backend Framework

Android Studios- For backend development we will also be coding in Java and will be using Android studios as an IDE. We know that languages such as Javascript are preferred, but we just do not feel comfortable simultaneously learning a new language and coding in it.

### 3.3. Database System

Firebase- Originally we were going to use MySQL. After some research we discovered that Android Studios will have issues connecting to MySQL. We then came across Firebase which is a NoSQL database. Firebase allows you to store and sync data between users in real time.


---

## 4. Other Considerations

### 4.1. Team Skills and Learning

We wanted to stick with Java since it was the language we were most comfortable with. None of us have had too much experience with XML, but it is something that we are looking forward to learning.


### 4.2. Community and Support

There are a lot of beginner-friendly tutorials for Android Studio and Firebase which made us feel more comfortable with using it. Java has been around for years so there are countless resources out there to further help us with this project.


### 4.3. Future Adaptability

It would be fairly easy to adapt/extend our technology choices. Both Java and XML have been around for many years and are still widely used. Android Studio gets updated regularly so it seems like it will be around for a long time. 

---

## 5. Decision Log

Here, you'll log key decisions made and the rationale behind them. Here's an example:

| Date       | Decision                                 | Reasoning                                                                                                           |
|------------|------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| 2023-10-10 | Chose Java as our frontend and backend framework.   | Our team decided on Java since it's what everyone on the team is most familiar with. There are plenty of videos and forums online we can use incase we get stuck at any point during development. |
| 2023-10-10 | Chose Android Studios as our IDE.     | During class Android Studios was recommended since the team wants to develop a mobile app. No one on the team has made an app before or used Android studios. There's a lot of resources available online and we feel confident in learning as we go.  |
| 2023-10-10 | Chose Firebase as our Database.   | We were set on using MySQL since a few members of the group are currently learning it. However, Firebase updates and syncs info in real time which works well with our app. The app will allow users to make purchases at any time so having a database that updates and syncs in such a manner works in our best interest.|
