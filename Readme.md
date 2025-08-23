# 🏧 ATM Simulator System (Java AWT + JDBC + MySQL)

A simple **ATM Simulator System** built using **Java AWT** for the GUI and **JDBC** for database connectivity.  
This project demonstrates core ATM functionalities such as login, withdrawal, deposit, quick withdrawal, balance inquiry, PIN change, and transaction history.

---

## ✨ Features
- 🔑 **Login System** (Card No + PIN verification)
- 💰 **Deposit Money**
- 💸 **Withdraw Money**
- ⚡ **Quick Withdrawal** (predefined amounts)
- 🔍 **Balance Inquiry**
- 🔄 **Change PIN**
- 📜 **Transaction History / Mini Statement**

---

## 🛠️ Technologies Used
- **Java AWT** (GUI)
- **JDBC** (Database Connectivity)
- **MySQL** (Database)
- **IntelliJ IDEA** (Recommended IDE)

---

## 🗄️ Database Setup
1. Install MySQL and create a new database:
   ```sql
   CREATE DATABASE atm_system;
   USE atm_system;
   ```
2. create all tables:
   ```sql
   create table signup(ranNo varchar(20) primary key ,name varchar(20),father_name varchar(20), dob varchar(20),gender varchar(20),email varchar(30),marital_staus varchar(20),address varchar(40),city varchar(25),pincode varchar(20),state varchar(25));
   create table signuptwo(ranNo varchar(20),religion varchar(20),category varchar(20),income varchar(20),education varchar(20),occupation varchar(20),pan varchar(20),aadhar varchar(20),seniorcitizen varchar(20),existingaccount varchar(20), FOREIGN KEY(ranNo) REFERENCES signup(ranNo));
   create table signupthree(ranNo varchar(20),accountType varchar(30),cardnumber varchar(20),pin varchar(20),facility varchar(100), FOREIGN KEY(ranNo) REFERENCES signup(ranNo));
   create table user(cardnum varchar(20),pin varchar(10),ranNo varchar(20),ammount int , FOREIGN KEY (ranNo) REFERENCES signup(ranNo));
   create table bank(pin varchar(10),date varchar(50),type varchar(20),amount varchar(10));
   ```
